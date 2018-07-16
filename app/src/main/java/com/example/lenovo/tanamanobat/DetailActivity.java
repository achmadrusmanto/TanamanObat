package com.example.lenovo.tanamanobat;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvtitle;
    private WebView tvdescription;
    private ImageView img;
    private VideoView tvcategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvtitle = (TextView)findViewById(R.id.txtTitle);
        tvdescription = (WebView)findViewById(R.id.txtDesc);
        tvcategori = (VideoView)findViewById(R.id.txtCat);
        img = (ImageView)findViewById(R.id.bookthumbnail);

        // Recive data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        //String Categori = intent.getExtras().getString("Category");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");

        tvtitle.setText(Title);


        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(tvcategori);
        Uri uri = Uri.parse("rtsp://r4---sn-npoe7n7y.googlevideo.com/Cj0LENy73wIaNAnmElyHn1vMshMYDSANFC3Kn0xbMOCoAUIASARg3oTawuD0_eFYigELRXY4X1ZCSTc3dGcM/9FF910989014C831A4B895AD1CBF3D6B8EE4A640.4C4ABA464E532F2976E96A4CF26D03ECD8A94A17/yt6/1/video.3gp");
        tvcategori.setMediaController(mediaController);
        tvcategori.setVideoURI(uri);
        tvcategori.requestFocus();
        tvcategori.start();
        tvdescription.loadData("<p style=\"text-align: justify; background: #fff\">"+Description+"</p>", "text/html", "UTF-8");
        img.setImageResource(image);
    }
}
