package com.example.myapplication2bystrov;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import com.example.myapplication2bystrov.databinding.ActivityLinearLayoutBinding;

import java.util.Objects;


public class LinearLayout extends AppCompatActivity {
    String tag = "MY_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLinearLayoutBinding binding = ActivityLinearLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageView1.setImageResource(R.drawable.ic_launcher_foreground);

        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("bystrov").toString();
        binding.textView1.setText(name);

        Button button = findViewById(R.id.button3);
        button.setOnClickListener(view -> {
            Log.d(tag, "клик на кнопку на RelativeLayout");
            Intent result = new Intent();
            String resultValue = binding.editTextText1.getText().toString();
            result.putExtra("right?", resultValue);
            setResult(Activity.RESULT_OK, result);
            finish();
        });


    }
}