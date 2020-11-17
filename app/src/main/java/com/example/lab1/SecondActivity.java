package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textView_dataFromFirstActivity;
    EditText editText_result;
    Button button_return;

    Intent intent;
    String dataFromFirstActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initComponents();
        init();
        initListener();
        start();
    }

    private void initListener() {
        this.button_return.setOnClickListener(viev ->{
            Intent intent = new Intent();
            intent.putExtra("data", editText_result.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });
    }

    private void initComponents() {
        this.textView_dataFromFirstActivity = (TextView)findViewById(R.id.textView_dataFromFirstActivity);
        this.editText_result = (EditText)findViewById(R.id.editText_result);
        this.button_return = (Button)findViewById(R.id.button_return);
    }

    private void init() {
        intent = this.getIntent();
    }

    private void start() {
        this.dataFromFirstActivity = intent.getStringExtra("data");
        this.textView_dataFromFirstActivity.setText(this.dataFromFirstActivity);
    }
}
