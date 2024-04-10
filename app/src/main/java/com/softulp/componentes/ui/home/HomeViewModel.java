package com.softulp.componentes.ui.home;

import android.app.Application;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends AndroidViewModel {

    private   MutableLiveData<String> mText;

    public HomeViewModel(@NonNull Application application) {
        super(application);

    }


    public LiveData<String> getText() {
        if(mText==null){
            mText=new MutableLiveData<>();
        }

        return mText;
    }

    public void accederARegistroDellamadas(){

        Uri llamadas = Uri.parse("content://call_log/calls");
        ContentResolver cr=getApplication().getContentResolver();
        Cursor cursor=cr.query(llamadas,null,null,null,null);
        StringBuilder sb=new StringBuilder("Listado \n");
        if(cursor.getCount()>0){

            String numero="";
            String duracion="";
            int indice=-1;
            while (cursor.moveToNext()){
                indice=cursor.getColumnIndex(CallLog.Calls.NUMBER);
                if(indice>=0){
                    numero=cursor.getString(indice);
                    Log.d("salida numero",numero);
                }
                indice= cursor.getColumnIndex(CallLog.Calls.DURATION);
                if(indice >=0){
                    duracion=cursor.getString(indice);
                    Log.d("salida duracion",duracion);
                }

                sb.append(duracion);
                sb.append(" ");
                sb.append(numero);
                sb.append("\n");
                



            }
            mText.setValue(sb.toString());

        }
    }
}