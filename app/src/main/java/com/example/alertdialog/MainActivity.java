package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button closeButton;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        closeButton = findViewById(R.id.button);
        builder = new AlertDialog.Builder(this);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Do you want to exit?").setCancelable(false).setPositiveButton("Yes", (dialog, id) -> {
                    finish();
                    Toast.makeText(getApplicationContext(),"App exited", Toast.LENGTH_SHORT).show();
                }).setNegativeButton("No", (dialog, id) -> {
                    dialog.cancel();
                    Toast.makeText(getApplicationContext(),"Cancelled", Toast.LENGTH_SHORT).show();
                });

                AlertDialog alert = builder.create();
                alert.setTitle("Warning");
                alert.show();
            }
        });
    }
}