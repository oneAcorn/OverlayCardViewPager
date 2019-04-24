package com.acorn.overlaycardviewpager;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.lang.ref.WeakReference;

public class OverlayPageAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] imgUrls;
    private WeakReference<Bitmap>[] bitmaps;
    private RequestOptions mRequestOptions;

    public OverlayPageAdapter(Context context) {
        this.context = context;
        this.mRequestOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_foreground);
        inflater = LayoutInflater.from(context);
    }

    /**
     *
     * @param vp
     * @param imgUrls
     * @param layerAmount 显示层数
     */
    public void setImgUrlsAndBindViewPager(ViewPager vp, String[] imgUrls,int layerAmount) {
        this.imgUrls = imgUrls;
        if (imgUrls != null && imgUrls.length > 0) {
            bitmaps = new WeakReference[imgUrls.length];
            vp.setOffscreenPageLimit(layerAmount);
            OverlayTransformer transformer = new OverlayTransformer(layerAmount);
            vp.setPageTransformer(true, transformer);
        }
    }

    @Override
    public int getCount() {
        if (null == imgUrls)
            return 0;
        if (imgUrls.length <= 1)
            return imgUrls.length;
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        final int p = position % imgUrls.length;
        final String imgUrl = imgUrls[p];
        View view = inflater.inflate(R.layout.item_viewpager, null);
        final ImageView iv = view.findViewById(R.id.example_iv);
        if (null != bitmaps && null != bitmaps[p] && null != bitmaps[p].get()) {
            iv.setImageBitmap(bitmaps[p].get());
        }
        Glide.with(context).asBitmap().load(imgUrl).apply(mRequestOptions).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                bitmaps[p] = new WeakReference<Bitmap>(resource);
                iv.setImageBitmap(resource);
            }
        });
        view.setTag(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
