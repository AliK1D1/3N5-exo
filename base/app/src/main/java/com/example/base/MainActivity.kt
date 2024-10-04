package com.example.base

import android.os.Bundle
import android.provider.MediaStore.Audio.Albums
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.base.databinding.ActivityMainBinding
import com.example.base.databinding.RecBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
       }
        setupRecycler()
        fillRecycler()
    }

    data class album(
        val id: Int,
        val name : String,
        val artistename : String,
    )

    private fun setupRecycler(){
        adapter = MonAdapter()
        binding.rvMonAdapter.adapter = adapter
        binding.rvMonAdapter.setHasFixedSize(true)
        binding.rvMonAdapter.addItemDecoration(DividerItemDecoration(binding.rvMonAdapter.context, DividerItemDecoration.VERTICAL))

    }

    private fun fillRecycler() {
        val  items : MutableList<String> = mutableListOf()
        val FIRST : MutableList<album> = mutableListOf()

        FIRST.add(album(1,"batterie faible", "Damso"))
        FIRST.add(album(2, "ADC", "Freeze corleone"))

        for(i in 0..FIRST.count())
        adapter.submitList(items)
    }


}