package com.example.phone_file_transfering;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button sending;
    Button receiving;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sending = findViewById(R.id.sending);
        receiving = findViewById(R.id.receiving);

        sending.setOnClickListener(this);
        receiving.setOnClickListener(this);
    }

    private void runSendActivity(){
        Intent intent = new Intent (this, Send.class);
        startActivity(intent);
    }

    private void runRecActivity(){

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.sending:
                Intent intent = new Intent (this, Send.class);
                startActivity(intent);
                break;

            case R.id.receiving:
                runRecActivity();
                break;
        }
    }


}