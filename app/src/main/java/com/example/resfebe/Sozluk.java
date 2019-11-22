package com.example.resfebe;

import android.content.Context;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Sozluk {
    private ArrayList<String> sozluktekiKelimeler;
    private HashSet<String> sozluktekiKelimeler2;

    public Sozluk(Context current) {
        sozluktekiKelimeler = new ArrayList<>();
        sozluktekiKelimeler2 = new HashSet<>();
        InputStream kaynak = current.getResources().openRawResource(R.raw.sozluk);
        Scanner girdi = new Scanner(kaynak);
        int kelimeSayisi = girdi.nextInt();
        for (int i = 0; i < kelimeSayisi; i++) {
            String kelime = girdi.next();
            sozluktekiKelimeler.add(kelime);
            sozluktekiKelimeler2.add(kelime);
        }
        Collections.sort(sozluktekiKelimeler);
    }

    public boolean sozlukteKelimeVarMi(String kelime){
        return sozluktekiKelimeler2.contains(kelime);
    }

    public boolean sozlukteBaslayanKelimeVarMi(String kelime){
        int pozisyon = Collections.binarySearch(sozluktekiKelimeler, kelime);
        if (pozisyon < 0){
            if ((-(pozisyon + 1)) < sozluktekiKelimeler.size()){
                return sozluktekiKelimeler.get(-(pozisyon + 1)).startsWith(kelime);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

}
