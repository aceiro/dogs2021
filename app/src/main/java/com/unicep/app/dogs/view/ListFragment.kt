package com.unicep.app.dogs.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.unicep.app.dogs.R
import com.unicep.app.dogs.controller.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment(), ISharedFragment {
    private val _message = "Recebido o valor de número 100!"
    private var uuid: Int = -1
    private val _tag = "ListFragment"
    private val  viewModel: ListViewModel by viewModels()

    init {
        Log.d(_tag, "Init :: lifecycle fragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        Log.d(_tag, "Called :: onCreateView(inflater, container, savedInstanceState) from Fragment")
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(_tag, "Called :: onViewCreated(view, savedInstanceState) from Fragment")


        setupParameters()
        setupWidgets()
        setupListeners()
    }

    override fun onStart() {
        super.onStart()
        Log.d(_tag, "Called :: onStart() from Fragment")
    }

    override fun onResume() {
        super.onResume()
        Log.d(_tag, "Called :: onResume() from Fragment")
    }

    override fun onStop() {
        super.onStop()
        Log.d(_tag, "Called :: onStop() from Fragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(_tag, "Called :: onDestroy() from Fragment")
    }

    override fun setupListeners() {
        btnList.setOnClickListener {
            val action = ListFragmentDirections.actionDetailsFragment(_message)
            Navigation.findNavController(it).navigate(action)

        }
    }

    override fun setupWidgets() {

    }

    override fun setupParameters() {
        arguments?.let {
            uuid = ListFragmentArgs.fromBundle(it).uuid
        }
    }
}