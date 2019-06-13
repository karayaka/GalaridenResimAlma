package com.example.kisar.galariresimalmadeneme;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ImageView ivgaleridengelen;
    Button btngaleriac;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==33){
            ivgaleridengelen=(ImageView)findViewById(R.id.ivGaleridengelen);
            Bitmap bitmap=null;
            if(bitmap!=null){
                bitmap.recycle();
            }
            InputStream stream;
            try {
                stream=getContentResolver().openInputStream(data.getData());
                bitmap= BitmapFactory.decodeStream(stream);
                stream.close();
                ivgaleridengelen.setImageBitmap(bitmap);

            }catch (Exception a){
                a.printStackTrace();
            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngaleriac=(Button)findViewById(R.id.btnGalariAc);

        btngaleriac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galeri_int=new Intent();
                galeri_int.setType("image/*");
                galeri_int.setAction(Intent.ACTION_GET_CONTENT);
                galeri_int.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(galeri_int,33);
            }
        });
    }
}
