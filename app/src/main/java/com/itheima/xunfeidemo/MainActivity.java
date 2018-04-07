package com.itheima.xunfeidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText test;
    private Button button;
    private String message;
    private Speek speek;
    private Gson mGson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speek=new Speek(this);
        initView();
    }

    private void initView(){

        test=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.begin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message=test.getText().toString();
                if(!message.equals(""))
                {
                    speek.Speeking(message);
                }
                else
                {
                    speek.Speeking("请告诉我，您需要我说些什么");
                }
            }
        });
    }
}
