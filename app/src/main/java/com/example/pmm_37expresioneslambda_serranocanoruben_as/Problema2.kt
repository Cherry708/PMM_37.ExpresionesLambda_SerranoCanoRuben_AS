package com.example.pmm_37expresioneslambda_serranocanoruben_as

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmm_37expresioneslambda_serranocanoruben_as.databinding.ActivityMainBinding
import com.example.pmm_37expresioneslambda_serranocanoruben_as.databinding.ActivityProblema2Binding

class Problema2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problema2)

        val binding = ActivityProblema2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaEnteros = IntArray(10)
        for (i in listaEnteros.indices){
            listaEnteros[i] = (0..99).random()
        }

        val listaMultiplosDos = seMuestra(listaEnteros){entero -> entero % 2 == 0}
        val listaMultiplosTresCinco = seMuestra(listaEnteros){entero -> entero % 3 == 0 || entero % 5 == 0}
        val listaMayorIgualCincuenta = seMuestra(listaEnteros){entero -> entero >= 50}
        val listaEnRangos = seMuestra(listaEnteros){entero ->
            when(entero){
                in 1..10 -> true
                in 20..30 -> true
                in 90..95 -> true
                else -> false
            }
        }
        val listaCompleta = seMuestra(listaEnteros){entero -> true}

        val lista0 = "Lista múltiplos de dos "
        binding.tvLista0.text = lista0.plus(listaMultiplosDos.toString())
        val lista1 = "Lista múltiplos de tres y cinco "
        binding.tvLista1.text = lista1.plus(listaMultiplosTresCinco.toString())
        val lista2 = "Lista igual o mayor a cincuenta "
        binding.tvLista2.text = lista2.plus(listaMayorIgualCincuenta.toString())
        val lista3 = "Lista en rangos "
        binding.tvLista3.text = lista3.plus(listaEnRangos.toString())
        val lista4 = "Lista completa "
        binding.tvLista4.text = lista4.plus(listaCompleta.toString())



    }
    fun seMuestra(listaEnteros:IntArray, funcion:(integer:Int) -> Boolean): ArrayList<Int>{
        val listaMostar = arrayListOf<Int>()
        for (entero in listaEnteros){
            if (funcion(entero))
                listaMostar.add(entero)
        }
        return listaMostar
    }
}