package com.tianyejia.atry;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.android.gms.common.api.GoogleApiClient;
import com.tianyejia.atry.glide.GlideTestActivity;

/**
 * Glide
 */
public class MainActivity extends AppCompatActivity {
    Button btn;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    ImageView imageView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn_glide);
        imageView = (ImageView)findViewById(R.id.image_view);

        String gifUrl = "http://i.kinja-img.com/gawker-media/" +
                        "image/upload/s--B7tUiM5l--/gf2r69yorbdesguga10i.gif";
        context = this;
        /*Glide.with(this)
                .load(gifUrl)
                .error(R.mipmap.ic_launcher)
                .into(imageView);*/

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlideTestActivity.start(MainActivity.this);
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        String imageUrl ="http://120.25.224.250/data/afficheimg/1446013878506378037.jpg";
        Uri uri = Uri.parse(imageUrl);
        Glide.with(context)
                .load(uri)
                .animate(android.R.anim.slide_in_left)
                .into(imageView);
        //android.R.anim.slide_in_left;
       /* Picasso.with(context)
                .load(imageUrl)
                .into(imageView);*/

        Context mContext = this;
        final RemoteViews rv = null;
        //rv = new RemoteViews(mContext.getPackageName(),R.layout.remoteview_)

        /*NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                    //.setSmallIcon(R.mipmap.)
                    .setContentTitle("Title")
                    .setContentText("Content")
                    .setContent(rv)
                    .setPriority(NotificationCompat.PRIORITY_MIN);
        */
        ViewPropertyAnimation.Animator animationObject =
                new ViewPropertyAnimation.Animator() {
                    @Override
                    public void animate(View view) {
                        view.setAlpha(0f);
                        ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view,
                                "alpha",0f,1f);
                        fadeAnim.setDuration(2500);
                        fadeAnim.start();
                    }
                };
    }

    private SimpleTarget target = new SimpleTarget<Bitmap>(250,250) {
        @Override
        public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
            imageView.setImageBitmap(resource);
        }
    };
}
