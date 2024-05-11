//package com.example.calmsphereapp;
//
//import android.net.Uri;
//import android.os.Bundle;
//import android.widget.MediaController;
//import android.widget.VideoView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity; // Import AppCompatActivity
//
//public class ContentLibrary extends AppCompatActivity { // Extend AppCompatActivity
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.content_liberary);
//
//        // Enable EdgeToEdge and set window insets listener
//        EdgeToEdge.enable(this);
//
//        // Initialize VideoView
//        VideoView videoView = findViewById(R.id.PeopleSmiling);
//
//        // Set up media controller
//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);
//
//        // Set video URI
//        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.people_smiling));
//
//        // Start playing the video
//        videoView.start();
//    }
//}




// 2 nd take
//package com.example.calmsphereapp;
//
//import android.net.Uri;
//import android.os.Bundle;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.widget.MediaController;
//import android.widget.VideoView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.content_liberary);
//
//        // Enable EdgeToEdge and set window insets listener
//        EdgeToEdge.enable(this);
//
//        // Initialize VideoView
//        VideoView videoView = findViewById(R.id.PeopleSmiling);
//
//        // Set up media controller
//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);
//
//        // Set video URI
//        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.people_smiling));
//
//        // Start playing the video
//        videoView.start();
//
//        // Find the WebView for displaying the YouTube video
//        WebView webView = findViewById(R.id.videoView3);
//
//        // Enable JavaScript (required for embedding YouTube videos)
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//
//        // Load the YouTube video URL
//        String videoId = "coy094cmvJ4"; // Replace this with your YouTube video ID
//        String embedUrl = "https://www.youtube.com/embed/" + videoId;
//        webView.loadUrl(embedUrl);
//    }
//}



// take 3

//package com.example.calmsphereapp;
//
//import android.os.Bundle;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class ContentLibrary extends AppCompatActivity {
//
//    @Override
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.content_liberary);
//
//        // Find the first WebView by its ID
//        WebView webView1 = findViewById(R.id.videoView2);
//
//        // Enable JavaScript (required for embedding YouTube videos)
//        WebSettings webSettings1 = webView1.getSettings();
//        webSettings1.setJavaScriptEnabled(true);
//
//        // Load the first YouTube video URL
//        String videoId1 = "coy094cmvJ4?si=BYV1NLPEpAVyznzh"; // Replace this with your first YouTube video ID
//        String embedUrl1 = "https://www.youtube.com/embed/" + videoId1;
//        webView1.loadUrl(embedUrl1);
//
//        // Find the second WebView by its ID
//        WebView webView2 = findViewById(R.id.videoView3);
//
//        // Enable JavaScript (required for embedding YouTube videos)
//        WebSettings webSettings2 = webView2.getSettings();
//        webSettings2.setJavaScriptEnabled(true);
//
//        // Load the second YouTube video URL
//        String videoId2 = "nr_sN_G-F7Q?si=yzkmfjT6144JuMAl"; // Replace this with your second YouTube video ID
//        String embedUrl2 = "https://www.youtube.com/embed/" + videoId2;
//        webView2.loadUrl(embedUrl2);
//
//        // Find the third WebView by its ID
//        WebView webView3 = findViewById(R.id.videoView4);
//
//        // Enable JavaScript (required for embedding YouTube videos)
//        WebSettings webSettings3 = webView3.getSettings();
//        webSettings3.setJavaScriptEnabled(true);
//
//        // Load the third YouTube video URL
//        String videoId3 = "vyIPs3ipDeI?si=3_ClfBx4pznELd9O"; // Replace this with your third YouTube video ID
//        String embedUrl3 = "https://www.youtube.com/embed/" + videoId3;
//        webView3.loadUrl(embedUrl3);
//    }
//
//}


//package com.example.calmsphereapp;
//
//import android.os.Bundle;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class ContentLibrary extends AppCompatActivity {
//
//    private WebView webView1;
//    private WebView webView2;
//    private WebView webView3;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.content_liberary);
//
//        // Find the first WebView by its ID
//        webView1 = findViewById(R.id.videoView2);
//
//        // Enable JavaScript (required for embedding YouTube videos)
//        WebSettings webSettings1 = webView1.getSettings();
//        webSettings1.setJavaScriptEnabled(true);
//
//        // Load the first YouTube video URL
//        String videoId1 = "coy094cmvJ4?si=BYV1NLPEpAVyznzh"; // Replace this with your first YouTube video ID
//        String embedUrl1 = "https://www.youtube.com/embed/" + videoId1;
//        webView1.loadUrl(embedUrl1);
//
//        // Find the second WebView by its ID
//        webView2 = findViewById(R.id.videoView3);
//
//        // Enable JavaScript (required for embedding YouTube videos)
//        WebSettings webSettings2 = webView2.getSettings();
//        webSettings2.setJavaScriptEnabled(true);
//
//        // Load the second YouTube video URL
//        String videoId2 = "nr_sN_G-F7Q?si=yzkmfjT6144JuMAl"; // Replace this with your second YouTube video ID
//        String embedUrl2 = "https://www.youtube.com/embed/" + videoId2;
//        webView2.loadUrl(embedUrl2);
//
//        // Find the third WebView by its ID
//        webView3 = findViewById(R.id.videoView4);
//
//        // Enable JavaScript (required for embedding YouTube videos)
//        WebSettings webSettings3 = webView3.getSettings();
//        webSettings3.setJavaScriptEnabled(true);
//
//        // Load the third YouTube video URL
//        String videoId3 = "vyIPs3ipDeI?si=3_ClfBx4pznELd9O"; // Replace this with your third YouTube video ID
//        String embedUrl3 = "https://www.youtube.com/embed/" + videoId3;
//        webView3.loadUrl(embedUrl3);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        webView1.clearCache(true);
//        webView2.clearCache(true);
//        webView3.clearCache(true);
//    }
//}

