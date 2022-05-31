package com.oliferov.test_for_reshenie_soft.presentation.screen.listnews

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.oliferov.test_for_reshenie_soft.databinding.FragmentNewsListBinding
import com.oliferov.test_for_reshenie_soft.presentation.screen.UserPostsApp
import com.oliferov.test_for_reshenie_soft.presentation.screen.ViewModelFactory
import javax.inject.Inject

private const val ARG_UID = "UID"

class NewsListFragment : Fragment() {
    private var uid: Int = -1

    private var _binding: FragmentNewsListBinding? = null
    private val binding: FragmentNewsListBinding
        get() = _binding ?: throw RuntimeException("FragmentNewsListBinding is null")

    private lateinit var viewModel: NewsListViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as UserPostsApp).component
    }

    private val newListAdapter by lazy {
        NewsListAdapter()
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            uid = it.getInt(ARG_UID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        uid = NewsListFragmentArgs.fromBundle(requireArguments()).uid
        _binding = FragmentNewsListBinding.inflate(
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
        createRecyclerview()
        createViewModel()
    }

    private fun createViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[NewsListViewModel::class.java]
        viewModel.getAllNews(uid)
        viewModel.listNews.observe(viewLifecycleOwner) {
            newListAdapter.submitList(it)
        }
    }

    private fun createRecyclerview() {
        with(binding.rvNewsList) {
            adapter = newListAdapter
            layoutManager = LinearLayoutManager(
                requireActivity(),
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }
}