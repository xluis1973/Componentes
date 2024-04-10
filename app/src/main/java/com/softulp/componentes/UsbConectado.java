package com.softulp.componentes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class UsbConectado extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        boolean estado=intent.getBooleanExtra("connected",false);
        if(estado){
            Toast.makeText(context,"Usb conectado",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(context,"Usb Desconectado",Toast.LENGTH_LONG).show();
        }


    }
}