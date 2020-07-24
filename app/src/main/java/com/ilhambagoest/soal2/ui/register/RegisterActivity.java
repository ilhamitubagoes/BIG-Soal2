package com.ilhambagoest.soal2.ui.register;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ilhambagoest.soal2.MainActivity;
import com.ilhambagoest.soal2.R;
import com.ilhambagoest.soal2.data.SessionManager;
import com.ilhambagoest.soal2.data.api.ApiUtils;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.UUID;

public class RegisterActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    SessionManager session;
    EditText etNumberMedic, etName, etBirthDate, etAddress, etEmail;
    Button btnLogin;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        session = new SessionManager(ApiUtils.getDefaultPreferences(this));
        etNumberMedic = findViewById(R.id.et_number_medic);
        etName = findViewById(R.id.et_name);
        etBirthDate = findViewById(R.id.et_birth_date);
        etAddress = findViewById(R.id.et_address);
        etEmail = findViewById(R.id.et_email);
        btnLogin = findViewById(R.id.btn_login);

        etNumberMedic.setText("Nomor Medic : #" + UUID.randomUUID().toString());
        etNumberMedic.setEnabled(false);
        etName.setText(session.getUserName());
        etBirthDate.setText(session.getUserBirthDate());
        etBirthDate.setOnClickListener(v -> showCalendar());
        btnLogin.setOnClickListener(v -> updateData());
    }

    private void updateData() {
        if (isValid()){
            session.setNumberMedic(etNumberMedic.getText().toString());
            session.setUserName(etName.getText().toString());
            session.setUserBirthDate(etBirthDate.getText().toString());
            session.setAddress(etAddress.getText().toString());
            session.setEmail(etEmail.getText().toString());

            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth + "/" + (monthOfYear+1) + "/" + year;
        etBirthDate.setText(date);
    }

    private void showCalendar(){
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(RegisterActivity.this,
                now.get(Calendar.YEAR), // Initial year selection
                now.get(Calendar.MONTH), // Initial month selection
                now.get(Calendar.DAY_OF_MONTH) // Inital day selection
        );
        dpd.show(getSupportFragmentManager(), "Datepickerdialog");
    }

    private Boolean isValid(){
        if (TextUtils.isEmpty(etName.getText().toString())){
            Toast.makeText(this, "Nama anda Kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(etBirthDate.getText().toString())){
            Toast.makeText(this, "Tanggal lahir anda Kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(etAddress.getText().toString())){
            Toast.makeText(this, "Alamat anda Kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(etEmail.getText().toString())){
            Toast.makeText(this, "Email anda Kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}