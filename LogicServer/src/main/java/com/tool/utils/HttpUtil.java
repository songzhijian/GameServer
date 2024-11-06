package com.tool.utils;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HttpUtil {

    private static final OkHttpClient client = new OkHttpClient();

    static {
        client.newBuilder().connectTimeout(60,TimeUnit.MINUTES).
                readTimeout(60,TimeUnit.MINUTES); // connect timeout
    }

    public static void postJson(String url,String json) {
        //创建一个RequestBody(参数1：数据类型 参数2传递的json串)
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
//创建一个请求对象
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
//发送请求获取响应
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(Call arg0, Response response) {
                try {
                    System.out.println("onResponse"+response.body().string());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onFailure(Call arg0, IOException arg1) {
                System.out.println("onFailure");
            }
        });
    }
}
