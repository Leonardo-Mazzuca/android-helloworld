package leonardomazzuca.com.github.helloworld

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    /*
           Podemos dizer que isso se equipara ao document.getElementById do JS
           Dentro dos <> passar o tipo de elemento
           O R é a variavél que acessa o layout
           Caso já tenhamos algum elemento com o id, o auto-complete será realizado
     */


        val inputName = findViewById<EditText>(R.id.etName);
        val message = findViewById<TextView>(R.id.textViewHello);

//        Podemos pensar que isso seria igual a um listener de input do JS
        inputName.setOnEditorActionListener{textView, actionId, _ ->

            //constânte para identificar que ação foi concluída
            if(actionId == EditorInfo.IME_ACTION_DONE) {

                //Limpa espaços em branco com método trim()
                val name = textView.text.toString().trim()

                //if inline aqui para escrever menos código, parecido com operador ternário
                message.text = if (name.isNotEmpty()) "Hello world! $name" else "Hello world!"

                /*
                    Mesma coisa que

                    if (name.isNotEmpty()) {
                        message.text = "Hello world! $name"
                    } else {
                        message.text = "Hello world!"
                    }
                */


                //indicação de que a ação foi tratada no listener
                true
            } else {
                //indicação de que a ação não foi tratada no listener
                false
            }

        }
    }


}