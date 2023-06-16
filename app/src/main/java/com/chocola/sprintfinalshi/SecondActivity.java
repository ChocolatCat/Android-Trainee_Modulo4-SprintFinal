package com.chocola.sprintfinalshi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chocola.sprintfinalshi.databinding.ActivitySecondBinding;
import com.google.android.material.appbar.MaterialToolbar;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MaterialToolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button linkedin = binding.buttonLinkedin;
        Button whatsapp = binding.buttonWhatsapp;
        Button correo = binding.buttonCorreo;
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.linkedin.com/in/chocolat-cat/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Link para generar chat de wsp
                String url = "https://wa.me/56946366301";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        correo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_EMAIL, getString(R.string.mymail));
                i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject));
                i.putExtra(Intent.EXTRA_TEXT, binding.editTextMensaje.getText().toString());
                try {
                    startActivity(Intent.createChooser(i, "Send email using..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(SecondActivity.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}