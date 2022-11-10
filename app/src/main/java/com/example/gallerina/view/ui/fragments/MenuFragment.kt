package com.example.gallerina.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import com.example.gallerina.R


class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cardCinema=view.findViewById<CardView>(R.id.fragCine)
        cardCinema.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_cinemaFragment)
        }
        val cardMusic=view.findViewById<CardView>(R.id.fragMusic)
        cardMusic.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_musicFragment)

        }
        val cardFave=view.findViewById<CardView>(R.id.fragfav)
        cardFave.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_faveFragment)
        }
        val cardTheater=view.findViewById<CardView>(R.id.fragTeatro)
        cardTheater.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_theaterFragment)
        }
        val cardExpo=view.findViewById<CardView>(R.id.fragFood)
        cardExpo.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_expoFragment)
        }
        val cardMuseum=view.findViewById<CardView>(R.id.fragMuseum)
        cardMuseum.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_museumFragment)
        }
    }

    }
