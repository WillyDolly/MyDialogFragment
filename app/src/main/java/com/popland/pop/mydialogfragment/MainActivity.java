package com.popland.pop.mydialogfragment;

import android.app.Dialog;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Communicator{
Button BTNdialog, BTNalert, BTNnormalDialog, BTNyes, BTNno;
    FragmentManager fragmentManager;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BTNdialog = (Button)findViewById(R.id.BTNdialog);
        BTNalert = (Button)findViewById(R.id.BTNalert);
        BTNnormalDialog = (Button)findViewById(R.id.BTNnormalDialog);
        fragmentManager = getFragmentManager();
        BTNdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               MyDialogFragment dialogFragment = new MyDialogFragment();
               dialogFragment.show(fragmentManager,"dialog");
            }
        });

        BTNalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAlertDialog alertDialog = new MyAlertDialog();
                alertDialog.show(fragmentManager,"alert");
            }
        });

        dialog = new  Dialog(MainActivity.this);
        dialog.setContentView(R.layout.normal_dialog);
        BTNyes = (Button)dialog.findViewById(R.id.BTNyes);
        BTNno = (Button)dialog.findViewById(R.id.BTNno);
        BTNyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"yes",Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
        BTNno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"no",Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });
        BTNnormalDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void Nhandulieu(String data) {
        Toast.makeText(this,data,Toast.LENGTH_LONG).show();
    }
}
