package com.example.resfebe;

public class Resim {
    private String dosyaNo;
    private String kelime;

    public Resim(String dosyaNo, String kelime){
        this.dosyaNo = dosyaNo;
        this.kelime = kelime;
    }

    public String dosyaNoGetir() {
        return dosyaNo;
    }

    public String kelimeGetir() {
        return kelime;
    }


}
