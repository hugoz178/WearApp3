package com.example.wearapp3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wearapp3.databinding.ActivityMainBinding;
import com.example.wearapp3.databinding.ActivityQuestionBinding;


public class MainActivity extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;

    Button bpast;
    Button bpreg;
    Button bpres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        bpast=(Button)findViewById(R.id.bpast);
        bpreg=(Button)findViewById(R.id.bpreg);
        bpres=(Button)findViewById(R.id.bpres);

        bpreg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent preg = new Intent(MainActivity.this, question.class);
                startActivity(preg);
            }
        });

        bpres.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent pregx = new Intent(MainActivity.this, present.class);
                startActivity(pregx);
            }
        });

        bpast.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, past.class);
                startActivity(i);
            }
        });

    }
}