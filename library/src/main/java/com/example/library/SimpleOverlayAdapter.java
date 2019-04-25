package com.example.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.bumptech.glide.request.RequestOptions;

public class SimpleOverlayAdapter extends BaseOverlayPageAdapter {
    private LayoutInflater mInflater;

    public SimpleOverlayAdapter(Context context) {
        super(context, new RequestOptions().error(R.drawable.error).placeholder(R.drawable.placeholder));
        mInflater = LayoutInflater.from(context);
    }

    public SimpleOverlayAdapter(Context context, RequestOptions imageOptions) {
        super(context, imageOptions);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    protected View itemView() {
        return mInflater.inflate(R.layout.item_viewpager, null);
    }
}
