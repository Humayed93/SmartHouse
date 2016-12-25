package com.humayed.waleed.smarthouse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsR extends BroadcastReceiver {

    public SmsR() {
    }

    private String incomingNumber;
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Bundle extras = intent.getExtras();

        if (action.equals("android.provider.Telephony.SMS_RECEIVED")){
            Object[] pdus = (Object[]) extras.get("pdus");
            SmsMessage[] smsMessage = new SmsMessage[pdus.length];
            for (int i = 0; i < smsMessage.length; i++){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    String format = extras.getString("format");
                    smsMessage[i] = SmsMessage.createFromPdu((byte[]) pdus[i],format);
                }else{
                    smsMessage[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                incomingNumber = smsMessage[i].getOriginatingAddress();
                // 0595544545
                if (incomingNumber.equals("+966581988893")) {
                    String incomingMsg = smsMessage[i].getMessageBody();
                    displayToast(context, incomingMsg);
                    //displayToast(context, incomingNumber);
                }
            }
        }
    }
    private void displayToast(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }

}