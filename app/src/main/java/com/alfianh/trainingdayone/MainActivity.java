package com.alfianh.trainingdayone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by alfianh on 31/10/16.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private TextView resultCount;
    private int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultCount = (TextView) findViewById(R.id.tv_result_count);
        resultCount.setText(String.valueOf(count));
        Button plus = (Button) findViewById(R.id.btn_plus);
        Button minus = (Button) findViewById(R.id.btn_minus);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        Log.v(MainActivity.class.getSimpleName(), "Angka sekarang nilainya : " + resultCount.getText().toString());
        Toast.makeText(this, "Angkanya sekarang nilainya " + resultCount.getText().toString(), Toast.LENGTH_LONG).show();
    }

    public void increment() {
        try {
            count++;
            resultCount.setText(String.valueOf(count));
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error" + e);
        }
    }

    public void decrement() {
        try {
            count--;
            resultCount.setText(String.valueOf(count));
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error" + e);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                increment();
                break;
            case R.id.btn_minus:
                if (count < 0) {
                    return;
                }
                decrement();
                break;
        }
    }
}
