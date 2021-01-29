package com.example.whatsappwithoutsavingthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText editText2;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText2  = findViewById(R.id.edit_text2);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = editText2.getText().toString();
                if ( number.equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter the number first", Toast.LENGTH_SHORT).show();
                }else {
                    Uri uri = Uri.parse("smsto:" + number);
                    Intent i = new Intent(Intent.ACTION_SENDTO, uri);

                    i.setPackage("com.whatsapp");
                    startActivity(i);


                }
            }
        });

    }
}