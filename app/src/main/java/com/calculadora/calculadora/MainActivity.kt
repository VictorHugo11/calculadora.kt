package com.calculadora.calculadora
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.calculadora.calculadora.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.numeroZero.setOnClickListener {
            AcrescentarUmaExpressao("0", true)
        }
        binding.numeroUm.setOnClickListener {
            AcrescentarUmaExpressao("1", true)
        }
        binding.numeroDois.setOnClickListener {
            AcrescentarUmaExpressao("2", true)
        }
        binding.numeroTres.setOnClickListener {
            AcrescentarUmaExpressao("3", true)
        }
        binding.numeroQuatro.setOnClickListener {
            AcrescentarUmaExpressao("4", true)
        }
        binding.numeroCinco.setOnClickListener {
            AcrescentarUmaExpressao("5", true)
        }
        binding.numeroSeis.setOnClickListener {
            AcrescentarUmaExpressao("6", true)
        }
        binding.numeroSete.setOnClickListener {
            AcrescentarUmaExpressao("7", true)
        }
        binding.numeroOito.setOnClickListener {
            AcrescentarUmaExpressao("8", true)
        }
        binding.numeroNove.setOnClickListener {
            AcrescentarUmaExpressao("9", true)
        }
        binding.ponto.setOnClickListener {
            AcrescentarUmaExpressao(".", true)
        }

        //operadores
        binding.soma.setOnClickListener {
            AcrescentarUmaExpressao("+", false)
        }
        binding.subtracao.setOnClickListener {
            AcrescentarUmaExpressao("-", false)
        }
        binding.multiplicacao.setOnClickListener {
            AcrescentarUmaExpressao("*", false)
        }
        binding.divisao.setOnClickListener {
            AcrescentarUmaExpressao("/", false)
        }

        binding.limpar.setOnClickListener {
            binding.expressao.text = ""
            binding.txtResultado.text = ""
        }

        binding.backspace.setOnClickListener{

            val string = binding.expressao.text.toString()

            if (string.isNotBlank()){
                binding.expressao.text = string.substring(0, string.length - 1)
            }
            binding.txtResultado.text = ""
        }

        binding.igual.setOnClickListener{

            try {
                val expressao = ExpressionBuilder(binding.expressao.text.toString()).build()

                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()

                if (resultado == longResult.toDouble())
                    binding.txtResultado.text = longResult.toString()
                else
                    binding.txtResultado.text = resultado.toString()

            }catch (e: Exception){

            }
        }


    }

    fun AcrescentarUmaExpressao(string: String, limpar_dados: Boolean) {

        if (binding.txtResultado.text.isNotEmpty()) {
            binding.expressao.text = ""
        }

        if (limpar_dados) {
            binding.txtResultado.text = ""
            binding.expressao.append(string)
        }else{
            binding.expressao.append(binding.txtResultado.text)
            binding.expressao.append(string)
            binding.txtResultado.text = ""
        }
    }
}