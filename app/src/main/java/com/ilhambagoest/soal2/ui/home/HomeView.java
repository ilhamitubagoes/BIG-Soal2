package com.ilhambagoest.soal2.ui.home;


import java.util.List;

interface HomeView {
    void showImage(List<String> imageList);
    void showError(Throwable throwable);
}
