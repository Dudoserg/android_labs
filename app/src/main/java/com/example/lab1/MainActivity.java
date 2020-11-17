package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText editText_name;
    Button button_confirm;
    TextView textView_inputYourName;
    TextView textView_dataFromSecondActivity;

    public final static int RESULT_CODE_SECOND_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        initListener();
    }

    private void initComponents() {
        editText_name = (EditText) findViewById(R.id.editText_name);
        button_confirm = (Button) findViewById(R.id.button_confirm);
        textView_inputYourName = (TextView) findViewById(R.id.textView_inputYourName);
        textView_dataFromSecondActivity = (TextView) findViewById(R.id.textView_dataFromSecondActivity);
    }

    private void initListener() {
        button_confirm.setOnClickListener(view -> {
            String name = editText_name.getText().toString();
//            textView_inputYourName.setText(name);
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("data", name);
            startActivityForResult(intent, RESULT_CODE_SECOND_ACTIVITY);
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        switch (requestCode) {
            case RESULT_CODE_SECOND_ACTIVITY: {
                String data = intent.getStringExtra("data");
                textView_dataFromSecondActivity.setText(data);
            }
            default:
                super.onActivityResult(requestCode, resultCode, intent);
        }
    }

}