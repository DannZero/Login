package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    ImageView imageView;
    TextView ageText;
    TextView signName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = (ImageView) findViewById(R.id.imageView);
        ageText = (TextView) findViewById(R.id.age);
        signName = (TextView) findViewById(R.id.sign_name);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String birth = intent.getStringExtra("Date");
        String age = intent.getStringExtra("Age");

        ageText.setText(age);

        String [] strDate = birth.toString().split("/");
        int numSign = Integer.parseInt(strDate[2]) % 12;
        numSign++;
        switch (numSign){
            case 1:
                signName.setText(R.string.monkey);
                imageView.setImageResource(R.drawable.i1mono);
                break;
            case 2:
                signName.setText(R.string.rooster);
                imageView.setImageResource(R.drawable.i2gallo);
                break;
            case 3:
                signName.setText(R.string.dog);
                imageView.setImageResource(R.drawable.i3perro);
                break;
            case 4:
                signName.setText(R.string.pig);
                imageView.setImageResource(R.drawable.i4cerdo);
                break;
            case 5:
                signName.setText(R.string.rat);
                imageView.setImageResource(R.drawable.i5rata);
                break;
            case 6:
                signName.setText(R.string.ox);
                imageView.setImageResource(R.drawable.i6buey);
                break;
            case 7:
                signName.setText(R.string.tiger);
                imageView.setImageResource(R.drawable.i7tigre);
                break;
            case 8:
                signName.setText(R.string.rabbit);
                imageView.setImageResource(R.drawable.i8conejo);
                break;
            case 9:
                signName.setText(R.string.dragon);
                imageView.setImageResource(R.drawable.i9dragon);
                break;
            case 10:
                signName.setText(R.string.serpent);
                imageView.setImageResource(R.drawable.i10serpiente);
                break;
            case 11:
                signName.setText(R.string.horse);
                imageView.setImageResource(R.drawable.i11caballo);
                break;
            case 12:
                signName.setText(R.string.goat);
                imageView.setImageResource(R.drawable.i12cabra);
                break;
        }


    }
}
