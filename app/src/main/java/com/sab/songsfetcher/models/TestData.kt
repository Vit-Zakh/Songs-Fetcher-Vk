package com.sab.songsfetcher.models

class TestData {
    companion object{
        fun createTestSongsList(): ArrayList<VkSong>{
            val songList = ArrayList<VkSong>()
            songList.add(
                VkSong(0,url = "test_url")
            )
            songList.add(
                VkSong(1, title = "song_without_artist", url = "test_url")
            )
            songList.add(
                VkSong(2, artist = "artist_without_song", url = "test_url")
            )
            songList.add(
                VkSong(3, "Black Lab", "This Night", "test_url")
            )
            return songList
        }
    }
}