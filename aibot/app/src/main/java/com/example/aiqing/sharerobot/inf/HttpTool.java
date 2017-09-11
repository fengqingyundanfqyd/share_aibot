package com.example.aiqing.sharerobot.inf;

import android.content.Context;
import android.content.SharedPreferences;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by aiqing on 2017/7/28.
 */

public class HttpTool {


    private static String BASEURL = "http://192.168.1.150:8083/";
   // private static OkHttpClient mOkHttpClient;
    private final Context context;
    private String mCookie;

    public HttpTool(Context context) {
        this.context=context;
        SharedPreferences sp = context.getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = sp.getString("mCookie", "");
    }

//    public s
// tatic void post(URL url, Map<String, String> prames, Handler handlersucess, Handler handlerfail){
//        Retrofit builder = new Retrofit.Builder()
//                .baseUrl(baseUrl+url)
//                .client(mOkHttpClient)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }

    public OkHttpClient  client(){
        OkHttpClient   okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new ReadCookiesInterceptor());
        okHttpClient.interceptors().add(new SaveCookiesInterceptor());
        okHttpClient.setConnectTimeout(15, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(15, TimeUnit.SECONDS);
        return okHttpClient;
    }


    //用来加入cookie
    public  class ReadCookiesInterceptor implements Interceptor {

        @Override
        public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();
            builder.addHeader("Cookie", "JSESSIONID=" + mCookie);
            return chain.proceed(builder.build());
        }
    }

    //用来保存Cookies
    public  class SaveCookiesInterceptor implements Interceptor {
        @Override
        public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
            com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());

            if (!originalResponse.headers("Set-Cookie").isEmpty()) {
                HashSet<String> cookies = new HashSet<>();

                for (String header : originalResponse.headers("Set-Cookie")) {
                    cookies.add(header);
                }

            }
            return originalResponse;
        }
    }
}
