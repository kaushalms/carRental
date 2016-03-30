package com.code.kaushal.turorentalapp;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Kaushal on 3/29/2016.
 */

public class ApiResultHandler extends AsyncTask<ApiRequest, Void, ApiResult> {

    private ApiResult mHotWireResult;
    private ApiRequest mRequest;
    WeakReference<ListActivity> mActivity;
    public ApiResultHandler(ListActivity activity) {
        mActivity = new WeakReference<ListActivity>(activity);
    }

    @Override
    protected ApiResult doInBackground(ApiRequest... params) {
        ApiResult result = null;
        ApiRequest r = params[0];
        /*Call<ApiResult> retrofitResponse = null;
        if (r != null) {
            retrofitResponse = RetrofitFactory.getCarRentalRequest().findCars(r.getDestination(), r.getStartDate(), r.getEndDate(),
                    r.getPickUpTime(), r.getDropOffTime());
        }
        if (retrofitResponse != null) {
            try {
                mHotWireResult = retrofitResponse.execute().body();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }*/

        String requestString = r.createStringRequest();
        String jsonResult = null;
        try {
            //String newRequestStr = requestString.replace(" ", "+");
            URL url = new URL(requestString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
            jsonResult = stringBuilder.toString();


        } catch (Exception e) {
            e.printStackTrace();
        }

        if (jsonResult != null) {
            mHotWireResult = ApiResultParser.parseJson(jsonResult);
        }
        return mHotWireResult;
    }

    @Override
    protected void onPostExecute(ApiResult hotWireResult) {
        ListActivity a = mActivity.get();
        if (a != null) {
            a.onLoaded(hotWireResult);
        }
    }
}