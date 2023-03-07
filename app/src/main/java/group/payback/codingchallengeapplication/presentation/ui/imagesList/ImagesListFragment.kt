package group.payback.codingchallengeapplication.presentation.ui.imagesList

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import group.payback.codingchallengeapplication.R
import group.payback.codingchallengeapplication.databinding.FragmentImagesListBinding
import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.presentation.adapter.ImagesAdapter
import group.payback.codingchallengeapplication.presentation.adapter.OnItemClickListner
import group.payback.codingchallengeapplication.util.NetworkResult
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ImagesListFragment : Fragment(), OnItemClickListner {
    //region Golbal Variable
    private var binding: FragmentImagesListBinding? = null
    private val viewModel: ImagesListViewModel by viewModels()
    private val mAdapter by lazy { ImagesAdapter(this) }
    //endregion

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return FragmentImagesListBinding.inflate(
            inflater, container, false
        ).apply {
            binding = this
            lifecycleOwner = viewLifecycleOwner
            itemViewModel = viewModel
            collectData()
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setSearchButtonOnClickListener()
    }

    private fun setSearchButtonOnClickListener() {
        binding?.serachButton?.setOnClickListener {
            onSearchEditTextChanged()
            val word = binding?.serachEditText?.text?.toString()?.trim() ?: ""
            if (word.isNotEmpty()) {
                clearRecyclerViewData()
                viewModel.loadImages(word)
            } else {
                Toast.makeText(activity, R.string.msg_Empty_Search_Text_error, Toast.LENGTH_LONG).show()
                binding?.serachEditText?.setBackgroundResource(R.drawable.backwithborder)
            }
        }
    }

    private fun onSearchEditTextChanged() {
        binding?.serachEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val word = binding?.serachEditText?.text?.toString()?.trim() ?: ""

                if (word.isNotEmpty()) {
                    binding?.serachEditText?.setBackgroundResource(R.drawable.backwithoutborder)
                } else {
                    Toast.makeText(activity, R.string.msg_Empty_Search_Text_error, Toast.LENGTH_SHORT).show()
                    binding?.serachEditText?.setBackgroundResource(R.drawable.backwithborder)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun setupRecyclerView() {
        val layoutManager = GridLayoutManager(context, 2)
        binding?.recyclerView?.layoutManager = layoutManager
        binding?.recyclerView?.adapter = mAdapter
    }

    private fun clearRecyclerViewData() {
        mAdapter.setData(emptyList())
    }

    private fun collectData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.imagesFlow.collect { response ->
                when (response) {
                    is NetworkResult.Success -> {
                        response.data?.let { mAdapter.setData(it.hits) }
                    }
                    is NetworkResult.Error -> {
                        Toast.makeText(requireContext(), response.message.toString(), Toast.LENGTH_SHORT).show()
                    }
                    is NetworkResult.Loading -> {
                    }
                }
            }
        }
    }

    override fun onItemClick(item: Hit, position: Int) {
        val bundle = bundleOf("imageID" to item.id, "hit" to item)
        view?.findNavController()?.navigate(R.id.action_imagesListFragment_to_imageDetailsFragment, bundle)
    }
}