package com.pm.payments.util;

import okhttp3.*;

public class NetUtil {

    private static final OkHttpClient client = new OkHttpClient();

    public static void post(String url) throws Exception {

        RequestBody formBody = new FormBody.Builder()
                .add("username", "test")
                .add("password", "test")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();


    }

    public static void get(String url) throws Exception {

    }
}
