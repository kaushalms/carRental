package com.code.kaushal.turorentalapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Kaushal on 3/29/2016.
 */


public class ResourceBundleAdapter extends BaseAdapter {

    private List<ResourceBundle> mCategories;
    private LruCache<String, Bitmap> mMemoryCache;
    private Context mContext;

    public ResourceBundleAdapter(List<ResourceBundle> categories, Context context) {
        mCategories = categories;
        mContext = context;

        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        // Use 1/8th of the available memory for this memory cache.
        final int cacheSize = maxMemory / 8;

        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                // The cache size will be measured in kilobytes rather than
                // number of items.
                return bitmap.getByteCount() / 1024;
            }
        };
    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        return mMemoryCache.get(key);
    }

    @Override
    public int getCount() {
        if (mCategories == null){
            return 0;
        } else {
            return mCategories.size();
        }
    }

    @Override
    public ResourceBundle getItem(int position) {
        if(mCategories == null)
            return null;

        return mCategories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.bundle_layout, parent, false);
            vh = new ViewHolder(convertView);
            vh.position = position;
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder)convertView.getTag();
        }

        ResourceBundle c = getItem(position);
        //vh.text.setText(c.getName());
        //For now we're getting pictures from disc

        if (((BitmapDrawable)vh.image.getDrawable()) == null || vh.position != position) {
            vh.position = position;
            /*Bitmap bitmap = getBitmapFromMemCache(c.getImagePath());
            if (bitmap == null) {
                //load bitmap
                bitmap = BitmapFactory.decodeResource(mContext.getResources(), c.getResourceId());
                addBitmapToMemoryCache(c.getImagePath(), bitmap);
            }
            vh.image.setImageBitmap(bitmap);*/
            vh.image.setImageResource(c.getResourceId());
        }
        return convertView;
    }

    public static class ViewHolder {
        ImageView image;
        //TextView text;
        int position;
        public ViewHolder(View view) {
            image = (ImageView) view.findViewById(R.id.categoryPic);
            //text = (TextView) view.findViewById(R.id.categoryText);
        }


    }

}
