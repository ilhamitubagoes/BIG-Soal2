package com.ilhambagoest.soal2.ui.verification;


import com.ilhambagoest.soal2.data.entity.DataUser;

interface VerificationView {
    void showLoginSuccess(DataUser dataUser);
    void showLoginFailed(Throwable throwable);
}
