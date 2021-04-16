package com.unicep.app.dogs.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unicep.app.dogs.R
import com.unicep.app.dogs.controller.ListViewModel
import com.unicep.app.dogs.databinding.FragmentListBinding
import com.unicep.app.dogs.databinding.FragmentListItemBinding
import com.unicep.app.dogs.model.Dog
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment(), ISharedFragment {
    private val _message = "Recebido o valor de número 100!"
    private var uuid: Int = -1
    private val _tag = "ListFragment"
    private val  viewModel: ListViewModel by viewModels()
    lateinit var binding: FragmentListBinding
    lateinit var listOfDogs: List<Dog>


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
        binding = DataBindingUtil.bind(view) ?: return

        setupParameters()
        setupWidgets()
        setupListeners()
        load()
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

    override fun load() {
        // 3. Connect Recycler View with Adapter
        listOfDogs = viewModel.loadDogs()
        Log.d(_tag, "Count of dogs # ${listOfDogs.size}")
        Log.d(_tag, "Showing dogs # $listOfDogs")

        val adapter = ListDogsAdapter(listOfDogs)
        binding.rvListDogs.layoutManager = LinearLayoutManager(context)
        binding.rvListDogs.adapter = adapter
    }

    // 1. Create a new Holder -- DogItemsHolder
    private inner class DogItemsHolder(view: View): RecyclerView.ViewHolder(view){
        val binding: FragmentListItemBinding? = DataBindingUtil.bind(view)
    }


    // 2. Create a Adapter -- ListDogsAdapter
    private inner class ListDogsAdapter(var dogs: List<Dog>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return DogItemsHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.fragment_list_item, parent, false)
            )
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val binding = (holder as DogItemsHolder).binding
            binding?.tvDogName?.text = dogs[position].name
            binding?.tvDogDetails?.text = dogs[position].details
        }

        override fun getItemCount(): Int {
            return dogs.size
        }

    }
}