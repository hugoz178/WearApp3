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

import com.example.wearapp3.databinding.ActivityQuestionBinding;


public class question extends Activity {

    private int ids_respuestas[] ={
            R.id.resp1, R.id.resp2, R.id.resp3
    };

    private TextView mTextView;
    private ActivityQuestionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    binding = ActivityQuestionBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

        TextView preg = (TextView) findViewById(R.id.preg);
        preg.setText(R.string.titulofuture);

        String[] respuestas = getResources().getStringArray(R.array.respuestas);

        for (int i = 0; i < ids_respuestas.length; i++){
            RadioButton rb = (RadioButton) findViewById(ids_respuestas[i]);
            rb.setText(respuestas[i]);
        }


        final int correct_resp = getResources().getInteger(R.integer.correct_resp);

        final RadioGroup group = (RadioGroup) findViewById(R.id.gruporesp);
        Button bconf = (Button) findViewById(R.id.bconf);
        bconf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int id = group.getCheckedRadioButtonId();
                int respuesta = -1;
                for (int i = 0; i < ids_respuestas.length; i++){
                    if (ids_respuestas[i] == id){
                        respuesta = i;
                    }
                }
                if (respuesta == correct_resp){
                    Toast.makeText(question.this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
                    Intent fut = new Intent(question.this, MainActivity.class);
                    startActivity(fut);
                } else{
                    Toast.makeText(question.this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}