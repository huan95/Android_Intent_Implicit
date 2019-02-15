package com.example.intent_implicit;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import static android.Manifest.permission.CALL_PHONE;


public class MainActivity extends AppCompatActivity {

    ImageView imgBrowser, imgMessenger, imgPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBrowser = (ImageView) findViewById(R.id.imageBrowser);
        imgMessenger = (ImageView) findViewById(R.id.imageMessenger);
        imgPhone = (ImageView) findViewById(R.id.imagePhone);

        imgPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0376533970"));
//                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                    startActivity(intent);
//                } else {
//                    requestPermissions(new String[]{CALL_PHONE}, 1);
//                }

                startActivity(intent);
            }
        });

        imgMessenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
//                intent.putExtra("sms_body", "Hello!");
                intent.setData(Uri.parse("sms:0376533970"));
                startActivity(intent);
            }
        });

        imgBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);//mo 1 web thong qua trinh duyet mac dinh cua thiet bi
                intent.setData(Uri.parse("https://www.youtube.com"));
                startActivity(intent);
            }
        });
    }
}
