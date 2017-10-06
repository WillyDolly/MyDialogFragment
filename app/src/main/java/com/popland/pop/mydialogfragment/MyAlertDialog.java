package com.popland.pop.mydialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by hai on 18/07/2016.
 */
public class MyAlertDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Warning!!!");
//        builder.setMessage("there is a fatal error");
//        builder.setIcon(R.mipmap.ic_launcher);
//        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getActivity(), "yes", Toast.LENGTH_LONG).show();
//                dismiss();
//            }
//        });
//        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getActivity(),"no",Toast.LENGTH_LONG).show();
//                dismiss();
//            }
//        });
        String items[] ={"agree","cancel"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which){
                    case 0: Toast.makeText(getActivity(),"agree",Toast.LENGTH_LONG).show();break;
                    case 1: Toast.makeText(getActivity(),"cancel",Toast.LENGTH_LONG).show();break;
                }
            }
        });
        Dialog dialog = builder.create();
        return dialog;
    }
}
