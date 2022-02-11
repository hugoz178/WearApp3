package com.example.wearapp3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wearapp3.databinding.ActivityPastBinding;

public class past extends Activity {

    private int ids_respuestaspa[] ={
            R.id.respa, R.id.respa2, R.id.respa3
    };

    private TextView mTextView;
    private ActivityPastBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityPastBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        TextView vistapreguntapa = (TextView) findViewById(R.id.vistapreguntapa);
        vistapreguntapa.setText(R.string.questionpast);

        String[] answerspast = getResources().getStringArray(R.array.answerspast);

        for (int i = 0; i < ids_respuestaspa.length; i++){
            RadioButton rb = (RadioButton) findViewById(ids_respuestaspa[i]);
            rb.setText(answerspast[i]);
        }


        final int correctpast = getResources().getInteger(R.integer.correctpast);

        final RadioGroup group = (RadioGroup) findViewById(R.id.grupopast);
        Button bcpast = (Button) findViewById(R.id.bcpast);
        bcpast.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int id = group.getCheckedRadioButtonId();
                int respuesta = -1;
                for (int i = 0; i < ids_respuestaspa.length; i++){
                    if (ids_respuestaspa[i] == id){
                        respuesta = i;
                    }
                }
                if (respuesta == correctpast){
                    Toast.makeText(past.this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
                    Intent pre = new Intent(past.this, MainActivity.class);
                    startActivity(pre);
                } else{
                    Toast.makeText(past.this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                }

            }
        });





    }
}