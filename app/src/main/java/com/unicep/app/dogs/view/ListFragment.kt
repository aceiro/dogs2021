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


class ListFragment : Fragment() {
    private val _message = "Recebido o valor de número 100!"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var uuid = -1
        arguments?.let {
            uuid = ListFragmentArgs.fromBundle(it).uuid
            tvListMessage.text = getString(R.string.message_received, uuid)
        }

        if (uuid == 100) {
            makeText(this.requireContext(), _message, LENGTH_SHORT).show()
        }

        btnList.setOnClickListener {
            val action = ListFragmentDirections.actionDetailsFragment(_message)
            Navigation.findNavController(it).navigate(action)

        }
    }
}