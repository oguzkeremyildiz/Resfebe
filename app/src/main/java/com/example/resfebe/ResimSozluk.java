package com.example.resfebe;

import android.content.Context;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ResimSozluk {
    private ArrayList<Resim> resimler;

    public ResimSozluk(Context current){
        resimler = new ArrayList<>();
        InputStream kaynak = current.getResources().openRawResource(R.raw.kelime);
        Scanner girdi = new Scanner(kaynak);
        int kelimeSayisi = girdi.nextInt();
        for (int i = 0; i < kelimeSayisi; i++){
            String dosyaNo = girdi.next();
            String kelime = girdi.next();
            Resim resim = new Resim(dosyaNo, kelime);
            resimler.add(resim);
        }
    }

    public int uzunluk(){
        return resimler.size();
    }

    public Resim resimGetir(int numara){
        return resimler.get(numara);
    }

}
