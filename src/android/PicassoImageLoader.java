package com.holdskill.imagepicker;

import android.app.Activity;
import android.net.Uri;
import android.widget.ImageView;

import com.holdskill.imagepicker.PackageNameR;
import com.holdskill.imagepicker.loader.ImageLoader;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

public class PicassoImageLoader implements ImageLoader {
    private PackageNameR packagenameR;


    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
        packagenameR = new PackageNameR(this);
        Picasso.with(activity)//
                .load(Uri.fromFile(new File(path)))//
                .placeholder(packagenameR.getId("mipmap", "default_image"))//
                .error(packagenameR.getId("mipmap", "default_image"))//
                .resize(width, height)//
                .centerInside()//
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)//
                .into(imageView);
    }

    @Override
    public void clearMemoryCache() {
    }
}
