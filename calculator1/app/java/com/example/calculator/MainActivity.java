package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener, ServiceConnection {
    EditText txtfirst, txtsecond;
    Button btnadd, btnsub, btnmul;
    TextView txtresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtfirst = (EditText) findViewById(R.id.txt_first);
        txtsecond = (EditText) findViewById(R.id.txt_second);
        txtresult = (TextView) findViewById(R.id.txt_result);
        btnadd = (Button) findViewById(R.id.btn_add);
        btnadd.setOnClickListener(this);
        btnsub = (Button) findViewById(R.id.btn_sub);
        btnsub.setOnClickListener(this);
        btnmul = (Button) findViewById(R.id.btn_mul);
        btnmul.setOnClickListener(this);
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }

    @Override
    public void onClick(View v) {
        String s1 = txtfirst.getText().toString();
        String s2 = txtsecond.getText().toString();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        if (v.equals(btnadd)) {
            int result = a+b;

            txtresult.setText("" + String.valueOf(result));
        } else if (v.equals(btnsub)) {
            int result = a-b;
            txtresult.setText("" +  String.valueOf(result));
        }
        else if (v.equals(btnmul)){
            int result = a*b;
            txtresult.setText(""+String.valueOf(result));
        }

    }
}