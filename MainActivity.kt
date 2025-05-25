package com.example.urbanorganicfarming

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        // Spinner setup
        val zoneSpinner: Spinner = findViewById(R.id.spinnerZone)
        val zones = arrayOf("Urban", "Rural", "Peri-Urban")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, zones)
        zoneSpinner.adapter = adapter

// (Optional) Spinner action
        zoneSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedZone = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, "Selected: $selectedZone", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
        val etSearch = findViewById<EditText>(R.id.etSearchPlant)
        etSearch.setOnEditorActionListener { _, _, _ ->
            val query = etSearch.text.toString()
            Toast.makeText(this, "Searching: $query", Toast.LENGTH_SHORT).show()
            true
        }
        val imgAloe = findViewById<ImageView>(R.id.imgAloeVera)
        val imgTulsi = findViewById<ImageView>(R.id.imgTulsi)

        imgAloe.setOnClickListener {
            startActivity(Intent(this, AloeVeraActivity::class.java))
        }

        imgTulsi.setOnClickListener {
            startActivity(Intent(this, TulsiActivity::class.java))
        }




        // Request location permission
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            LOCATION_PERMISSION_REQUEST_CODE
        )

        // Button to About Page
        findViewById<Button>(R.id.btnAbout).setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        // Button to Plant DB
        findViewById<Button>(R.id.btnPlantDB).setOnClickListener {
            startActivity(Intent(this, PlantDatabaseActivity::class.java))
        }

        // Button to Tips
        findViewById<Button>(R.id.btnTips).setOnClickListener {
            startActivity(Intent(this, TipsActivity::class.java))
        }

        // Button to Maps
        findViewById<Button>(R.id.btnMarkets).setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }

        // Button to Contact
        findViewById<Button>(R.id.btnContact).setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        }
        findViewById<Button>(R.id.btnVideo).setOnClickListener {
            startActivity(Intent(this, VideoTutorialActivity::class.java))
        }
        findViewById<Button>(R.id.btnSoilAwareness).setOnClickListener {
            startActivity(Intent(this, SoilAwarenessActivity::class.java))
        }
        findViewById<Button>(R.id.btnCommonProblems).setOnClickListener {
            startActivity(Intent(this, CommonProblemsActivity::class.java))
        }




    }
}
