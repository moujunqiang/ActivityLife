package com.android.hsm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TwoActivity extends AppCompatActivity {
    AlertDialog show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomizeDialog();
            }
        });
    }

    private void showCustomizeDialog() {
        /* @setView 装入自定义View ==> R.layout.dialog_customize
         * 由于dialog_customize.xml只放置了一个EditView，因此和图8一样
         * dialog_customize.xml可自定义更复杂的View
         */
        final AlertDialog.Builder customizeDialog =
                new AlertDialog.Builder(TwoActivity.this);
        final View dialogView = LayoutInflater.from(TwoActivity.this)
                .inflate(R.layout.dialog_login, null);
        customizeDialog.setView(dialogView);

        Button login = dialogView.findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TwoActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                show.dismiss();
            }
        });
        show = customizeDialog.show();
    }
}