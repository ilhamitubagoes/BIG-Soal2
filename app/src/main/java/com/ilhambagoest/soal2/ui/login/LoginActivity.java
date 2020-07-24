package com.ilhambagoest.soal2.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ilhambagoest.soal2.MainActivity;
import com.ilhambagoest.soal2.R;
import com.ilhambagoest.soal2.data.SessionManager;
import com.ilhambagoest.soal2.data.api.ApiUtils;
import com.ilhambagoest.soal2.ui.verification.VerificationActivity;
import com.rilixtech.widget.countrycodepicker.CountryCodePicker;

public class LoginActivity extends AppCompatActivity {

    String codeNumber = "62"; // Default Indonesia
    CountryCodePicker ccp;
    EditText etNumberPhone;
    Button btnLogin;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = new SessionManager(ApiUtils.getDefaultPreferences(this));

        ccp = findViewById(R.id.ccp);
        etNumberPhone = findViewById(R.id.et_number_phone);
        btnLogin = findViewById(R.id.btn_login);

        checkIsLogin();
        initEvent();
    }

    private void checkIsLogin() {
        if (session.isLogin()){
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else {
            Log.i(LoginActivity.class.getName(), "User Belum Login");
        }
    }

    private void initEvent() {

        ccp.setOnCountryChangeListener(selectedCountry -> codeNumber = selectedCountry.getPhoneCode());

        btnLogin.setOnClickListener(v -> {
            if (isValid()){
                Intent intent = new Intent(this, VerificationActivity.class);
                intent.putExtra("NUMBER_PHONE", codeNumber+etNumberPhone.getText().toString());
                startActivity(intent);
            }
        });
    }

    private boolean isValid() {
        if (TextUtils.isEmpty(etNumberPhone.getText().toString())){
            Toast.makeText(this, "Nomor Telepon Kosong", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (etNumberPhone.getText().length() < 10){
            Toast.makeText(this, "Nomor Telepon Anda kurang", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}