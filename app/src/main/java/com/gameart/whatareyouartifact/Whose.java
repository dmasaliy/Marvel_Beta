package com.gameart.whatareyouartifact;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Whose extends AppCompatActivity {

    TextView textView;
    ImageView artifact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whose);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        textView = findViewById(R.id.textView);
        artifact = findViewById(R.id.artifact);

        roll();
    }

    private void roll() {
        int rollNumber = (int) (Math.random() * 3 + 1);

        switch (rollNumber) {
            case 1:
                artifact.setImageDrawable(getResources().getDrawable(R.drawable.capitan));
                textView.setText("Capitan America");
                Toast.makeText(this, "Capitan America", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                artifact.setImageDrawable(getResources().getDrawable(R.drawable.iron));
                textView.setText("Iron Man");
                Toast.makeText(this, "Iron Man", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                artifact.setImageDrawable(getResources().getDrawable(R.drawable.hulk));
                textView.setText("Hulk");
                Toast.makeText(this, "Hulk", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void restart(View view) {
        Intent intent = new Intent(Whose.this, MainActivity.class);
        startActivity(intent);
    }
}