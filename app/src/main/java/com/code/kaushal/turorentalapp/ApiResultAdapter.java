package com.code.kaushal.turorentalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kaushal on 3/29/2016.
 */
public class ApiResultAdapter extends BaseAdapter {

    private List<RentalNodeResult> mList;
    private Context mContext;

    public ApiResultAdapter(Context context) {
        mContext = context;
    }

    public void setResult(ApiResult r) {
        if (r != null) {
            mList = r.getResult();
        }
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        if (mList == null) {
            return 0;
        } else {
            return mList.size();
        }
    }

    @Override
    public Object getItem(int position) {
        if (mList == null) {
            return null;
        } else {
            return mList.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        if (mList == null || position < 0 || position >= mList.size()) {
            return -1;
        } else {
            return position;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.car_result, parent, false);
            vh = new ViewHolder(convertView);

            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        if (mList != null) {
            RentalNodeResult c = mList.get(position);

            vh.price.setText(c == null ? "$ --.-" : "$ "+c.getDailyRate()+ " per day");
            vh.carType.setText(c == null ? "--" : c.getCarTypeCode());
        }

        return convertView;
    }

    public static class ViewHolder {
        TextView price;
        TextView carType;
        public ViewHolder(View v) {
            price = (TextView) v.findViewById(R.id.price);
            carType= (TextView) v.findViewById(R.id.carType);
        }

    }
}
