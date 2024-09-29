package com.example.semana03

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.semana03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        * binding es inicializada con ActivityMainBinding.inflate(layoutInflater)
        *  para hacer referencia a los elementos definidos en el layout XML (activity_main.xml).
        * */

        binding = ActivityMainBinding.inflate(layoutInflater)

        // Ajustan la actividad en pantalla completa (hasta la barra de notificaciones)
        enableEdgeToEdge()
        setContentView(binding.root) // permite trasladarte a las diferentes actividades/ vistas
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*
        * Define un listener para el botón, cuando hagamos clic se ejecutará el codigo de adentro
        * En este caso:
        * Hay que obtener la data y mandarlo a otra vista
        * */
        binding.btnAction.setOnClickListener {
            val textToShow = "${binding.etNombre.text}: ${binding.etnNota1.text}"
            //Como mostrar la informacaion por medio de un "toast"
            //Toast.makeText(this, textToShow, Toast.LENGTH_LONG).show() //<--Duracion al momento de mostrar
            Utils.showToast(this,textToShow)

            var ep1: Int = binding.etnNota1.text.toString().toInt()

            if(binding.rbAdd.isChecked){
                ep1 += 1
            }

            // El intent permiite que la actividad "Destino reciba los valores actualizados"
            val newView = Intent(this, Destino::class.java)
            newView.putExtra("nombre","${binding.etNombre.text}")
            newView.putExtra("ep1","$ep1") // Se modifico al de la variavle ep1 por que puede darse el incremento en 1
            newView.putExtra("ep2","${binding.etNota2.text}")
            startActivity(newView)

        }

    }

}