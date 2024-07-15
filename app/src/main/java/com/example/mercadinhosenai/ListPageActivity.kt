package com.example.mercadinhosenai

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mercadinhosenai.databinding.ActivityListPageBinding
import com.google.android.material.snackbar.Snackbar

class ListPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListPageBinding
      private var position = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListPageBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val intentList = intent
        val listItens = intentList.getSerializableExtra("list") as ArrayList<Product?>

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItens)
        binding.listaItens.adapter = adapter

        binding.listaItens.setOnItemClickListener { parent, view, position, id ->
            binding.inputName.setText(listItens.get(position)?.name)
            binding.inputDescription.setText(listItens.get(position)?.description)
            binding.inputValue.setText(listItens.get(position)?.value)
            this.position = position
        }

        binding.editButton.setOnClickListener {
            if (position >= 0 && (!binding.inputName.text.toString().trim().isEmpty() ||
                        !binding.inputDescription.text.toString().trim().isEmpty() ||
                        !binding.inputValue.text.toString().trim().isEmpty())
            ) {
                listItens.get(position)?.name = binding.inputName.text.toString()
                listItens.get(position)?.description = binding.inputDescription.text.toString()
                listItens.get(position)?.value = binding.inputValue.text.toString()

                adapter.notifyDataSetChanged()

                binding.inputName.setText("")
                binding.inputDescription.setText("")
                binding.inputValue.setText("")

                position = -1
            } else {
            }
        }

            binding.deleteButton.setOnClickListener {
                if (position >= 0 && (!(binding.inputName.text.toString() != listItens.get(position)?.name)  ||
                            !(binding.inputDescription.text.toString() != listItens.get(position)?.description) ||
                            !(binding.inputValue.text.toString() != listItens.get(position)?.value))){

                    listItens.remove(listItens.get(position))

                    adapter.notifyDataSetChanged()

                    binding.inputValue.setText("")
                    binding.inputName.setText("")
                    binding.inputDescription.setText("")
                    position = -1
                }else{
                    Snackbar.make(binding.root, "Selecione um item!", Snackbar.LENGTH_LONG)
                        .setBackgroundTint(resources.getColor(R.color.DarkRed))
                        .setTextColor(resources.getColor(R.color.white))
                        .show()
                }
            }

        }

    }
