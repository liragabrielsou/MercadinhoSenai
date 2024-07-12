package com.example.mercadinhosenai

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mercadinhosenai.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listProduct = ArrayList<Product>()


        binding.registerButton.setOnClickListener {
            var nameProd = binding.inputNameProd.text.toString().trim()
            var descriProd = binding.inputDescriptionProd.text.toString().trim()
            var valueProd = binding.inputValueProd.text.toString().trim()

            if(!binding.inputNameProd.text.toString().trim().isEmpty()
                && !binding.inputNameProd.text.toString().trim().isEmpty()
                && !binding.inputNameProd.text.toString().trim().isEmpty()){

            }

        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}