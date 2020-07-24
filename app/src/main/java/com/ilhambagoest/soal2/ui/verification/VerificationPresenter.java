package com.ilhambagoest.soal2.ui.verification;

import com.ilhambagoest.soal2.data.entity.DataUser;

class VerificationPresenter {

    VerificationView verificationView;

    public VerificationPresenter(VerificationView verificationView) {
        this.verificationView = verificationView;
    }

    void login(String numberPhone) {

        // Hardcore Test
        // Minimal kode negara + 10 digit ==> 11 Digit angka
        if (numberPhone.equals("621234567890")){
            verificationView.showLoginSuccess(new DataUser(1,
                    "Ilham Bagoes",
                    "Admin",
                    "20 Sep 1996",
                    "data:image/jpeg;base64,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"));
        } else {
            verificationView.showLoginFailed(new Throwable("Terjadi kesalahan di sistem, silahkan coba lagi"));
        }

        /*ApiUtils.getAPIService().loginUser(numberPhone).enqueue(new Callback<DataUser>() {
            @Override
            public void onResponse(@NotNull Call<DataUser> call, @NotNull Response<DataUser> response) {
                loginView.showLoginSuccess(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<DataUser> call, @NotNull Throwable t) {
                loginView.showLoginFailed(t);
            }
        });*/
    }
}