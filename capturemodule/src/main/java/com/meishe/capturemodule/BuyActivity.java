package com.meishe.capturemodule;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;



public class BuyActivity extends Activity {
    private final String TAG = getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        Log.e(TAG, "onCreate: "+TAG );
        findViewById(R.id.textView_buy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
