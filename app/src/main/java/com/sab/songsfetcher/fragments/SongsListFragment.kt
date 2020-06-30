package com.sab.songsfetcher.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.sab.songsfetcher.R
import com.sab.songsfetcher.adapters.SongsListAdapter
import com.sab.songsfetcher.databinding.FragmentSongsListBinding
import com.sab.songsfetcher.models.TestData
import com.vk.api.sdk.VK

/**
 * A simple [Fragment] subclass.
 */
class SongsListFragment : Fragment() {
    private lateinit var listBinding: FragmentSongsListBinding
    private lateinit var listAdapter: SongsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        listBinding = FragmentSongsListBinding.inflate(inflater, container, false)

        listBinding.friendsList.apply {
            layoutManager = LinearLayoutManager(context)
            listAdapter = SongsListAdapter()
            listAdapter.setSongsList(TestData.createTestSongsList())
            adapter = listAdapter
        }
        setHasOptionsMenu(true)
        return listBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_quit, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        VK.logout()
        activity?.finish()
        return true
    }

}


