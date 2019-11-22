package com.example.resfebe.Ekran;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.resfebe.ResimSozluk;
import com.example.resfebe.SoruAday;
import com.example.resfebe.SoruListesi;
import com.example.resfebe.Sozluk;

import java.io.IOException;
import java.io.InputStream;

public abstract class GenelEkran extends Activity {
    protected ResimSozluk resimSozluk;
    protected Sozluk sozluk;
    protected SoruListesi soruListesi;
    protected Button kontrolDugme;
    protected Button pasDugme;
    protected ImageView resim1;
    protected ImageView resim2;
    protected EditText cevapYazi;
    protected int soruNo = 0;
    protected Context context;
    abstract protected void soruGoster();
    abstract protected void adaylariBul();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        context = this;
        resimSozluk = new ResimSozluk(this);
        sozluk = new Sozluk(this);
        adaylariBul();
        soruListesi.karistir();
    }

    protected String cevapGetir(){
        SoruAday soruAday = soruListesi.soruGetir(soruNo);
        return soruAday.cevapGetir();
    }

    protected AlertDialog diyalog(String mesaj, final boolean yeniSoru){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage(mesaj);
        builder1.setPositiveButton(
                "Tamam",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        if (yeniSoru){
                            soruNo++;
                            soruGoster();
                        }
                    }
                });
        return builder1.create();
    }

    protected void resimGoster(ImageView imageView, int index){
        try {
            SoruAday soruAday = soruListesi.soruGetir(soruNo);
            AssetManager assets = getAssets();
            InputStream resimInputStream = assets.open(soruAday.getirResim(index).dosyaNoGetir() + ".jpg");
            Bitmap resimDrawable = BitmapFactory.decodeStream(resimInputStream);
            imageView.setImageBitmap(resimDrawable);
        } catch (IOException e) {
            diyalog("Hatalı dosya " + e.toString(), false).show();
        }
    }

    protected View.OnClickListener kontrolTikla = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (cevapGetir().equals(cevapYazi.getText().toString())){
                diyalog("Doğru cevap!!!", true).show();
            }else{
                diyalog("Yanlış cevap!!!", false).show();
            }
        }
    };

    protected View.OnClickListener pasTikla = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            diyalog(cevapGetir(), true).show();
        }
    };

}
