package com.unicep.app.dogs.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.unicep.app.dogs.R
import kotlinx.android.synthetic.main.fragment_details.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DetailsFragment : Fragment() {
    private val _message = "Click on DetailsFragment:: button"
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        floatingActionDetailsButton.setOnClickListener {

            Toast
                .makeText(requireContext(), _message, Toast.LENGTH_SHORT)
                .show()

            val action = DetailsFragmentDirections.actionDetailsFragmentToListFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}