package com.unicep.app.dogs.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.unicep.app.dogs.R
import kotlinx.android.synthetic.main.fragment_list.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListFragment : Fragment() {
    private val _message = "Click on ListFragment:: button"
    private var _param1: String? = null
    private var _param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            _param1 = it.getString(ARG_PARAM1)
            _param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        floatingActionListButton.setOnClickListener {

            // 1. shows Toast
            Toast
                .makeText(this.requireContext(), _message, Toast.LENGTH_SHORT)
                .show()

            // 2. open new Fragment (details)
            val action = ListFragmentDirections.actionListFragmentToDetailsFragment()
            Navigation.findNavController(it).navigate(action)

        }
    }



    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}