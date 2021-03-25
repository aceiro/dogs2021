package com.unicep.app.dogs.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.unicep.app.dogs.R
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment(), ISharedFragment {
    private val _message = "Recebido o valor de número 100!"
    private var uuid: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupParameters()
        setupWidgets()
        setupListeners()
    }

    override fun setupListeners() {
        btnList.setOnClickListener {
            val action = ListFragmentDirections.actionDetailsFragment(_message)
            Navigation.findNavController(it).navigate(action)

        }
    }

    override fun setupWidgets() {
        tvListMessage.text = getString(R.string.message_received, uuid)
    }

    override fun setupParameters() {
        arguments?.let {
            uuid = ListFragmentArgs.fromBundle(it).uuid
        }
    }
}