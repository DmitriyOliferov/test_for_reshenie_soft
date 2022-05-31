package com.oliferov.test_for_reshenie_soft.presentation.screen.listuser

import android.content.Context
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
import com.oliferov.test_for_reshenie_soft.presentation.screen.UserPostsApp
import com.oliferov.test_for_reshenie_soft.presentation.screen.ViewModelFactory
import javax.inject.Inject

class UsersListFragment : Fragment() {

    private var _binding: FragmentUsersListBinding? = null
    private val binding: FragmentUsersListBinding
        get() = _binding ?: throw RuntimeException("FragmentUsersListBinding is null")

    private lateinit var viewModel: UsersListViewModel

    private val component by lazy {
        (requireActivity().application as UserPostsApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val usersListAdapter by lazy {
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

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createRecyclerview()
        createViewModel()
    }

    private fun createRecyclerview() {
        with(binding.rvUsersList) {
            adapter = usersListAdapter
            layoutManager = LinearLayoutManager(
                requireActivity(),
                LinearLayoutManager.VERTICAL,
                false
            )
        }

    }

    private fun createViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[UsersListViewModel::class.java]
        viewModel.listUsers.observe(viewLifecycleOwner) {
            usersListAdapter.submitList(it)
        }
    }
}