package com.example.resfebe.Ekran;

import android.os.Bundle;
import android.view.View;

import com.example.resfebe.R;
import com.example.resfebe.Resim;
import com.example.resfebe.SoruAday;
import com.example.resfebe.SoruListesi;

public class KolayEkran extends GenelEkran {
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kolay_resfebe);
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.beige);
        kontrolDugme = findViewById(R.id.kontrolDugme);
        kontrolDugme.setOnClickListener(kontrolTikla);
        pasDugme = findViewById(R.id.pasDugme);
        pasDugme.setOnClickListener(pasTikla);
        resim1 = findViewById(R.id.resim1);
        resim2 = findViewById(R.id.resim2);
        cevapYazi = findViewById(R.id.cevapYazi);
        soruGoster();
    }

    protected void adaylariBul(){
        soruListesi = new SoruListesi();
        for (int i = 0; i < resimSozluk.uzunluk(); i++){
            Resim resim1 = resimSozluk.resimGetir(i);
            String kelime1 = resim1.kelimeGetir();
            if (kelime1.length() > 1){
                for (int j = 0; j < resimSozluk.uzunluk(); j++){
                    Resim resim2 = resimSozluk.resimGetir(j);
                    String kelime2 = resim2.kelimeGetir();
                    if (kelime2.length() > 1){
                        String arananKelime = kelime1 + kelime2;
                        if (sozluk.sozlukteKelimeVarMi(arananKelime) == true){
                            SoruAday soruAday = new SoruAday(resim1, resim2);
                            soruListesi.adaySoruEkle(soruAday);
                        }
                    }
                }
            }
        }
       // Toast.makeText(getApplicationContext(), "soru sayısı: " + soruListesi.soruSayisi(), Toast.LENGTH_LONG).show();
    }

    protected void soruGoster(){
        resimGoster(resim1, 0);
        resimGoster(resim2, 1);
    }
}
