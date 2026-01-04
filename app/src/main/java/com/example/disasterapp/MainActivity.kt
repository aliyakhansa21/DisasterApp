package com.example.disasterapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disasterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(nameDisaster = "Tsunami", disasterType = "Natural",
                icon = R.drawable.baseline_local_fire_department_24),
            Disaster(nameDisaster = "Volcanic Eruption", disasterType =
                "Natural", icon = R.drawable.baseline_local_fire_department_24),
            Disaster(nameDisaster = "Earthquake", disasterType = "Natural",
                icon = R.drawable.baseline_local_fire_department_24),
            Disaster(nameDisaster = "Flood", disasterType = "Natural",
                icon = R.drawable.baseline_local_fire_department_24),
            Disaster(nameDisaster = "Fire", disasterType = "Natural",
                icon = R.drawable.baseline_local_fire_department_24),
            Disaster(nameDisaster = "Nuclear Accident", disasterType = "Man-made",
                icon = R.drawable.baseline_local_fire_department_24),
            Disaster(nameDisaster = "Terrorist Attack", disasterType = "Man-made",
                icon = R.drawable.baseline_local_fire_department_24),
            Disaster(nameDisaster = "War", disasterType = "Man-made",
                icon = R.drawable.baseline_local_fire_department_24)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterDisaster = DisasterAdapter(generateDummy()) { disaster ->
            Toast.makeText(this@MainActivity, "You clicked on ${disaster.nameDisaster}",
                Toast.LENGTH_SHORT).show()
        }
        with(binding) {
            // Linear layout manager
//            rvDisaster.apply {
//                adapter = adapterDisaster
//                layoutManager = LinearLayoutManager(this@MainActivity)
//            }

            // Grid layout manager
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }
}