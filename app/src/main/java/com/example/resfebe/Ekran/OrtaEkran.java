package com.example.resfebe.Ekran;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.resfebe.R;
import com.example.resfebe.Resim;
import com.example.resfebe.SoruAday;
import com.example.resfebe.SoruListesi;

public class OrtaEkran extends GenelEkran {
    private ImageView resim3;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orta_resfebe);
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.beige);
        kontrolDugme = findViewById(R.id.kontrolDugme);
        kontrolDugme.setOnClickListener(kontrolTikla);
        pasDugme = findViewById(R.id.pasDugme);
        pasDugme.setOnClickListener(pasTikla);
        resim1 = findViewById(R.id.resim1);
        resim2 = findViewById(R.id.resim2);
        resim3 = findViewById(R.id.resim3);
        cevapYazi = findViewById(R.id.cevapYazi);
        soruGoster();
    }

    protected void adaylariBul(){
        soruListesi = new SoruListesi();
        for (int i = 0; i < resimSozluk.uzunluk(); i++){
            Resim resim1 = resimSozluk.resimGetir(i);
            String kelime1 = resim1.kelimeGetir();
            for (int j = 0; j < resimSozluk.uzunluk(); j++){
                Resim resim2 = resimSozluk.resimGetir(j);
                String kelime2 = resim2.kelimeGetir();
                if (sozluk.sozlukteBaslayanKelimeVarMi(kelime1 + kelime2) && kelime1.length() * kelime2.length() > 1){
                    for (int k = 0; k < resimSozluk.uzunluk(); k++){
                        Resim resim3 = resimSozluk.resimGetir(k);
                        String kelime3 = resim3.kelimeGetir();
                        if ((kelime1.length() > 1 && kelime2.length() > 1) || (kelime1.length() > 1 && kelime3.length() > 1) || (kelime2.length() > 1 && kelime3.length() > 1)){
                            String arananKelime = kelime1 + kelime2 + kelime3;
                            if (sozluk.sozlukteKelimeVarMi(arananKelime) == true){
                                SoruAday soruAday = new SoruAday(resim1, resim2, resim3);
                                soruListesi.adaySoruEkle(soruAday);
                            }
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
        resimGoster(resim3, 2);
    }

}
