package com.samuel.versioncontrolproject

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.samuel.versioncontrolproject.databinding.ActivityYoutubeBinding

class YoutubeActivity : YouTubeBaseActivity() {

    private lateinit var binding: ActivityYoutubeBinding

    val api_key = "AIzaSyDhbNrBOTGX80ZzGIA94C52H5EI-YzWE6Q"

    val youtube_id = "WUbp0pyKI5g"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYoutubeBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)
        val ytPlayer = binding.ytPlayer

        ytPlayer.initialize(api_key, object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                provider: YouTubePlayer.Provider?,
                player: YouTubePlayer?,
                p2: Boolean
            ) {
                player?.loadVideo(youtube_id)
                player?.play()
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(this@YoutubeActivity, "Video player failed", Toast.LENGTH_SHORT)
                    .show()
            }
            // Implement two methods by clicking on red error bulb
            // inside onInitializationSuccess method
            // add the video link or the
            // playlist link that you want to play
            // In here we also handle the play and pause functionality

        })


    }
}