package com.example.to_do_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.to_do_list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todos: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        binding.dynamicList.adapter = adapter

        binding.dynamicList.setOnItemClickListener { parent, view, position, id ->
            val removedText=binding.dynamicList.getItemAtPosition(position).toString()
            adapter.remove(removedText)
            Toast.makeText(this, "remove: $removedText", Toast.LENGTH_LONG).show()
        }

        binding.button.setOnClickListener {
            val text = binding.userData.text.toString().trim()
            adapter.insert(text, 0)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}