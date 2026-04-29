package com.example.marvelapps.Home.Pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.marvelapps.R
import com.google.android.material.appbar.MaterialToolbar

class FifthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val btn = findViewById<Button>(R.id.btnWeb)

        btn.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.menu_about -> {
                Toast.makeText(this, "Halaman About", Toast.LENGTH_SHORT).show()
            }

            R.id.menu_dark -> {
                item.isChecked = !item.isChecked
                Toast.makeText(this, "Dark Mode: ${item.isChecked}", Toast.LENGTH_SHORT).show()
            }

            R.id.menu_notif -> {
                item.isChecked = !item.isChecked
                Toast.makeText(this, "Notifikasi: ${item.isChecked}", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}