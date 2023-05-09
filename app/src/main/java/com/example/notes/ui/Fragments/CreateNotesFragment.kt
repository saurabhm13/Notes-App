package com.example.notes.ui.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.notes.R
import com.example.notes.ViewModel.NotesViewModel
import com.example.notes.ViewModel.NotesViewModelFactory
import com.example.notes.data.db.Entity.Notes
import com.example.notes.databinding.FragmentCreateNotesBinding
import java.text.SimpleDateFormat
import java.util.Date

class CreateNotesFragment : Fragment() {

    private lateinit var binder: FragmentCreateNotesBinding
    var priority: String = "1"

    val notesViewModel: NotesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binder = FragmentCreateNotesBinding.inflate(layoutInflater, container, false)

        binder.createDoneFab.setOnClickListener {
            createNote(it)
        }

        binder.createPriorityGreen.setOnClickListener {
            priority = "1"
            binder.createPriorityGreen.setImageResource(R.drawable.ic_done)
            binder.createPriorityRed.setImageResource(0)
            binder.createPriorityYellow.setImageResource(0)
        }

        binder.createPriorityRed.setOnClickListener {
            priority = "3"
            binder.createPriorityRed.setImageResource(R.drawable.ic_done)
            binder.createPriorityGreen.setImageResource(0)
            binder.createPriorityYellow.setImageResource(0)
        }

        binder.createPriorityYellow.setOnClickListener {
            priority = "2"
            binder.createPriorityYellow.setImageResource(R.drawable.ic_done)
            binder.createPriorityGreen.setImageResource(0)
            binder.createPriorityRed.setImageResource(0)
        }

        return binder.root
    }

    @SuppressLint("SimpleDateFormat")
    private fun createNote(it: View?) {

        val title = binder.createTitle.text.toString()
        val subTitle = binder.createSubTitle.text.toString()
        val noteText = binder.createNote.text.toString()

        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val currentDate = sdf.format(Date())

        if (title.isEmpty() || subTitle.isEmpty() || noteText.isEmpty()){
            Toast.makeText(requireContext(), "Please provide all data", Toast.LENGTH_LONG).show()
        }else {
            val data = Notes(null, title, subTitle, noteText, currentDate, priority)
            notesViewModel.upsert(data)

            Toast.makeText(requireContext(), "Note Created", Toast.LENGTH_LONG).show()

            Navigation.findNavController(it!!).navigate(R.id.action_createNotesFragment_to_homeFragment)
        }

    }

}