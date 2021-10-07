package com.example.attmodule.UI

import com.example.attmodule.Adapter.ChannelAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.attmodule.R
import com.example.attmodule.ViewModel.ChannelViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var channelViewModel: ChannelViewModel
    lateinit var adapter: ChannelAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycleView()
        channelViewModel.getChannelData()

    }

    private fun initRecycleView() {

        recyclerView = findViewById(R.id.recycleView)
        adapter= ChannelAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
        }


    }
}