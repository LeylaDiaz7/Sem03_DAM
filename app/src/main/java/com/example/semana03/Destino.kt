package com.example.semana03

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.semana03.databinding.ActivityDestinoBinding
import com.example.semana03.databinding.ActivityMainBinding

class Destino : AppCompatActivity() {

    private lateinit var binding: ActivityDestinoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDestinoBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombre = intent.getStringExtra("nombre") ?: "no hay data"
        val ep1 = intent.getStringExtra("ep1") ?: "no hay data"
        val ep2 = intent.getStringExtra("ep2") ?: "no hay data"

        binding.txtResultado.text = "$nombre\nEP1: $ep1\nEP2: $ep2"
    }
}