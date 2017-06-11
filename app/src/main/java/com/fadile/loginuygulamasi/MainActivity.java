package com.fadile.loginuygulamasi;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button giris, cikis;
    EditText isim, sifre;
    TextView kalan;

    int sayici = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        giris = (Button) findViewById(R.id.login);
        cikis = (Button) findViewById(R.id.cancel);

        isim = (EditText) findViewById(R.id.etisim);
        sifre = (EditText) findViewById(R.id.etsifre);
        kalan = (TextView) findViewById(R.id.kalanhak);


        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isim.getText().toString().equals("kullanici1") &&
                        sifre.getText().toString().equals("sifre1")) {
                    Toast.makeText(getApplicationContext(), "Giriş Başarılı", Toast.LENGTH_LONG).show();
                    //2.aktiviteye geçiş
                    Intent intent=new Intent(MainActivity.this,Second.class);
                    startActivity(intent);



                    kalan.setText(""+sayici);
                } else {
                    Toast.makeText(MainActivity.this, "Şifreniz ve Kullanıcı adı hatalı", Toast.LENGTH_SHORT).show();
                    sayici--;
                    if (sayici <= 2) {
                        kalan.setText(""+sayici);
                        kalan.setBackgroundColor(Color.RED);
                    }
                    if(sayici <=0) {
                        sayici=0;
                        kalan.setText(""+sayici);
                        giris.setEnabled(false);
                    }
                }
            }
        });


        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
