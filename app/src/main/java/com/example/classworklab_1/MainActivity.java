package com.example.classworklab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public Integer checkNum(String ageS){
        Integer age;
        try {
            age=Integer.valueOf(ageS);
            return age;
        }catch (NumberFormatException e){
            return -1;
        }
    }

    public void check(View view){
        EditText editTextName=(EditText)findViewById(R.id.editTextTextPersonName);
        String name;
        EditText editTextAge=(EditText)findViewById(R.id.editTextTextPersonAge);
        String ageS;
        Integer age;
        RadioGroup radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        name=editTextName.getText().toString();
        ageS=editTextAge.getText().toString();
        RadioButton button = (RadioButton)findViewById(R.id.radioButton);
        RadioButton button2 = (RadioButton)findViewById(R.id.radioButton2);

        if(name.length()==0){
            editTextName.requestFocus();
            editTextName.setError("Enter your name");
        }
        else if(ageS.length()==0){
            editTextAge.requestFocus();
            editTextAge.setError("Enter your age.");
        }else if(checkNum(ageS)<0||checkNum(ageS)>150){
            editTextAge.requestFocus();
            editTextAge.setError("Age must be from 1 to 150");
        }
        else if (button.isChecked()==false&&button2.isChecked()==false){
            radioGroup.requestFocus();
            button.setError("Select one of them");
            button2.setError("Select one of them");
        }
        else {
            button.setError(null);
            button2.setError(null);
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("name", name);
            startActivity(intent);
        }
    }
}