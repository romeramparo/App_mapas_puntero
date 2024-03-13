package com.example.tarea9_practica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class map : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap:GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        createFragment()
    }

    private fun createFragment() {
        val mapFragment : SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val extras = intent.extras
        if (extras != null) {
            val latitud = extras.getString("LATITUD")!!.toDouble()
            val longitud = extras.getString("LONGITUD")!!.toDouble()
            val nombre = extras.getString("NOMBRE").toString()
            val apellido = extras.getString("APELLIDO").toString()

            createMarker(latitud, longitud, nombre, apellido)
        }

    }

    private fun createMarker(latitud: Double, longitud: Double, nombre: String, apellido: String){
        val coordinates = LatLng(latitud, longitud)
        val marker : MarkerOptions = MarkerOptions().position(coordinates).title("$nombre $apellido")
        mMap.addMarker(marker)
        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f), 4000, null
        )
    }


}
