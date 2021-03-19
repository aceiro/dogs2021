package com.unicep.app.dogs.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.unicep.app.dogs.R
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val message = DetailsFragmentArgs.fromBundle(it).message
            tvDetailsMessage.text = message

        }

        floatingActionDetailsButton.setOnClickListener {
            val uuid = 100
            val action = DetailsFragmentDirections.actionListFragment(uuid)
            Navigation.findNavController(it).navigate(action)
        }
    }

}