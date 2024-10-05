package com.example.listanimal

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.listanimal.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var dataAnimal: Animal? = null

    companion object {
        const val EXTRA_ANIMAL = "extra_animal"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataAnimal = intent.getParcelableExtra(EXTRA_ANIMAL)

        // Menampilkan data ke layout
        Glide.with(this).load(dataAnimal?.photo).into(binding.ivDetailPhoto)
        binding.tvDetailName.text = dataAnimal?.name
        binding.tvDetailDescription.text = dataAnimal?.description

        binding.actionShare.setOnClickListener {
            shareData()
        }
    }

    private fun shareData() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Animal Detail")
        shareIntent.putExtra(
            Intent.EXTRA_TEXT,
            "Name: ${dataAnimal?.name}\nDescription: ${dataAnimal?.description}"
        )

        startActivity(Intent.createChooser(shareIntent, "Share using"))
    }
}
