package com.ilhambagoest.soal2.ui.notification;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.ilhambagoest.soal2.R;
import com.ilhambagoest.soal2.ui.chat.ChatActivity;

public class NotificationActivity extends AppCompatActivity {

    ConstraintLayout clNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        clNotif = findViewById(R.id.cl_notification);
        clNotif.setOnClickListener(v -> {
            Intent intent = new Intent(NotificationActivity.this, ChatActivity.class);
            startActivity(intent);
        });
    }
}