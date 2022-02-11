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

import com.example.wearapp3.databinding.ActivityPresentBinding;

public class present extends Activity {



    private TextView mTextView;
    private ActivityPresentBinding binding;

    private int ids_respuestaspr[] ={
            R.id.respr, R.id.respr2, R.id.respr3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPresentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        TextView vistapreguntapr = (TextView) findViewById(R.id.vistapreguntapr);
        vistapreguntapr.setText(R.string.questionpresent);

        String[] answerspresent = getResources().getStringArray(R.array.answerspresent);

        for (int i = 0; i < ids_respuestaspr.length; i++){
            RadioButton rb = (RadioButton) findViewById(ids_respuestaspr[i]);
            rb.setText(answerspresent[i]);
        }


        final int correctpresent = getResources().getInteger(R.integer.correctpresent);

        final RadioGroup group = (RadioGroup) findViewById(R.id.gruporespr);
        Button bpresent = (Button) findViewById(R.id.bpresent);
        bpresent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int id = group.getCheckedRadioButtonId();
                int respuesta = -1;
                for (int i = 0; i < ids_respuestaspr.length; i++){
                    if (ids_respuestaspr[i] == id){
                        respuesta = i;
                    }
                }
                if (respuesta == correctpresent){
                    Toast.makeText(present.this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
                    Intent pre = new Intent(present.this, MainActivity.class);
                    startActivity(pre);
                } else{
                    Toast.makeText(present.this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}