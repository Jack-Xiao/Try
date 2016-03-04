package com.tianyejia.atry.glide;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by Jack on 16/2/29.
 */
public class BlurTransformation extends BitmapTransformation {
    private RenderScript rs;

    public BlurTransformation(Context context) {
        super(context);
        rs = RenderScript.create(context);
    }

    public BlurTransformation(BitmapPool bitmapPool) {
        super(bitmapPool);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        //return null;
        Bitmap blurredBitmap = toTransform.copy(Bitmap.Config.ARGB_8888,true);
        Allocation input = Allocation.createFromBitmap(
                rs,
                blurredBitmap,
                Allocation.MipmapControl.MIPMAP_FULL,
                Allocation.USAGE_SHARED);
        Allocation output = Allocation.createTyped(rs,input.getType());

        ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(rs,
                Element.U8_4(rs));
        script.setInput(input);

        script.setRadius(10);
        script.forEach(output);
        output.copyTo(blurredBitmap);

        toTransform.recycle();
        return blurredBitmap;
    }

    @Override
    public String getId() {
        return "blur";
    }
}
