package com.example.resfebe;

import java.util.ArrayList;

public class SoruAday {
    private ArrayList<Resim> resimler;

    public SoruAday(Resim resim1, Resim resim2){
        resimler = new ArrayList<>();
        resimler.add(resim1);
        resimler.add(resim2);
    }

    public SoruAday(Resim resim1, Resim resim2, Resim resim3){
        resimler = new ArrayList<>();
        resimler.add(resim1);
        resimler.add(resim2);
        resimler.add(resim3);
    }

    public SoruAday(Resim resim1, Resim resim2, Resim resim3, Resim resim4){
        resimler = new ArrayList<>();
        resimler.add(resim1);
        resimler.add(resim2);
        resimler.add(resim3);
        resimler.add(resim4);
    }

    public Resim getirResim(int index){
        return resimler.get(index);
    }

    public String cevapGetir(){
        String result = resimler.get(0).kelimeGetir();
        for (int i = 1; i < resimler.size(); i++){
            result = result + resimler.get(i).kelimeGetir();
        }
        return result;
    }
}
