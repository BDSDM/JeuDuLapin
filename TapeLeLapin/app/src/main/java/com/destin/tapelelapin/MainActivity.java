package com.destin.tapelelapin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.destin.tapelelapin.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.net.ssl.SSLSessionBindingEvent;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    List<Button> boutons = new ArrayList<>();
    int positionDuLapin;
    int pafs = 0;
    int flops = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        boutons.add(binding.b1);
        boutons.add(binding.b2);
        boutons.add(binding.b3);
        boutons.add(binding.b4);

        bougeLeLapin();







        for(Button b: boutons) {
            b.setOnClickListener(view -> {
                reagirClic(view);
            });
        }

    }

    private void reagirClic(View view) {
        Button boutonDuLapin = boutons.get(positionDuLapin);
        if (view == boutonDuLapin){
            Log.i("TAPELAPIN","Bravo tape le lapin");
            pafs++;
            binding.pafs.setText(pafs+ " pafs");
            bougeLeLapin();
        }else{
            Log.i("TAPELAPIN","Ouch tape une taupe");
            flops++;
            binding.flops.setText(flops+ " flops");


        }

    }

    private void bougeLeLapin() {
        for(Button b:boutons){
            b.setText("taupe");
        }

        Random random = new Random();
        positionDuLapin = random.nextInt(4);
        Button b = boutons.get(positionDuLapin);
        b.setText("lapin");
    }


}