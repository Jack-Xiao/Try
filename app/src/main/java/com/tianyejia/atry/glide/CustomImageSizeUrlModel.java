package com.tianyejia.atry.glide;

import android.content.Context;

import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;
import com.tianyejia.atry.CustomImageSizeModel;

/**
 * Created by Jack on 16/2/29.
 */
public class CustomImageSizeUrlModel extends BaseGlideUrlLoader<CustomImageSizeModel> {

    public CustomImageSizeUrlModel(Context context) {
        super(context);
    }

    @Override
    protected String getUrl(CustomImageSizeModel model, int width, int height) {
        return null;
    }
}
