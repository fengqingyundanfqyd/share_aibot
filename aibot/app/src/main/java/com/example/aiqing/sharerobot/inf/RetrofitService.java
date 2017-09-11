package com.example.aiqing.sharerobot.inf;


import com.example.aiqing.sharerobot.bean.PersonalInfoBean;
import com.example.aiqing.sharerobot.bean.ToLoginBean;

import retrofit.Call;
import retrofit.http.Header;
import retrofit.http.Query;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 *
 */
public interface RetrofitService {
//    @GET("getMethod")
//    Call<String> getTest();
//
//    @FormUrlEncoded
//    @POST("createUser")
//    Call<Void> createPerson(@Field("name") String name, @Field("age") String age);
    @FormUrlEncoded
    @POST("comm/doLoginNew.shtml")
    Call<ToLoginBean> login(@Header("JSESSIONID") String JSESSIONID, @Query("mobile") String mobile, @Query("yzCode") String yzCode, @Query("comeFrom") String comeFrom);


    /**
     * 获取个人资料信息
     *
     * @param JSESSIONID
     * @return
     */
    @FormUrlEncoded
    @POST("account/getCustInfo.shtml")
    Call<PersonalInfoBean> getPersonsInfo(@Header("JSESSIONID") String JSESSIONID);
}
