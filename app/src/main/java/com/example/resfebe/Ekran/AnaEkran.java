package com.example.resfebe.Ekran;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.resfebe.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class AnaEkran extends Activity {
    Button basitDugme;
    String resfebeUyari = "Lütfen oyunu başlatırken bekleyiniz.";
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ana_ekran);
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.beige);
        Toast.makeText(getApplicationContext(), resfebeUyari, Toast.LENGTH_LONG).show();
        basitDugme = (Button) findViewById(R.id.basitDugme);
        basitDugme.setOnClickListener(basitTikla);
        basitDugme = (Button) findViewById(R.id.ortaDugme);
        basitDugme.setOnClickListener(ortaTikla);
        basitDugme = (Button) findViewById(R.id.zorDugme);
        basitDugme.setOnClickListener(zorTikla);
        basitDugme = (Button) findViewById(R.id.yardimDugme);
        basitDugme.setOnClickListener(yardimTikla);
    }

    private void kelimeDosyasiOku(){
        InputStream stream = getResources().openRawResource(R.raw.kelime);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream,Charset.forName("UTF-8")));
    }

    public View.OnClickListener basitTikla = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent basitIntent = new Intent(AnaEkran.this, KolayEkran.class);
            startActivity(basitIntent);
        }
    };
    public View.OnClickListener ortaTikla = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent ortaIntent = new Intent(AnaEkran.this, OrtaEkran.class);
            startActivity(ortaIntent);
        }
    };
    public View.OnClickListener zorTikla = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent zorIntent = new Intent(AnaEkran.this, ZorEkran.class);
            startActivity(zorIntent);
        }
    };
    public View.OnClickListener yardimTikla = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent yardimIntent = new Intent(AnaEkran.this, YardimEkran.class);
            startActivity(yardimIntent);
        }
    };
}
