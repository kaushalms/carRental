package com.code.kaushal.turorentalapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

/**
 * Created by Kaushal on 3/29/2016.
 */

public class ListActivity extends Activity {

    ApiResultAdapter mAdapter;
    ListView mListView;

    ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_content);

        mListView = (ListView) findViewById(R.id.categoryLstView);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
        mProgressBar.setVisibility(View.VISIBLE);

        Intent i = getIntent();
        ApiRequest r = null;
        if (i != null) {
            r = (ApiRequest) i.getSerializableExtra(ApiRequest.REQUEST_EXTRA);
            Log.d("TAG", "ApiRequest:" + r);
        }

        mAdapter = new ApiResultAdapter(this);

        mListView.setAdapter(mAdapter);
        new ApiResultHandler(this).execute(r);

    }

    public void onLoaded(ApiResult r) {
        mProgressBar.setVisibility(View.GONE);
        if (r == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Something went wrong")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ListActivity.this.finish();
                        }
                    });
            builder.create().show();
        } else {
            mAdapter.setResult(r);
        }

    }
}
