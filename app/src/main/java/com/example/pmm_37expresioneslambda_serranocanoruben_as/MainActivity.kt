package com.example.pmm_37expresioneslambda_serranocanoruben_as

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmm_37expresioneslambda_serranocanoruben_as.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val suma = operar(2,5) { int0, int1 -> int0 + int1 }
        val resta = operar (3, 1) { int0, int1 -> int0 - int1 }
        val potencia = operar(2,3) { integer0, integer1 ->
            (integer0.toDouble().pow(integer1)).toInt()
        }

        val resultadoSuma = "Suma operar(2,5) { int0, int1 -> int0 + int1 }: $suma"
        val resultadoResta = "Resta operar(3, 1) { int0, int1 -> int0 - int1 }: $resta"
        val resultadoPotencia = "Potencia operar(2,3) { integer0, integer1 -> " +
                "(integer0.toDouble().pow(integer1)).toInt()" +
                " }: $potencia"

        binding.tvResultado10.text = resultadoSuma
            .plus("\n"+resultadoResta)
            .plus("\n$resultadoPotencia")
    }
    fun operar(int0:Int,int1:Int, fn:(integer0:Int,integer1:Int)-> Int): Int{
        return fn(int0,int1)
    }
}