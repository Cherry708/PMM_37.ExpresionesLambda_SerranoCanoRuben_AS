package com.example.pmm_37expresioneslambda_serranocanoruben_as

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmm_37expresioneslambda_serranocanoruben_as.databinding.ActivityProblema3Binding

class Problema3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problema3)

        val binding = ActivityProblema3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val mensaje = "Esta es la String completa!"

        val stringVocales = caracteresValidos(mensaje){ c ->
            if (c == 'a' || c == 'A')
                return@caracteresValidos true
            else if(c == 'e' || c == 'E')
                return@caracteresValidos true
            else if (c == 'i' || c == 'I')
                return@caracteresValidos true
            else if(c == 'o' || c == 'O')
                return@caracteresValidos true
            else
                return@caracteresValidos c == 'u'|| c == 'U'
        }

        val stringMinusculas = caracteresValidos(mensaje){ c ->
            when(c){
                c -> c.isLowerCase()
                else -> false
            }
        }

        val stringNoAlfabetico = caracteresValidos(mensaje){ c ->
            c !in 'a'..'z' && c !in 'A'..'Z'
        }


        val resultado0 = "String de vocales: $stringVocales"
        val resultado1 = "String de minúsculas: $stringMinusculas"
        val restultado2 = "String no alfabético: $stringNoAlfabetico"

        binding.tvString0.text = mensaje
        binding.tvString1.text = resultado0
        binding.tvString2.text = resultado1
        binding.tvString3.text = restultado2
    }
    fun caracteresValidos(mensaje: String, funcion: (Char) -> Boolean): String {
        var stringValido = ""
        for(caracter in mensaje)
            if (funcion(caracter))
                stringValido += (caracter.toString())
        return stringValido
    }

}