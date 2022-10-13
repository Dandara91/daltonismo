package tadseaj.ufrn.testedaltonismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.drawable.toDrawable
import androidx.databinding.DataBindingUtil
import tadseaj.ufrn.testedaltonismo.databinding.ActivityMainBinding
import tadseaj.ufrn.testedaltonismo.databinding.ActivityRespostaBinding

class MainActivity : AppCompatActivity() {

    var desafioResposta = Resposta("","","")

    lateinit var binding: ActivityMainBinding


    val setResposta1launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            desafioResposta.r1 = result.data!!.getStringExtra("RESULTADO").toString()
        }else{
            Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
        }
    }

    val setResposta2launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            desafioResposta.r2 = result.data!!.getStringExtra("RESULTADO").toString()
        }else{
            Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
        }
    }

    val setResposta3launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            desafioResposta.r3 = result.data!!.getStringExtra("RESULTADO").toString()
        }else{
            Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonTeste1.setOnClickListener {

            val intent = Intent(this, RespostaActivity::class.java)

            val bundle = Bundle()

            bundle.putInt("imagem", R.drawable._4)
            intent.putExtras(bundle)

            setResposta1launcher.launch(intent)

        }

        binding.buttonTeste2.setOnClickListener {

            val intent = Intent(this, RespostaActivity::class.java)

            val bundle = Bundle()

            bundle.putInt("imagem", R.drawable._7)
            intent.putExtras(bundle)

            setResposta2launcher.launch(intent)

        }

        binding.buttonTeste3.setOnClickListener {

            val intent = Intent(this, RespostaActivity::class.java)

            val bundle = Bundle()

            bundle.putInt("imagem", R.drawable._8)
            intent.putExtras(bundle)

            setResposta3launcher.launch(intent)

        }

        binding.buttonResultado.setOnClickListener{

            val resultado = desafioResposta.resuldadoResposta()
            if (resultado.equals("Você deixou algum desafio em branco")) {
                Toast.makeText(this, desafioResposta.resuldadoResposta(), Toast.LENGTH_SHORT).show()
                binding.textViewResultado.text = ""
            } else {
                binding.textViewResultado.text = desafioResposta.resuldadoResposta()
            }

            /*binding.textViewResultado.text = desafioResposta.resuldadoResposta()*/

        }
    }

    override fun onResume() {
        super.onResume()
        binding.rd = desafioResposta
    }
}