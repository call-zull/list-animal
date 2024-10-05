package com.example.listanimal

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.example.listanimal.R.layout.activity_about
import com.example.listanimal.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    // Deklarasi elemen UI
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Isi dengan kode sesuai kebutuhan, contohnya:
        val name = resources.getString(R.string.about_name)
        val email = resources.getString(R.string.about_email)
        val imageResource = R.drawable.about

        // Set data ke tampilan
        binding.tvName.text = name
        binding.tvEmail.text = email
        binding.ivProfile.setImageResource(imageResource)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                // Aksi untuk menu "List"
                // Contoh: Navigasi atau tindakan yang sesuai
                startActivity(Intent(this, MainActivity::class.java))
                return true
            }
            R.id.action_about -> {
                // Aksi untuk menu "About" (sudah ada di halaman About, tidak perlu tindakan khusus)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
