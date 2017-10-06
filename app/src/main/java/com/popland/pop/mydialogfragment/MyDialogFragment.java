package com.popland.pop.mydialogfragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by hai on 18/07/2016.
 */
public class MyDialogFragment extends DialogFragment {
    Button BTNyes, BTNno;
    Communicator com;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_fragment,container,false);
        BTNyes = (Button)v.findViewById(R.id.BTNyes);
        BTNno = (Button)v.findViewById(R.id.BTNno);
        com = (Communicator) getActivity();

        getDialog().setTitle("do your pick...");
        getDialog().setCanceledOnTouchOutside(true);
        BTNyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.Nhandulieu(" you pressed yes ");
                dismiss();
            }
        });

        BTNno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.Nhandulieu(" you pressed no ");
                dismiss();
            }
        });
        return v;
    }
}
