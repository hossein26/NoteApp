package com.hossein.noteapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hossein.noteapp.databinding.ActivityMainBinding
import com.hossein.noteapp.db.NoteDatabase
import com.hossein.noteapp.repository.NoteRepository
import com.hossein.noteapp.viewmodel.NoteViewModel
import com.hossein.noteapp.viewmodel.NoteViewModelProviderFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(
            NoteDatabase(this)
        )

        val viewModelProviderFactory =
            NoteViewModelProviderFactory(
                application, noteRepository
            )

        noteViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory
        ).get(NoteViewModel::class.java)
    }

}