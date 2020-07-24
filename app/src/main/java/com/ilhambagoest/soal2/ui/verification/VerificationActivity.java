package com.ilhambagoest.soal2.ui.verification;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ilhambagoest.soal2.R;
import com.ilhambagoest.soal2.data.SessionManager;
import com.ilhambagoest.soal2.data.api.ApiUtils;
import com.ilhambagoest.soal2.data.entity.DataUser;
import com.ilhambagoest.soal2.ui.register.RegisterActivity;
import com.mukesh.OtpView;

public class VerificationActivity extends AppCompatActivity implements VerificationView {

    String numberPhone = "0";
    String codeOTP = "";
    VerificationPresenter presenter;
    SessionManager session;
    OtpView otpView;
    TextView tvTimer, tvChangeNumber;
    Button btnVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        presenter = new VerificationPresenter(this);
        session = new SessionManager(ApiUtils.getDefaultPreferences(this));

        if (getIntent() != null){
            numberPhone = getIntent().getStringExtra("NUMBER_PHONE");
        }

        tvTimer = findViewById(R.id.tv_timer);
        tvChangeNumber = findViewById(R.id.tv_change_number);
        btnVerify = findViewById(R.id.btn_verify);
        otpView = findViewById(R.id.otp_view);
        btnVerify.setEnabled(true);

        initEvent();
    }

    private void initEvent() {
        new CountDownTimer(30000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("Waktu Tersisa : " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                tvTimer.setText(R.string.label_time_up);
                btnVerify.setEnabled(false);
            }
        }.start();

        otpView.setOtpCompletionListener(otp -> codeOTP = otp);
        tvChangeNumber.setOnClickListener(v -> finish());

        btnVerify.setOnClickListener(v -> {
            // Hardcode
            if (codeOTP.equals("123456")){
                presenter.login(numberPhone);
            } else {
                Toast.makeText(this, "Code OTP Tidak Sesuai", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void showLoginSuccess(DataUser dataUser) {
        session.setIsLogin();
        session.setUserId(dataUser.getId());
        session.setUserName(dataUser.getName());
        session.setUserPosition(dataUser.getPosition());
        session.setUserBirthDate(dataUser.getBirthDate());
        session.setUserUrlPhoto(dataUser.getUrlPhoto());

        Intent intent = new Intent(this, RegisterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void showLoginFailed(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}