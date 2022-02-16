package com.example.startstop;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Runnable
{
    Button btnstart,btnstop;
    TextView txtdisplay;
    int i=0;
    boolean flag;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnstart=findViewById(R.id.btn_start);
        btnstop=findViewById(R.id.btn_stop);
        txtdisplay=findViewById(R.id.txt_display);
        btnstart.setOnClickListener(this);
        btnstop.setOnClickListener(this);
    }

    Handler hand=new Handler()
    {
        @SuppressLint("SetTextI18n")
        public void handleMessage(Message m){
            txtdisplay.setText(" "+m.what);
        }
    };

    @Override
    public void onClick(View view)
    {
        if(view.equals(btnstart))
        {
            flag=true;
            thread=new Thread(this);
            thread.start();
        }
        else if (view.equals(btnstop))
        {
            flag = false;
        }
    }

    @Override
    public void run()
    {
        while(i<10 && flag)
        {
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            hand.sendEmptyMessage(i);
            i++;
        }
    }



}