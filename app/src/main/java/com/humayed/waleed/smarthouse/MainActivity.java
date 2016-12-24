package com.humayed.waleed.smarthouse;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String  txtPhoneNum = "0567123154";

    Button btn_ACON;
    String txtMsg_ACON = "6";
    Button btn_ACOFF;
    String txtMsg_ACOFF = "7";

    Button btn_AlarmON;
    String txtMsg_AlarmON = "S";
    Button btn_AlarmOFF;
    String txtMsg_AlarmOFF = "D";

    Button btn_LightsON;
    String txtMsg_LightsON = "4";
    Button btn_LightsOFF;
    String txtMsg_LightsOFF = "5";

    Button btn_irrigationAuto;
    String txtMsg_irrigationAuto = "1";
    Button btn_irrigationManual;
    String txtMsg_irrigationManual = "2";

    Button btn_powerSaving;
    String txtMsg_powerSaving = "8";
    Button btn_irrigationON;
    String txtMsg_irrigationON = "3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_SMS},1);

        btn_ACON = (Button) this.findViewById(R.id.btn_ACON);
        btn_ACOFF = (Button) this.findViewById(R.id.btn_ACOFF);
        btn_AlarmON = (Button) this.findViewById(R.id.btn_AlarmON);
        btn_AlarmOFF = (Button) this.findViewById(R.id.btn_AlarmOFF);
        btn_LightsON = (Button) this.findViewById(R.id.btn_LightsON);
        btn_LightsOFF = (Button) this.findViewById(R.id.btn_LightsOFF);
        btn_irrigationAuto = (Button) this.findViewById(R.id.btn_irrigationAuto);
        btn_irrigationManual = (Button) this.findViewById(R.id.btn_irrigationManual);
        btn_powerSaving = (Button) this.findViewById(R.id.btn_powerSaving);
        btn_irrigationON = (Button) this.findViewById(R.id.btn_irrigationON);

        //SmsR msg = new SmsR();
        //msg.onReceive(getApplicationContext(),getIntent());

        btn_ACON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txtPhoneNum;
                String message = txtMsg_ACON;
                sendMessage(phoneNumber, message, "AC ON");
            }
        });
        btn_ACOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txtPhoneNum;
                String message = txtMsg_ACOFF;
                sendMessage(phoneNumber, message, "AC OFF");
            }
        });
        btn_AlarmON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txtPhoneNum;
                String message = txtMsg_AlarmON;
                sendMessage(phoneNumber, message, "Alarm ON");
            }
        });
        btn_AlarmOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txtPhoneNum;
                String message = txtMsg_AlarmOFF;
                sendMessage(phoneNumber, message, "Alarm OFF");
            }
        });
        btn_LightsON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txtPhoneNum;
                String message = txtMsg_LightsON;
                sendMessage(phoneNumber, message, "Lights ON");
            }
        });
        btn_LightsOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txtPhoneNum;
                String message = txtMsg_LightsOFF;
                sendMessage(phoneNumber, message, "Lights OFF");
            }
        });
        btn_irrigationAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txtPhoneNum;
                String message = txtMsg_irrigationAuto;
                sendMessage(phoneNumber, message, "Irrigation Auto");
            }
        });
        btn_irrigationManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txtPhoneNum;
                String message = txtMsg_irrigationManual;
                sendMessage(phoneNumber, message, "Irrigation Manual");
            }
        });
        btn_powerSaving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txtPhoneNum;
                String message = txtMsg_powerSaving;
                sendMessage(phoneNumber, message, "Power Saving ON");
            }
        });
        btn_irrigationON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txtPhoneNum;
                String message = txtMsg_irrigationON;
                sendMessage(phoneNumber, message, "Irrigation ON");
            }
        });
    }


    private void sendMessage(String phoneNumber, String message, String command){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage (phoneNumber, null, message, null, null);
            Toast.makeText(getApplicationContext(), command, Toast.LENGTH_LONG).show();
        } catch (Exception e){
            Toast.makeText(getApplicationContext(), "Command Fail. Please try again!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }


}
