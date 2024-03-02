package com.example.myapplication2bystrov;

import static android.content.ContentValues.TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication2bystrov.databinding.ActivityMainBinding;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    String tag = "MY_TAG";
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.constraintButton);

        btn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Constraint Button Pressed");
                Intent intent = new Intent(getApplicationContext(), ConstraintLayout.class);
                startActivity(intent);
            }
        });

        Button btn1 = (Button) findViewById(R.id.linearButton);

        btn1.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Linear Button Pressed");
                Intent intent = new Intent(getApplicationContext(), LinearLayout.class);
                intent.putExtra("bystrov", "cool man");
                launcher.launch(intent);
            }
        });

        Button btn2 = (Button) findViewById(R.id.relativeButton);

        btn2.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Relative Button Pressed");
                Intent intent = new Intent(getApplicationContext(), RelativeLayout.class);
                startActivity(intent);
            }
        });
    }

    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent data = result.getData();
                    if (data == null) return;

                    binding.resultTv.setText(data.getStringExtra("right?"));
                }
            }
    );
}