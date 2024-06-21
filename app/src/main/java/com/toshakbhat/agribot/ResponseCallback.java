package com.toshakbhat.agribot;

public interface ResponseCallback {
    void onResponse(String response);

    void onError(Throwable throwable);
}
