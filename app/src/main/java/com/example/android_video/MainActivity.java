package com.example.android_video;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    // creating media controller object
    // this will add control options on the video view
    MediaController mediaController ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting videoView from layout file using findViewById
        VideoView videoView = findViewById(R.id.myVideo);
        // here package name is com.example.android_video
        // here R.raw.video is the name of the video file
        String videoPath= "android.resource://"+getPackageName()+"/"+R.raw.video;

        Uri uri = Uri.parse(videoPath);

        videoView.setVideoURI(uri);

        mediaController = new MediaController(this); // we need to pass the contxt this as this is current activity

        // attach the video view with media Controller
        // and then attach the media Controller with video view

        videoView.setMediaController(mediaController);

        // to add the controls just below the video

        mediaController.setAnchorView(videoView);

    }
}