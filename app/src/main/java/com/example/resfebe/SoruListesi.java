package com.example.resfebe;

import java.util.ArrayList;
import java.util.Collections;

public class SoruListesi {
    private ArrayList<SoruAday> sorular;

    public SoruListesi(){
        sorular = new ArrayList<>();
    }

    public void adaySoruEkle(SoruAday soruAday){
        sorular.add(soruAday);
    }

    public int soruSayisi(){
        return sorular.size();
    }

    public void karistir(){
        Collections.shuffle(sorular);
    }

    public SoruAday soruGetir(int numara){
        return sorular.get(numara);
    }
}
