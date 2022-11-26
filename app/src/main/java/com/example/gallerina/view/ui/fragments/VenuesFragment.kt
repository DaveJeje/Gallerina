package com.example.gallerina.view.ui.fragments

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.gallerina.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.checkerframework.common.subtyping.qual.Bottom
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.config.Configuration
import org.osmdroid.library.BuildConfig



class VenuesFragment : Fragment(),OnMapReadyCallback {
    lateinit var googleMap: GoogleMap
    companion object{
        const val REQUEST_CODE_LOCATION=0
    }

    lateinit var mapView: MapView
    lateinit var butMuseoNal: Button
    lateinit var butCinemateca: Button
    lateinit var butCasaEnsamble: Button
    lateinit var butLeon: Button
    lateinit var butMambo: Button
    lateinit var butTeatroColon: Button
    lateinit var butBiblioTintal: Button
    lateinit var butBiblioVirgilio: Button
    lateinit var bottomNavigationView:BottomNavigationView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_venues, container, false)
        return view
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Identifica su aplicación de forma exclusiva para los servidores de mosaicos

        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //Google
        val mapFragment=this.childFragmentManager.findFragmentById(R.id.mapGoogle) as SupportMapFragment
        mapFragment.getMapAsync(this)


        bottomNavigationView=view.findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener{item ->
            when(item.itemId){
                R.id.nav_home-> findNavController().navigate(R.id.action_venuesFragment_to_menuFragment)

                R.id.nav_fav-> findNavController().navigate(R.id.action_venuesFragment_to_faveFragment)

                R.id.nav_venue-> null

                //R.id.nav_settings-> replaceFragment()



                else->{}

            }


            true

        }

        /*OpenStreet
        mapView= view.findViewById(R.id.mapOpenStreet)
        mapView.setTileSource(TileSourceFactory.MAPNIK)


        val geoPoint = GeoPoint(5.070275,-75.513817)
        val mapController = mapView.controller
        mapController.setZoom(16.0)
        mapController.setCenter(geoPoint)

        val marker= Marker(mapView)
        marker.setPosition(geoPoint)
        marker.setAnchor(Marker.ANCHOR_CENTER,Marker.ANCHOR_BOTTOM)
        marker.setTitle("Gallerina")
        mapView.overlays.add(marker)*/


    }
    @SuppressLint("")
    override fun onMapReady(map: GoogleMap) {
        val geomarkerCinemateca= LatLng(4.603334587000853, -74.06770354466607)
        val geomarkerMuseoNal=LatLng(4.615749053662715, -74.06829773207208)
        val geomarkerMambo=LatLng(4.612120763161378, -74.06942316132144)
        val geomarkerBiblioTintal=LatLng(4.6256651790525325, -74.13021151031006)
        val geomarkerBiblioVirgilio=LatLng(4.6572741043941, -74.0885386598046)
        val geomarkerTeatroColon=LatLng(4.596773539922675, -74.07444155980473)
        val geomarkerCasaEnsamble=LatLng(4.6320499077196216, -74.07617746669081)
        val geomarkerLeonGreiff=LatLng(4.635841806067498, -74.08226842698353)
        val zoom= 15f

        map.let {
            this.googleMap= it
            map.addMarker(MarkerOptions()
                .position(geomarkerCinemateca)
                .title("Cinematéca Distrital"))
        }
        enableLocation()
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(geomarkerCinemateca, zoom))
        butMuseoNal= requireView().findViewById(R.id.butMuseoNal)
        butMuseoNal.setOnClickListener{
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(geomarkerMuseoNal, zoom))
            map.addMarker(MarkerOptions()
                .position(geomarkerMuseoNal)
                .title(getString(R.string.museoNalVenue)))
        }

        butBiblioTintal= requireView().findViewById(R.id.butBiblioTintal)
        butBiblioTintal.setOnClickListener{
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(geomarkerBiblioTintal, zoom))
            map.addMarker(MarkerOptions()
                .position(geomarkerBiblioTintal)
                .title(getString(R.string.bibTintalVenue)))
        }

        butLeon= requireView().findViewById(R.id.butLeon)
        butLeon.setOnClickListener{
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(geomarkerLeonGreiff, zoom))
            map.addMarker(MarkerOptions()
                .position(geomarkerLeonGreiff)
                .title(getString(R.string.unalVenue)))
        }

        butMambo= requireView().findViewById(R.id.butMambo)
        butMambo.setOnClickListener{
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(geomarkerMambo, zoom))
            map.addMarker(MarkerOptions()
                .position(geomarkerMambo)
                .title(getString(R.string.mamboVenue)))
        }

        butBiblioVirgilio= requireView().findViewById(R.id.butBiblioVirgilio)
        butBiblioVirgilio.setOnClickListener{
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(geomarkerBiblioVirgilio, zoom))
            map.addMarker(MarkerOptions()
                .position(geomarkerBiblioVirgilio)
                .title(getString(R.string.bibVirgilioVenue)))
        }

        butCasaEnsamble= requireView().findViewById(R.id.butCasaEnsamble)
        butCasaEnsamble.setOnClickListener{
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(geomarkerCasaEnsamble, zoom))
            map.addMarker(MarkerOptions()
                .position(geomarkerCasaEnsamble)
                .title(getString(R.string.casaEnsambleVenue)))
        }

        butTeatroColon= requireView().findViewById(R.id.butTeatroColon)
        butTeatroColon.setOnClickListener{
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(geomarkerTeatroColon, zoom))
            map.addMarker(MarkerOptions()
                .position(geomarkerTeatroColon)
                .title(getString(R.string.teatroColonVenue)))
        }


        butCinemateca= requireView().findViewById(R.id.butCinemateca)
        butCinemateca.setOnClickListener{
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(geomarkerCinemateca, zoom))

        }


    }

    fun isLocationPermissionGranted()=ContextCompat.checkSelfPermission(
        this.requireContext(),android.Manifest.permission.ACCESS_FINE_LOCATION

    )==PackageManager.PERMISSION_GRANTED

    fun requestLocationPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this.requireActivity(),
            android.Manifest.permission.ACCESS_FINE_LOCATION)){
            Toast.makeText(this.context,"Activar permisos de ubicación",Toast.LENGTH_LONG).show()
        }else{
            ActivityCompat.requestPermissions(this.requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
            com.example.gallerina.view.ui.fragments.VenuesFragment.Companion.REQUEST_CODE_LOCATION)
        }
    }

    @SuppressLint("MissingPermission")
    fun enableLocation(){
        if (!::googleMap.isInitialized)return
        if (isLocationPermissionGranted()){
            googleMap.isMyLocationEnabled=true
        }else{
            requestLocationPermission()
        }
    }

}