package com.example.calmshperef1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContentLibrary extends AppCompatActivity {

    private WebView webView1;
    private WebView webView2;
    private WebView webView3;
    private VideoView videoView4; // VideoView for the fourth video

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_liberary);

        //for bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);


        //        Profile button intent
        ImageButton profilebutton  = findViewById(R.id.imageButton3);
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the button click
                Intent intent = new Intent(ContentLibrary.this, profile_page.class);
                startActivity(intent);
         }
});



        // Find the first WebView by its ID
        webView1 = findViewById(R.id.videoView2);

        // Enable JavaScript (required for embedding YouTube videos)
        WebSettings webSettings1 = webView1.getSettings();
        webSettings1.setJavaScriptEnabled(true);

        // Load the first YouTube video URL
        String videoId1 = "coy094cmvJ4?si=BYV1NLPEpAVyznzh"; // Replace this with your first YouTube video ID
        String embedUrl1 = "https://www.youtube.com/embed/" + videoId1;
        webView1.loadUrl(embedUrl1);

        // Find the second WebView by its ID
        webView2 = findViewById(R.id.videoView3);

        // Enable JavaScript (required for embedding YouTube videos)
        WebSettings webSettings2 = webView2.getSettings();
        webSettings2.setJavaScriptEnabled(true);

        // Load the second YouTube video URL
        String videoId2 = "nr_sN_G-F7Q?si=yzkmfjT6144JuMAl"; // Replace this with your second YouTube video ID
        String embedUrl2 = "https://www.youtube.com/embed/" + videoId2;
        webView2.loadUrl(embedUrl2);

        // Find the third WebView by its ID
        webView3 = findViewById(R.id.videoView4);

        // Enable JavaScript (required for embedding YouTube videos)
        WebSettings webSettings3 = webView3.getSettings();
        webSettings3.setJavaScriptEnabled(true);

        // Load the third YouTube video URL
        String videoId3 = "vyIPs3ipDeI?si=3_ClfBx4pznELd9O"; // Replace this with your third YouTube video ID
        String embedUrl3 = "https://www.youtube.com/embed/" + videoId3;
        webView3.loadUrl(embedUrl3);

        // Find the fourth VideoView by its ID
        videoView4 = findViewById(R.id.PeopleSmiling);

        // Set up media controller for the fourth video
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView4);
        videoView4.setMediaController(mediaController);

        // Set video URI for the fourth video
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.people_smiling); // Replace R.raw.your_video_file with the actual resource ID of your video file
        videoView4.setVideoURI(videoUri);

        // Start playing the fourth video
        videoView4.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                // Set looping
                mediaPlayer.setLooping(true);
            }
        });
        videoView4.start();


        //Spotify plugin 1
        // Find the WebViews by their IDs
        WebView webView1 = findViewById(R.id.webView1);
        WebView webView2 = findViewById(R.id.webView2);
        WebView webView3 = findViewById(R.id.webView3);

        // Enable JavaScript (required for embedding Spotify episodes)
        WebSettings webSettings11 = webView1.getSettings();
        webSettings1.setJavaScriptEnabled(true);

        WebSettings webSettings12 = webView2.getSettings();
        webSettings2.setJavaScriptEnabled(true);

        WebSettings webSettings13 = webView3.getSettings();
        webSettings3.setJavaScriptEnabled(true);

        // Load the Spotify embed URLs
        String spotifyEmbedUrl1 = "https://open.spotify.com/embed/episode/3rXTAL8xPSX6HP4QozaB5j?utm_source=generator";
        webView1.loadUrl(spotifyEmbedUrl1);

        String spotifyEmbedUrl2 = "https://open.spotify.com/embed/episode/5bw3Bc7ONQRfhrHGtWinNp?utm_source=generator";
        webView2.loadUrl(spotifyEmbedUrl2);

        String spotifyEmbedUrl3 = "https://open.spotify.com/embed/episode/2aw7Cc98DDjQjLX9eofmEk?utm_source=generator";
        webView3.loadUrl(spotifyEmbedUrl3);

    }

    @Override
    protected void onPause() {
        super.onPause();
        webView1.clearCache(true);
        webView2.clearCache(true);
        webView3.clearCache(true);
        // No need to clear cache for videoView4 since it's a VideoView
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int itemId = item.getItemId();
                    // Change the icon tint for the selected item to the desired color
//                    Drawable selectedIcon = item.getIcon();
//                    int color = Color.parseColor("#FF00FF"); // Replace "#FF00FF" with your hexadecimal color
//                    selectedIcon.setTint(color);
//                    item.setIcon(selectedIcon);
                    if (itemId == R.id.home) {
                        // Navigate to HomeActivity
                        Intent homeIntent = new Intent(ContentLibrary.this, home.class);
                        startActivity(homeIntent);

                        return true;
                    } else if (itemId == R.id.contentLibrary) {
                        // Navigate to ContentLibraryActivity
                        Intent contentLibraryIntent = new Intent(ContentLibrary.this, ContentLibrary.class);
                        startActivity(contentLibraryIntent);
                        return true;
                    } else if (itemId == R.id.chatbot) {
                        // Navigate to ChatbotActivity
                        Intent chatbotIntent = new Intent(ContentLibrary.this, AppointmentHomePage2.class);
                        startActivity(chatbotIntent);
                        return true;
                    } else if (itemId == R.id.community) {
                        // Navigate to CommunityActivity
                        Intent communityIntent = new Intent(ContentLibrary.this, safe_space.class);
                        startActivity(communityIntent);
                        return true;
                    }
                    return false;
                }
            };
}
