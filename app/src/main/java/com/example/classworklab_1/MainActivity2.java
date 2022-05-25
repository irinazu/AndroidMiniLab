package com.example.classworklab_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle=getIntent().getExtras();
        String name=bundle.get("name").toString();
        TextView textView=(TextView) findViewById(R.id.textView);
        textView.setText(textView.getText()+" "+name);
    }


    public void changePage(View view){
        Intent intent=new Intent(this,MainActivity3.class);
        startActivity(intent);
    }

    public void changeBackground(View view){
        LinearLayout Layout = (LinearLayout) findViewById(R.id.mainLayout2);
        switch (count){
            case 0:
                Layout.setBackgroundColor(Color.parseColor("#b3f4c5"));
                count=1;
                break;
            case 1:
                Layout.setBackgroundColor(Color.parseColor("#ffffff"));
                count=0;
                break;
        }
    }

    public void changeText(View view){
        TextView textView=(TextView) findViewById(R.id.textView);
        textView.setText("Hello!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.menu_1:
                Toast.makeText(MainActivity2.this,"It is Settings",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_2:
                Toast.makeText(MainActivity2.this,"It is Saving",Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_3:
                Toast.makeText(MainActivity2.this,"It is Open",Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}