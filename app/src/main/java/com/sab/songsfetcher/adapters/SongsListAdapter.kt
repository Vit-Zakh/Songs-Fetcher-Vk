package com.sab.songsfetcher.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.sab.songsfetcher.databinding.LayoutSongItemBinding
import com.sab.songsfetcher.models.VkSong
import kotlinx.android.synthetic.main.layout_song_item.view.*

class SongsListAdapter : RecyclerView.Adapter<SongsListAdapter.SongHolder>() {

private var songsList: List<VkSong> = ArrayList()
    class SongHolder constructor(val songItemBinding: LayoutSongItemBinding) : RecyclerView.ViewHolder(songItemBinding.root){

        fun bind(song:VkSong) = with(songItemBinding.root){
            this.songData.text = "${song.artist} - ${song.title}"
            this.songId.text = song.id.toString()
            this.downloadImage.setOnClickListener { Toast.makeText(context,"Downloading", Toast.LENGTH_SHORT).show() }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongHolder {
        return SongHolder(songItemBinding = LayoutSongItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun getItemCount(): Int {
        return songsList.size
    }

    override fun onBindViewHolder(holder: SongHolder, position: Int) {
        holder.bind(songsList[position])
    }

    fun setSongsList(mSongsList: List<VkSong>){
        songsList = mSongsList
    }
}