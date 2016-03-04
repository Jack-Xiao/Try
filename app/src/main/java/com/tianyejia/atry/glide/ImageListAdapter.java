package com.tianyejia.atry.glide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tianyejia.atry.R;

/**
 * Created by Jack on 16/2/29.
 */
public class ImageListAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] imageUrls;

    public ImageListAdapter(Context context, String[] imageUrls) {
        super(context, R.layout.item_test_glide, imageUrls);

        this.context = context;
        this.imageUrls = imageUrls;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null == convertView){
            convertView = inflater.inflate(R.layout.item_test_glide,parent,false);
        }
        Glide.with(context)
                .load(imageUrls[position])
                //.placeholder(R.mipmap.ic_launcher)
                //.error(R.mipmap.ic_launcher)    //错误
                .crossFade()    //淡入淡出
                //.dontAnimate()  //直接显示
                //.override(600,200)  //调整图片大小
                .centerCrop()   //图像不完全显示，完全填充
                //.fitCenter()    //图像完全显示，不完全填充
                .into((ImageView) convertView);

        return convertView;
    }
}
