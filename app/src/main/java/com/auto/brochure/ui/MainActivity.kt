package com.auto.brochure.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.auto.brochure.*
import com.auto.brochure.databinding.FragmentMainBinding
import com.auto.brochure.repository.CarInfoRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<MainFragment>(R.id.fragment_container_view)
        }
    }
}

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val bindingInterface = object : GenericRecyclerBindingInterface<CarMake> {
            override fun bindData(item: CarMake, textView: TextView) {
                textView.text = item.name
            }
        }

        viewModel.getCarManufacturerList().observe(viewLifecycleOwner) {
            binding.recyclerView.apply {
                val linearLayoutManager = LinearLayoutManager(requireContext())
                layoutManager = linearLayoutManager
                adapter = RecyclerAdapter(
                    displayList = it,
                    bindingInterface
                )
                addItemDecoration(
                    DividerItemDecoration(
                        requireContext(),
                        linearLayoutManager.orientation
                    )
                )
            }
        }

    }
}
