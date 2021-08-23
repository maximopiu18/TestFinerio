package com.example.testfinerio.ui.custom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testfinerio.R;

public class AlertDialogs {

    private AlertDialog alertDialogRest;
    public void dialogCustomButtonAccept(Context context, String tittle ,String message){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        View dialogView = inflater.inflate(R.layout.alertdialog_custom, null);
        dialogBuilder.setView(dialogView);

        Button btnAceptar = (Button) dialogView.findViewById(R.id.alertdialog_custom_btn_aceptar);
        Button btnSalir= (Button) dialogView.findViewById(R.id.alertdialog_custom_btn_aceptar);
        final TextView tvTittle = (TextView) dialogView.findViewById(R.id.alertdialog_custom_tv_tittle);
        final TextView tvMessage = (TextView) dialogView.findViewById(R.id.alertdialog_custom_tv_message);
        final AlertDialog alertDialog = dialogBuilder.create();
        tvTittle.setText(""+tittle);
        tvMessage.setText(""+message);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

            }
        });
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    public void dialogCustomDownload(Context context){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View dialogView = inflater.inflate(R.layout.alertdialog_custom_download, null);
        dialogBuilder.setView(dialogView);
        alertDialogRest = dialogBuilder.create();
        alertDialogRest.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialogRest.show();
    }
    public void dialogHideCustomDownload(){
        alertDialogRest.dismiss();
    }


}
