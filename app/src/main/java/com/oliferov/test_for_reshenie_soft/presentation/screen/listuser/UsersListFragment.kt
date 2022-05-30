package com.oliferov.test_for_reshenie_soft.presentation.screen.listuser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliferov.test_for_reshenie_soft.R
import com.oliferov.test_for_reshenie_soft.databinding.FragmentUsersListBinding

class UsersListFragment : Fragment() {

    private var _binding: FragmentUsersListBinding? = null
    private val binding: FragmentUsersListBinding
        get() = _binding ?: throw RuntimeException("FragmentUsersListBinding is null")

    private lateinit var viewModel: UsersListViewModel

    private val usersListAdapter by lazy{
        UsersListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application))[UsersListViewModel::class.java]
        createRecyclerview()
        viewModel.listUsers.observe(viewLifecycleOwner){
            usersListAdapter.submitList(it)
        }
    }

    private fun createRecyclerview(){
        with(binding.rvUsersList){
            adapter = usersListAdapter
            layoutManager = LinearLayoutManager(
                requireActivity(),
                LinearLayoutManager.VERTICAL,
                false
            )
        }

    }
}