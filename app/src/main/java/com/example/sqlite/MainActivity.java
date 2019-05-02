package com.example.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Helper.MyHelper;

public class MainActivity extends AppCompatActivity {

    EditText etword, etmeaning;
    Button btnaddword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      etword= findViewById(R.id.etword);
      etmeaning=findViewById(R.id.etmeaning);
      btnaddword=findViewById(R.id.btnaddword);

      final MyHelper myHelper = new MyHelper(this);
      final SQLiteDatabase sqLiteDatabase= myHelper.getWritableDatabase();

      btnaddword.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              long id = myHelper.InsertData(etword.getText().toString(), etmeaning.getText().toString(), sqLiteDatabase);
              if (id>0){
                  Toast.makeText(MainActivity.this, "successful" + id, Toast.LENGTH_SHORT).show();
              }
              else{
                  Toast.makeText(MainActivity.this, "Error" + id, Toast.LENGTH_SHORT).show();

              }

          }
      });
    }
}
