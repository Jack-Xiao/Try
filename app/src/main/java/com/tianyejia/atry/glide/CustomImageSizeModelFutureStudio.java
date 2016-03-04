package com.tianyejia.atry.glide;

import com.tianyejia.atry.CustomImageSizeModel;

/**
 * Created by Jack on 16/2/29.
 */
public class CustomImageSizeModelFutureStudio implements CustomImageSizeModel {
    String baseImageUrl;

    @Override
    public String requestCustomSizeUrl(int width, int height) {
        return baseImageUrl + "?w=" + width +"&h=" + height;
    }

    public CustomImageSizeModelFutureStudio(String baseImageUrl){
        this.baseImageUrl = baseImageUrl;
    }
}
