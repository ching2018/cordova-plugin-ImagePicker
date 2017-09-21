package com.holdskill.imagepicker;

import android.app.Application;
import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.holdskill.imagepicker.PackageNameR;
import org.xutils.image.ImageOptions;
import org.xutils.x;


public class GApp extends Application {

    public static DisplayImageOptions imageLoaderOptions = new DisplayImageOptions.Builder()//
            .showImageOnLoading((new PackageNameR(this)).getId("mipmap", "default_image"))         //设置图片在下载期间显示的图片
            .showImageForEmptyUri((new PackageNameR(this)).getId("mipmap", "default_image"))       //设置图片Uri为空或是错误的时候显示的图片
            .showImageOnFail((new PackageNameR(this)).getId("mipmap", "default_image"))            //设置图片加载/解码过程中错误时候显示的图片
            .cacheInMemory(true)                                //设置下载的图片是否缓存在内存中
            .cacheOnDisk(true)                                  //设置下载的图片是否缓存在SD卡中
            .build();                                           //构建完成

    public static ImageOptions xUtilsOptions = new ImageOptions.Builder()//
            .setIgnoreGif(true)                                //是否忽略GIF格式的图片
            .setImageScaleType(ImageView.ScaleType.FIT_CENTER)  //缩放模式
            .setLoadingDrawableId(new PackageNameR(this)("mipmap", "default_image"))       //下载中显示的图片
            .setFailureDrawableId(new PackageNameR(this)("mipmap", "default_image"))       //下载失败显示的图片
            .build();                                           //得到ImageOptions对象

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration config = ImageLoaderConfiguration.createDefault(this);

        ImageLoader.getInstance().init(config);     //UniversalImageLoader初始化
        x.Ext.init(this);                           //xUtils3初始化
    }
    /**
     * http://blog.csdn.net/yanzhenjie1003/article/details/51818269 android-support-multidex解决65536
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}