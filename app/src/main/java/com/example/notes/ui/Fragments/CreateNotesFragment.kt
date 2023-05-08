package com.example.notes.ui.Fragments

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notes.R
import com.example.notes.databinding.FragmentCreateNotesBinding

class CreateNotesFragment : Fragment() {

    lateinit var binder: FragmentCreateNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binder = FragmentCreateNotesBinding.inflate(layoutInflater, container, false)


        return binder.root
    }

}