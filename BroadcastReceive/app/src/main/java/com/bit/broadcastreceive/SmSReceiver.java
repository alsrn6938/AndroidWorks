package com.bit.broadcastreceive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmSReceiver extends BroadcastReceiver {

    private static final String TAG = "SmsReceiver";

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive 호출됨");

        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSmsMessage(bundle);

        if(messages.length > 0){
            String sender = messages[0].getOriginatingAddress();
            Log.d(TAG, "sender : " + sender);

            String content = messages[0].getMessageBody().toString();
            Log.d(TAG, "content : " + content);

            Date date = new Date(messages[0].getTimestampMillis());
            Log.d(TAG, "date : " + date);

            sendToActivity(context, sender, content, date);

        }
    }
    private void sendToActivity(Context context, String sender, String content, Date date){
        Intent intent = new Intent(context, Receiver.class);
        intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK|
                        intent.FLAG_ACTIVITY_CLEAR_TOP|
                        intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("sender", sender);
        intent.putExtra("content", content);
        intent.putExtra("date", format.format(date));
        context.startActivity(intent);
    }

    private SmsMessage[] parseSmsMessage(Bundle bundle){
        Object[] objs = (Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[objs.length];


        for(int i = 0; i < objs.length; i++){
            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[])objs[i], format);
            }
            else {
                messages[i] = SmsMessage.createFromPdu((byte[])objs[i]);
            }


        }

        return messages;
    }
}
