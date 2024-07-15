package com.example.mercadinhosenai

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mercadinhosenai.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listProduct = ArrayList<Product>()


        //Evento do botão para cadastrar produto
        binding.registerButton.setOnClickListener {

            var nameProd = binding.inputNameProd.text.toString()
            var descriProd = binding.inputDescriptionProd.text.toString()
            var valueProd = binding.inputValueProd.text.toString()

            if(!nameProd.isEmpty()
                && !descriProd.isEmpty()
                && !valueProd.isEmpty()){
                //Adiciona os dados a Array do Objeto Produto
                listProduct.add(
                    Product(nameProd,
                            descriProd,
                            valueProd
                    )
                )
                binding.inputNameProd.setText("")
                binding.inputValueProd.setText("")
                binding.inputDescriptionProd.setText("")
            }else {
                Snackbar.make(binding.root, "Preencha todos os campos!", Snackbar.LENGTH_LONG)
                    .setBackgroundTint(resources.getColor(R.color.DarkRed))
                    .setTextColor(resources.getColor(R.color.white))
                    .show()
            }
        }

        binding.listIntentButton.setOnClickListener{
            val intentList = Intent(this,ListPageActivity::class.java)

            intentList.putExtra("list",listProduct as Serializable)
            startActivity(intentList)
        }

    }
}
