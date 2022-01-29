package win.ca.demo.myapplication.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import win.ca.demo.myapplication.R
import win.ca.demo.myapplication.data.api.model.response.base.ResponseState
import win.ca.demo.myapplication.databinding.ActivityMainBinding
import win.ca.demo.myapplication.ui.adapter.MainRecyclerAdapter
import win.ca.demo.myapplication.ui.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //    @Inject
//    lateinit var mainViewModel: MainViewModel
    val mainViewModel by viewModels<MainViewModel>()
    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        adapter = MainRecyclerAdapter()
        binding.recyclerNotes.adapter = adapter

        observer()
    }

    private fun observer() {
        mainViewModel.notesListLiveData.observe(this, {
            when (it) {
                is ResponseState.Success -> {
                    val items = it.item?.notes?.toMutableList()
                    showToast("Total ${items?.size} Notes")
                    adapter.submitList(it.item?.notes?.toMutableList())
                }
                is ResponseState.Error -> {
                    showToast("Error")
                }
                else -> {
                    showToast("Loading")
                }
            }
        })
    }

    private fun showToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}