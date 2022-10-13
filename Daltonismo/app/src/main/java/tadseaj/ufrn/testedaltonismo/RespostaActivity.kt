package tadseaj.ufrn.testedaltonismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import tadseaj.ufrn.testedaltonismo.databinding.ActivityMainBinding
import tadseaj.ufrn.testedaltonismo.databinding.ActivityRespostaBinding

class RespostaActivity : AppCompatActivity() {

    lateinit var binding: ActivityRespostaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_resposta)

       // val imagem = intent.extras?.getInt("imagem")
       // binding.imageBoneco.setImageResource(imagem!!)

        binding.imageBoneco.setImageResource(intent.extras!!.getInt("imagem"))


        binding.buttonOkResposta.setOnClickListener{

            val intent = Intent()
            val bundle = Bundle()

            bundle.putString("RESULTADO", binding.editTextResposta.text.toString())
            intent.putExtras(bundle)
            setResult(RESULT_OK, intent)
            finish()

        }

        binding.buttonCancelar.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

    }
}