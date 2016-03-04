package com.tianyejia.atry.glide;

import android.content.Context;

import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.tianyejia.atry.CustomImageSizeModel;

import java.io.InputStream;

/**
 * Created by Jack on 16/2/29.
 */
public class CustomImageSizeModelFactory implements ModelLoaderFactory<CustomImageSizeModel,InputStream> {
    @Override
    public ModelLoader<CustomImageSizeModel, InputStream> build(Context context, GenericLoaderFactory factories) {
        return new CustomImageSizeUrlModel(context);
    }

    @Override
    public void teardown() {

    }
}
