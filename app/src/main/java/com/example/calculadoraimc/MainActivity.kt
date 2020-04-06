package com.example.calculadoraimc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow
//Jose Hurtarte 19707
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        process_button.setOnClickListener{ //No se necesita buscar dentro de los xml
            if(!(weight_number.text.toString().isNullOrEmpty()) && !(height_number.text.toString().isNullOrEmpty())){   //Si se cumple esto es porque las entradas no estan vacias
                if (comprobarIntervalo()){ // una vez llegue a este punto ya se puede empezar a calcular
                    var intent = Intent(this, NextActivity::class.java)  //Intent para otra activity
                    intent.putExtra("imc_final",IMC((weight_number.text.toString().toDouble()/2.2),(height_number.text.toString().toDouble()/100)))
                    startActivity(intent)



                }
                else{ // si llega aca es porque los numeros son invalidos
                    Toast.makeText(this, "Ingrese numeros entre 1 y 270", Toast.LENGTH_LONG).show()
                }
            }
            else{ //si llega aca es porque alguna entrada esta vacia
                Toast.makeText(this, "Ingrese numeros En los campos", Toast.LENGTH_LONG).show()
            }
        }
        process_button.setOnLongClickListener{
            Toast.makeText(this, "IMC = Peso (Kg) / (Estatura (Mt))^2", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
    }

    /**
     * Comprueba que las 2 entradas esten entre 1 y 270
     */
    private fun comprobarIntervalo(): Boolean{
        var resultado1 : Boolean = false
        var resultado2 : Boolean = false
        if ( (weight_number.text.toString().toFloat() <= 270) &&  (weight_number.text.toString().toFloat() >= 1)){
            resultado1 = true
        }
        if ( (height_number.text.toString().toFloat() <= 270) &&  (height_number.text.toString().toFloat() >= 1)){
            resultado2 = true
        }
        return (resultado1 && resultado2)
    }


    /**
     * Devuelve el indice de masa corporal de los parametros indicados
     */
    private fun IMC(peso: Double, altura: Double): Float{
        return (peso/(altura.pow(2.0))).toFloat()
    }




}
