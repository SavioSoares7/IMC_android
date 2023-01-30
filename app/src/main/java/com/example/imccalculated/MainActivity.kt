package com.example.imccalculated

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.imccalculated.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        calculate()
    }

    private fun isValid() : Boolean{
        return (binding.editHeight.text.toString() != ""
                && binding.editWeight.text.toString() != ""
                && binding.editHeight.text.toString().toFloat() >= 0
                && binding.editWeight.text.toString().toFloat() >= 0)
    }

    private fun calculate() {

        if(isValid()){
            var height = binding.editHeight.text.toString().toFloat()
            var weight = binding.editWeight.text.toString().toFloat()
            val imc = weight / Math.pow(height.toDouble(), 2.0)

            if(imc < 18.5){
                binding.textInformation.text = "Magreza \n (IMC: ${"%.2f".format(imc)})"
            }
            else if(imc >= 18.5 && imc <= 24.9){
                binding.textInformation.text = "Normal \n (IMC: ${"%.2f".format(imc)})"
            }
            else if(imc >= 25 && imc <= 29.9){
                binding.textInformation.text = "Sobrepeso \n (IMC: ${"%.2f".format(imc)})"
            }
            else if(imc >= 30 && imc <= 39.9){
                binding.textInformation.text = "Obesidade \n (IMC: ${"%.2f".format(imc)})"
            }
            else if(imc >= 40){
                binding.textInformation.text = "Obesidade Grave \n (IMC: ${"%.2f".format(imc)})"
            }
        }
        else {
            Toast.makeText(this, "Preencha todos os campos ou Informe valor maior que 0", Toast.LENGTH_SHORT).show()

        }
    }
}