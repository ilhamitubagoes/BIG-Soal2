package com.ilhambagoest.soal2.ui.chat;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ilhambagoest.soal2.R;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}