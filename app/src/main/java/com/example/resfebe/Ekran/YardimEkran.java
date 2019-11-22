package com.example.resfebe.Ekran;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.resfebe.R;

public class YardimEkran extends Activity {
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yardim_resfebe);
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.beige);
    }
}
