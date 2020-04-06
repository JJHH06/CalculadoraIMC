package com.example.calculadoraimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_next.*
//Jose Hurtarte 19707
class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        var imc_result = intent.extras?.get("imc_final")

        imc_result = "%.1f".format(imc_result)
        imc_final_text.setText(imc_result) //para pasar a texto
        imc_result = imc_result.toFloat() //para poder comparar

        // Datos de IMC obtenidos de http://www.clinicavespucio.cl/calculo-del-imc/
        if (imc_result < 16.00){
            imc_description.setText("Delgadez severa, Visite un medico URGENTEMENTE")
            image_imc_result.setImageResource(R.drawable.delgadez_severa)
        }
        else if(imc_result < 18.50){
            imc_description.setText("Bajo peso, deberia de mejorar su dieta")
            image_imc_result.setImageResource(R.drawable.delgadez_moderada)
        }
        else if(imc_result < 25.00){
            imc_description.setText("Peso ideal, usted esta saludable, siga asi!")
            image_imc_result.setImageResource(R.drawable.peso_ideal)
        }
        else if(imc_result < 30.00){
            imc_description.setText("Sobrepeso, deberia de mejorar su dieta")
            image_imc_result.setImageResource(R.drawable.sobrepeso)
        }
        else{
            imc_description.setText("Obesidad, por su salud vaya a un medico rapido")
            image_imc_result.setImageResource(R.drawable.obesidad)

        }

    }
}
