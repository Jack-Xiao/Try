package com.tianyejia.atry.glide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.tianyejia.atry.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jack on 16/2/29.
 */
public class GlideTestActivity extends AppCompatActivity {
    ImageView imageView;
    ListView listView;
    private Button btn;
    public static String[] eatFoodyImages = {
            "http://i.imgur.com/rFLNqWI.jpg",
            "http://i.imgur.com/C9pBVt7.jpg",
            "http://i.imgur.com/rT5vXE1.jpg",
            "http://i.imgur.com/aIy5R2k.jpg",
            "http://i.imgur.com/MoJs9pT.jpg",
            "http://i.imgur.com/S963yEM.jpg",
            "http://i.imgur.com/rLR2cyc.jpg",
            "http://i.imgur.com/SEPdUIx.jpg",
            "http://i.imgur.com/aC9OjaM.jpg",
            "http://i.imgur.com/76Jfv9b.jpg",
            "http://i.imgur.com/fUX7EIB.jpg",
            "http://i.imgur.com/syELajx.jpg",
            "http://i.imgur.com/COzBnru.jpg",
            "http://i.imgur.com/Z3QjilA.jpg",
    };

    public static void start(Context context){
        Intent intent = new Intent(context,GlideTestActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_glide);
        imageView =(ImageView)findViewById(R.id.image_view);
        btn = (Button)findViewById(R.id.btn_glide);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //
        int resourceId = R.mipmap.ic_launcher;
        listView  = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(new ImageListAdapter(this,eatFoodyImages));
        String gifUrl =
                "http://i.kinja-img.com/gawker-media/image/upload/s--B7tUiM5l--/gf2r69yorbdesguga10i.gif";

        /*Glide.with(this)
                .load(gifUrl)
                .into(imageView);*/

        Glide.with(this)
                .load("http://pica.nipic.com/2007-11-09/200711912453162_2.jpg")
                //.transform(new BlurTransformation(this))
                //.transform()
                .into(imageView);

        test();
    }

    private void test() {
        String test = "2016年03月02日";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG);
        SimpleDateFormat df3 = new SimpleDateFormat("yyyy年MM月dd日");
        String datee = "";


        try {
            Date d4 = df3.parse(test);
            datee = format.format(d4);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print(datee  + "......");

    }

    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";


    private static Uri resourceIdToUri(Context context, int resourceId){
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH +resourceId);
    }
}
