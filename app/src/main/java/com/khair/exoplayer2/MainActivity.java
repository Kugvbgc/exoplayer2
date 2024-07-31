package com.khair.exoplayer2;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;

public class MainActivity extends AppCompatActivity {
    private PlayerView playerView;
    private ExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        playerView = findViewById(R.id.player_view);

        // Create an ExoPlayer instance
        player = new ExoPlayer.Builder(this).build();

        // Bind the player to the view.
        playerView.setPlayer(player);

        // Prepare the media item
        Uri videoUri = Uri.parse("https://file-examples.com/storage/fe3f15b9da66a36baa1b51a/2017/11/file_example_MP3_1MG.mp3");
        MediaItem mediaItem = MediaItem.fromUri(videoUri);

        // Set the media item to be played.
        player.setMediaItem(mediaItem);

        // Prepare the player
        player.prepare();

        // Start the playback
        player.play();

    }
    @Override
    protected void onPause() {
        super.onPause();
        player.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        player.play();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
    }


}