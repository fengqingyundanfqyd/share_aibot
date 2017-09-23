package com.example.aiqing.sharerobot.inf;

import com.example.aiqing.sharerobot.bean.AccountInfoBean;
import com.example.aiqing.sharerobot.bean.AddAddressBean;
import com.example.aiqing.sharerobot.bean.AgencyDisBean;
import com.example.aiqing.sharerobot.bean.AgencyIncomeBaen;
import com.example.aiqing.sharerobot.bean.AibotNumBean;
import com.example.aiqing.sharerobot.bean.AngentyBean;
import com.example.aiqing.sharerobot.bean.ApplyBean;
import com.example.aiqing.sharerobot.bean.ApplyJoinBean;
import com.example.aiqing.sharerobot.bean.BalanceB2CBean;
import com.example.aiqing.sharerobot.bean.BankCardNumBean;
import com.example.aiqing.sharerobot.bean.BankListBean;
import com.example.aiqing.sharerobot.bean.ChangeRentBean;
import com.example.aiqing.sharerobot.bean.ChangeRentReleaseBean;
import com.example.aiqing.sharerobot.bean.CommitBean;
import com.example.aiqing.sharerobot.bean.DaiDetailingBean;
import com.example.aiqing.sharerobot.bean.DaiInfoBean;
import com.example.aiqing.sharerobot.bean.DaiKucunBean;
import com.example.aiqing.sharerobot.bean.DaiOrderBean;
import com.example.aiqing.sharerobot.bean.DailiBean;
import com.example.aiqing.sharerobot.bean.DeleteAddressBean;
import com.example.aiqing.sharerobot.bean.DiaTouInitBean;
import com.example.aiqing.sharerobot.bean.DisAllLendBean;
import com.example.aiqing.sharerobot.bean.DisReturnBean;
import com.example.aiqing.sharerobot.bean.DisWaitLendBean;
import com.example.aiqing.sharerobot.bean.DistributorGetGoodsBean;
import com.example.aiqing.sharerobot.bean.DistributorMineBean;
import com.example.aiqing.sharerobot.bean.DoCashApplyBean;
import com.example.aiqing.sharerobot.bean.DoCashDetailBean;
import com.example.aiqing.sharerobot.bean.GetGoodsYuanBean;
import com.example.aiqing.sharerobot.bean.GetSystemTimeBean;
import com.example.aiqing.sharerobot.bean.GetYanzhengmaBean;
import com.example.aiqing.sharerobot.bean.HavaLeaseBean;
import com.example.aiqing.sharerobot.bean.InAndOutBean;
import com.example.aiqing.sharerobot.bean.InAndOutBeanDai;
import com.example.aiqing.sharerobot.bean.KucunBean;
import com.example.aiqing.sharerobot.bean.LeaseDetailBean;
import com.example.aiqing.sharerobot.bean.LeaseManagerDaiBean;
import com.example.aiqing.sharerobot.bean.MainBean;
import com.example.aiqing.sharerobot.bean.MyAddressBean;
import com.example.aiqing.sharerobot.bean.MyAibotBean;
import com.example.aiqing.sharerobot.bean.MyAibotOrderBean;
import com.example.aiqing.sharerobot.bean.NearbyShopBean;
import com.example.aiqing.sharerobot.bean.NoSendBean;
import com.example.aiqing.sharerobot.bean.NotUsedBean;
import com.example.aiqing.sharerobot.bean.OrderBean;
import com.example.aiqing.sharerobot.bean.OverRentBean;
import com.example.aiqing.sharerobot.bean.PersonalInfoBean;
import com.example.aiqing.sharerobot.bean.PlatformSendBean;
import com.example.aiqing.sharerobot.bean.PrivateKeyBean;
import com.example.aiqing.sharerobot.bean.ProblemBean;
import com.example.aiqing.sharerobot.bean.PutManagerBean;
import com.example.aiqing.sharerobot.bean.RentPayBean;
import com.example.aiqing.sharerobot.bean.ReturnAibotBean;
import com.example.aiqing.sharerobot.bean.SaveBankinfoBean;
import com.example.aiqing.sharerobot.bean.ScanDisSendBean;
import com.example.aiqing.sharerobot.bean.ScanRentBean;
import com.example.aiqing.sharerobot.bean.ScanReturnBean;
import com.example.aiqing.sharerobot.bean.ScanToufangBean;
import com.example.aiqing.sharerobot.bean.SelectShopBean;
import com.example.aiqing.sharerobot.bean.SendGoodsBean;
import com.example.aiqing.sharerobot.bean.ShopDataBean;
import com.example.aiqing.sharerobot.bean.ToLoginBean;
import com.example.aiqing.sharerobot.bean.TouDetailBean;
import com.example.aiqing.sharerobot.bean.TouInitRobotBean;
import com.example.aiqing.sharerobot.bean.TouOrderBean;
import com.example.aiqing.sharerobot.bean.UpDataNickName;
import com.example.aiqing.sharerobot.bean.UpDataSexBean;
import com.example.aiqing.sharerobot.bean.UpdataShopDataBean;
import com.example.aiqing.sharerobot.bean.UpdateAddressBean;
import com.example.aiqing.sharerobot.bean.UploadHeaderBean;
import com.example.aiqing.sharerobot.bean.UploadImaBean;
import com.example.aiqing.sharerobot.bean.UsersAddressBean;
import com.example.aiqing.sharerobot.bean.WeChatPayBean;
import com.example.aiqing.sharerobot.bean.YaoqingManBean;
import com.example.aiqing.sharerobot.bean.ZhifubaoB2CBean;
import com.example.aiqing.sharerobot.bean.advanceWxEBean;
import com.example.aiqing.sharerobot.bean.advanceYuEBean;
import com.example.aiqing.sharerobot.bean.advanceZfbBean;
import com.example.aiqing.sharerobot.bean.daiInitRobotBean;
import com.example.aiqing.sharerobot.bean.scanAgencyBean;

import retrofit.Call;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by aiqing on 2017/6/25.
 */

public interface ApiService {

    String baseUrl = "http://192.168.1.150:8083/";

    /**
     * 申请租页面 获取客户账户信息接口
     */
    @POST("http://120.132.117.157:8083/account/getAccountInfo.shtml")
    Call<ApplyBean> getApplyData(@Header("JSESSIONID") String JSESSIONID);

    /**
     * 商家信息页面
     */
    @POST("http://relay.aqcome.com/comm/getDistributorInfo.shtml")
    Call<MainBean> getMessage(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId);

    /**
     * 获取客户收货地址信息接口
     */
    @POST("http://120.132.117.157:8083/account/getCustAddInfo.shtml")
    Call<UsersAddressBean> getAddressData(@Header("JSESSIONID") String JSESSIONID, @Query("pageNum") String pageNum, @Query("pageSize ") String pageSize);

    /**
     * 首页接口
     */
    @POST("http://120.132.117.157:8083/comm/getAgentInfo.shtml")
    Call<AibotNumBean> getAibot(@Query("lat") String lat, @Query("lgt") String lgt, @Query("range") String range);

    /**
     * 获取客户收货保存接口
     */
    @POST("http://120.132.117.157:8083/account/saveCustAddInfo.shtml")
    Call<AddAddressBean> saveaddress(@Header("JSESSIONID") String JSESSIONID, @Query("name") String name, @Query("mobile") String mobile, @Query("province") String province, @Query("city") String city, @Query("district") String district, @Query("township") String township, @Query("street") String street, @Query("streetnumber") String streetnumber, @Query("fAddress") String fAddress, @Query("dAddress") String dAddress, @Query("isDefault") String isDefault, @Query("lgt") String lgt, @Query("lat") String lat, @Query("building") String building);

    /**
     * 修改用户昵称接口
     */
    @POST("http://120.132.117.157:8083/account/updateNickname.shtml")
    Call<AibotNumBean> changeUserNickName(@Query("JSESSIONID") String JSESSIONID, @Query("nickName") String nickName);

    /**
     * 修改用户昵称接口
     */
    @POST("http://120.132.117.157:8083/account/updateNickname.shtml")
    Call<AibotNumBean> getPersonInfo(@Query("custId") String custId);

    /**
     * 获取个人资料信息
     */
    @POST("http://120.132.117.157:8083/account/getCustInfo.shtml")
    Call<PersonalInfoBean> getPersonsInfo(@Header("JSESSIONID") String JSESSIONID);

    /**
     * 修改性别
     */
    @POST("http://120.132.117.157:8083/account/updateSex.shtml")
    Call<AibotNumBean> changeSex(@Query("JSESSIONID") String JSESSIONID, @Query("Sex") String Sex);

    /**
     * 获取手机验证码接口
     */
    @POST("http://120.132.117.157:8083/comm/sendPhoneCode.shtml")
    Call<GetYanzhengmaBean> getYanzhengma(@Query("mobile") String mobile, @Query("templateName") String templateName, @Query("unSendKey") String unSendKey);

    /**
     * 用户登录注册接口
     */
    @POST("http://120.132.117.157:8083/comm/doLoginNew.shtml")
    Call<ToLoginBean> login(@Header("JSESSIONID") String JSESSIONID, @Query("mobile") String mobile, @Query("yzCode") String yzCode, @Query("comeFrom") String comeFrom);

    /**
     * 投放商管理接口
     */
    @POST("http://120.132.117.157:8083/cust/getAccountRec.shtml")
    Call<PutManagerBean> PutManager(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId);

    /**
     * 租金支付接口
     */
    @POST("http://120.132.117.157:8083/cust/payRent.shtml")
    Call<RentPayBean> payZuJin(@Header("JSESSIONID") String JSESSIONID, @Query("pTypeId") String pTypeId);

    /**
     * 扫代理商码，绑定代理商投放商关系接口（投放商未注册版， 先注册再绑定）
     * @return //申请加盟
     */
    @POST("http://120.132.117.157:8083/account/scanCodeNew.shtml")
    Call<ApplyJoinBean> toJiameng(@Header("JSESSIONID") String JSESSIONID, @Query("agencyId") String agencyId, @Query("name") String name, @Query("mobile") String mobile, @Query("is24hrs") String is24hrs, @Query("openTime") String openTime, @Query("closedTime") String closedTime, @Query("isAllowed") String isAllowed, @Query("lgt") String lgt, @Query("lat") String lat, @Query("introduction") String introduction, @Query("address") String address);

    /**
     * 扫代理商码，绑定代理商投放商关系接口（投放商已注册版， 如果已注册，直接扫码绑定了）
     */
    @POST("http://120.132.117.157:8083/account/scanCode.shtml")
    Call<DailiBean> daili(@Query("JSESSIONID") String JSESSIONID, @Query("agencyId") String agencyId);


    /**
     * 投放商--库存管理接口
     */
    @POST("http://120.132.117.157:8083/distributor/distributorStock.shtml")
    Call<KucunBean> getKuncun(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);

    /**
     * 代理商管理
     * 代理商订单和库存管理
     */
    @POST("http://120.132.117.157:8083/agency/orderByApply.shtml")
    Call<AngentyBean> orderManager(@Header("JSESSIONID") String JSESSIONID, @Query("agencyId") String agencyId);

    /**
     * 投放商店铺资料设置（21-0）
     */
    @POST("http://120.132.117.157:8083/distributor/selectDistributor.shtml")
    Call<ShopDataBean> getShopData(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId);

    /**
     * 扫投放商码
     */
    @POST("http://120.132.117.157:8083/agency/isDistributor.shtml")
    Call<ScanToufangBean> ScanTou(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId);


    /**
     * 租赁管理—待租（图片22-3）
     */
    @POST("http://120.132.117.157:8083/product/selectProductwait.shtml")
    Call<LeaseManagerDaiBean> daizu(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId);

    /**
     * 租赁管理—已租
     */
    @POST("http://120.132.117.157:8083/product/selectProduct.shtml")
    Call<HavaLeaseBean> havelease(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId);

    /**
     * 租赁管理—订单
     */
    @POST("http://120.132.117.157:8083/product/selectOrder.shtml")
    Call<OrderBean> newOrder(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId);

    /**
     * 代理商头像和姓名（）邀请者信息读取
     */
    @POST("http://120.132.117.157:8083/agency/agencyInfo.shtml")
    Call<YaoqingManBean> yaoqinzhe(@Header("JSESSIONID") String JSESSIONID,@Query("agencyId") String agencyId);

//    /**
//     * 我要进货 上传图片
//     */
//    @POST("http://120.132.117.157:8083/image/uploadImageBase64.shtml")
//    Call<UpLoadPicBean> uploadpic(@Header("JSESSIONID") String JSESSIONID, @Query("file") String file);

    /**
     * 上传图片
     */
    @POST("https://shared.aqcome.com/image/uploadImageBase64.shtml")
    Call<UploadImaBean> uploadpic(@Header("JSESSIONID") String JSESSIONID, @Query("file") String file);

    /**
     * 我的地址  图片 101-2
     */
    @POST("http://120.132.117.157:8083/account/getCustAddInfo.shtml")
    Call<MyAddressBean> getMyAddress(@Header("JSESSIONID") String JSESSIONID, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);

    /**
     * 删除地址
     */
    @POST("http://120.132.117.157:8083/account/updateStatus.shtml")
    Call<DeleteAddressBean> deleteadd(@Header("JSESSIONID") String JSESSIONID, @Query("addressId") String addressId);


    /**
     * 修改用户地址 101-3
     */
    @POST("https://shared.aqcome.com/account/updateAddress.shtml")
    Call<UpdateAddressBean> updateadd(@Header("JSESSIONID") String JSESSIONID, @Query("addressId") String addressId, @Query("name") String name, @Query("mobile") String mobile, @Query("province") String province, @Query("city") String city, @Query("district") String district, @Query("township") String township, @Query("street") String street, @Query("streetnumber") String streetnumber, @Query("building") String building, @Query("isDefault") String isDefault, @Query("fAddress") String fAddress, @Query("dAddress") String dAddress, @Query("lgt") String lgt, @Query("lat") String lat);


    /**
     * 代理商订单管理（图片31-1）
     */
    @POST("http://120.132.117.157:8083/agency/arrangeOrderList.shtml")
    Call<DaiOrderBean> applysendgoods(@Header("JSESSIONID") String JSESSIONID, @Query("agencyId") String agencyId, @Query("doStatus") String doStatus, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);

    /**
     * 投放商进出货列表
     */
    @POST("http://120.132.117.157:8083/distributor/distributorByInOrOut.shtml")
    Call<InAndOutBean> inAndOutGoods(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);

    //代理商管理-库存
    @POST("http://120.132.117.157:8083/agency/agencyByApply.shtml")
    Call<DaiKucunBean> daiKucun(@Header("JSESSIONID") String JSESSIONID, @Query("agencyId") String agencyId, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);

    /**
     * 修改用户昵称接口（图片11）
     */
    @POST("http://120.132.117.157:8083/account/updateNickname.shtml")
    Call<UpDataNickName> upDataNickName(@Header("JSESSIONID") String JSESSIONID, @Query("nickName") String nickName);

    /**
     * 修改性别
     */
    @POST("http://120.132.117.157:8083/account/updateSex.shtml")
    Call<UpDataSexBean> upDataSex(@Header("JSESSIONID") String JSESSIONID, @Query("Sex") String Sex);


    /**
     * 代理商---订单管理--确认发货
     */
    @POST("http://120.132.117.157:8083/agency/agencyConfirmReceipt.shtml")
    Call<SendGoodsBean> sendGoods(@Header("JSESSIONID") String JSESSIONID, @Query("paId") String paId, @Query("agencyId") String agencyId);

    /**
     * 代理商头像和姓名（）
     */
    @POST("http://120.132.117.157:8083/agency/agencyInfo.shtml")
    Call<DaiInfoBean> getDaiInfo(@Header("JSESSIONID") String JSESSIONID, @Query("agencyId") String agencyId);


    /**
     * 未租用页面接口（图片50-3）
     */
    @POST("http://120.132.117.157:8083/robotOrder/notUsedList.shtml")
    Call<NotUsedBean> notUsedlist(@Header("JSESSIONID") String JSESSIONID, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);


    /**
     * 微信支付租金
     */
    @POST("http://120.132.117.157:8083/pay/depositBCAPPPay.shtml")
    Call<WeChatPayBean> wxPay(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId, @Query("pTypeId") String pTypeId,@Query("addressId") String addressId, @Query("receiveType") String receiveType, @Query("payMent") String payMent, @Query("unitFee") String unitFee, @Query("payZe") String payZe, @Query("zyNum") String zyNum, @Query("source") String source);


    /**
     * 投放商进出货详情
     */
    @POST("http://120.132.117.157:8083/distributor/distributorOrderDetails.shtml")
    Call<TouDetailBean> touDetail(@Header("JSESSIONID") String JSESSIONID, @Query("paId") String paId);

    /**
     * 代理商进出货列表（图片31-0）
     */
    @POST("http://120.132.117.157:8083/agency/agencyByInOrOut.shtml")
    Call<InAndOutBeanDai> getGoodsDai(@Header("JSESSIONID") String JSESSIONID, @Query("agencyId") String agencyId, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);

    /**
     * 代理商进出货详情
     */
    @POST("http://120.132.117.157:8083/agency/agencyOrderDetails.shtml")
    Call<DaiDetailingBean> daiDetail(@Header("JSESSIONID") String JSESSIONID, @Query("paId") String paId);

    /**
     * 订单租赁明细（投放商）
     */
    @POST("http://120.132.117.157:8083/product/rentMessage.shtml")
    Call<TouOrderBean> touOrder(@Header("JSESSIONID") String JSESSIONID, @Query("paId") String paId);

    /**
     *   投放商  已租  明细
     */
    @POST("http://120.132.117.157:8083/product/rentMessage.shtml")
    Call<LeaseDetailBean> leasedetail(@Header("JSESSIONID") String JSESSIONID, @Query("productId") String productId, @Query("distributorId") String distributorId);


    /**
     * 我的小宝
     */
    @POST("http://120.132.117.157:8083/payRent/orderInfo.shtml")
    Call<MyAibotBean> myRobot(@Header("JSESSIONID") String JSESSIONID, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);

    /**
     * 投放商申请进货（图25-4）
     * @param JSESSIONID
     * @param distributorId
     * @return
     */
//    @POST("https://ee/distributor/disributorPurchase.shtml")
//    Call<ApplyNowBean> applyNow(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId);


    /**
     * 小宝订单——订单管理（图片50-1）
     */
    @POST("http://120.132.117.157:8083/robotOrder/orderManage.shtml")
    Call<MyAibotOrderBean> myOrder(@Header("JSESSIONID") String JSESSIONID, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);

    /**
     *我的小宝未发货列表（图片50-2）
     */
    @POST("http://120.132.117.157:8083/robotOrder/notSendList.shtml")
    Call<NoSendBean> nosend(@Header("JSESSIONID") String JSESSIONID, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);


    //扫描代理商码
    @POST("http://120.132.117.157:8083/agency/scanAgency.shtml")
    Call<scanAgencyBean> scanAgency(@Header("JSESSIONID") String JSESSIONID, @Query("agencyId") String agencyId);

    //扫小宝机器码检验接口（租金支付前先扫码）
    @POST("http://120.132.117.157:8083/pay/scanCProdCode.shtml")
    Call<ScanRentBean> scanRentNum(@Header("JSESSIONID") String JSESSIONID, @Query("productId") String productId);

    //代理商初始化小宝
    @POST("http://120.132.117.157:8083/agency/addProduct.shtml")
    Call<daiInitRobotBean> daiInitRobot(@Header("JSESSIONID") String JSESSIONID, @Query("ptypeId") String ptypeId, @Query("productId") String productId);

    //投放商初始化小宝
    @POST("http://120.132.117.157:8083/distributor/addProduct.shtml")
    Call<TouInitRobotBean> touInitRobot(@Header("JSESSIONID") String JSESSIONID, @Query("ptypeId") String ptypeId, @Query("productId") String productId);

    //代理商和投放商初始化小宝
    @POST("http://120.132.117.157:8083/distributor/addProductRec.shtml")
    Call<DiaTouInitBean> daiAndTouInitRobot(@Header("JSESSIONID") String JSESSIONID, @Query("ptypeId") String ptypeId, @Query("productId") String productId);

    //转租发布保存修改（图片40-01）
    @POST("http://120.132.117.157:8083/custReletApply/updateOrSave.shtml")
    Call<ChangeRentReleaseBean> changeRent(@Header("JSESSIONID") String JSESSIONID,@Query("productId") String productId, @Query("ptypeId") String ptypeId, @Query("address") String address, @Query("mobile") String mobile,@Query("lgt") String lgt,@Query("lat") String lat,@Query("remark") String remark);


    //网点选择（图片15-2）
    @POST("http://120.132.117.157:8083/distributor/dotSelection.shtml")
    Call<SelectShopBean> selectshop(@Header("JSESSIONID") String JSESSIONID, @Query("productId") String productId, @Query("lgt") String lgt, @Query("lat") String lat, @Query("pageNum") String pageNum,@Query("pageSize") String pageSize);

    //归还小宝
    @POST("http://120.132.117.157:8083/returnMyRobot/return.shtml")
    Call<ReturnAibotBean> returnRobot(@Header("JSESSIONID") String JSESSIONID, @Query("productId") String productId, @Query("distributorId") String distributorId);


    //结束租赁
    @POST("http://120.132.117.157:8083/payRent/endRental.shtml")
    Call<OverRentBean> overRent(@Header("JSESSIONID") String JSESSIONID, @Query("productId") String productId);


    /**
     * 微信支付押金
     */
//    @POST("https://shared.aqcome.com/pay/depositCCAPPPay.shtml")
//    Call<WeChatPayBean> wxPay(@Header("JSESSIONID") String JSESSIONID, @Query("pTypeId") String pTypeId, @Query("addressId") String addressId, @Query("receiveType") String receiveType, @Query("payMent") String payMent, @Query("unitFee") String unitFee, @Query("payZe") String payZe, @Query("zyNum") String zyNum, @Query("c1CustId") String c1CustId,@Query("productId") String productId);


    //首页转租申请详情查看接口 图片111
    @POST("http://120.132.117.157:8083/custReletApply/custReletApplyInfo.shtml")
    Call<ChangeRentBean> chengerent(@Header("JSESSIONID") String JSESSIONID, @Query("carId") String carId);


    //投放商要货（进货25-3,4，5）
    @POST("http://120.132.117.157:8083/distributor/saveDistributorApply.shtml")
    Call<DistributorGetGoodsBean> applygetGoods(@Header("JSESSIONID") String JSESSIONID, @Query("agencyId") String agencyId,@Query("distributorId") String distributorId,@Query("applyNum") String applyNum,@Query("payType") String payType,@Query("ptypeId") String ptypeId,@Query("addressId") String addressId,@Query("voucherImg") String voucherImg);


    //投放商申请进货（图25-4）  进货源
    @POST("http://120.132.117.157:8083/distributor/disributorPurchase.shtml")
    Call<GetGoodsYuanBean> getGoods(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId);


    /**
     * 上传图片
     */
    @POST("https://shared.aqcome.com/image/addImageBase64.shtml")
    Call<UploadHeaderBean> uploadheader(@Header("JSESSIONID") String JSESSIONID, @Query("file") String file);

    /**
     * 支付宝B2C押金支付
     */
    @POST("http://relay.aqcome.com/pay/depositBCAPPPay.shtml")
    Call<ZhifubaoB2CBean> zhifubaoPay(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId, @Query("pTypeId") String pTypeId, @Query("addressId") String addressId, @Query("receiveType") String receiveType, @Query("payMent") String payMent, @Query("unitFee") String unitFee, @Query("payZe") String payZe, @Query("zyNum") String zyNum, @Query("source") String source, @Query("creditkey") String creditkey);


    /**
     * 98、投放商出租-全部  新
     */
    @POST("http://120.132.117.157:8083/distributor/rentAll.shtml")
    Call<DisAllLendBean> getAll(@Header("JSESSIONID") String JSESSIONID, @Query("dealStatus") String dealStatus, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);


    /**
     * 98、投放商出租-待处理  新
     */
    @POST("http://120.132.117.157:8083/distributor/rentAll.shtml")
    Call<DisWaitLendBean> getWait(@Header("JSESSIONID") String JSESSIONID, @Query("dealStatus") String dealStatus, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);

    /**
     * 99、投放商申请平台发货
     */
    @POST("http://120.132.117.157:8083/distributor/appFormDelivery.shtml")
    Call<PlatformSendBean> platformSend(@Header("JSESSIONID") String JSESSIONID, @Query("paIds") String paIds, @Query("appNum") String appNum, @Query("distributorId") String distributorId, @Query("ptypeId") String ptypeId);

    /**
     * 101、投放商管理-我的
     */
    @POST("http://120.132.117.157:8083/distributor/myDistributorInfo.shtml")
    Call<DistributorMineBean> disMy(@Header("JSESSIONID") String JSESSIONID);

    /**
     * 100、投放商预发量支付宝充值接口（APP和H5支付整合版）
     */
    @POST("http://120.132.117.157:8083/distributor/advanceApply.shtml")
    Call<advanceZfbBean> advanceZfb(@Header("JSESSIONID") String JSESSIONID, @Query("distributorid") String distributorid, @Query("ptypeid") String ptypeid, @Query("paytype") String paytype, @Query("source") String source, @Query("num") String num, @Query("voucherimg") String voucherimg);

    /**
     * 100、投放商预发量余额充值接口（APP和H5支付整合版）
     */
    @POST("http://120.132.117.157:8083/distributor/advanceApply.shtml")
    Call<advanceYuEBean> advanceYuE(@Header("JSESSIONID") String JSESSIONID, @Query("distributorid") String distributorid, @Query("ptypeid") String ptypeid, @Query("paytype") String paytype, @Query("source") String source, @Query("num") String num, @Query("voucherimg") String voucherimg);

    /**
     * 100、投放商预发量微信充值接口（APP和H5支付整合版）
     */
    @POST("http://120.132.117.157:8083/distributor/advanceApply.shtml")
    Call<advanceWxEBean> advanceWx(@Header("JSESSIONID") String JSESSIONID, @Query("distributorid") String distributorid, @Query("ptypeid") String ptypeid, @Query("paytype") String paytype, @Query("source") String source, @Query("num") String num, @Query("voucherimg") String voucherimg);

    /**
     * 103、投放商归还列表接口
     */
    @POST("http://120.132.117.157:8083/distributor/returnToDistributor.shtml")
    Call<DisReturnBean> disReturn(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);

    /**
     * 92.产品维修报价列表
     */
    @POST("http://120.132.117.157:8083/product/forFeitList.shtml")
    Call<ProblemBean> problem(@Header("JSESSIONID") String JSESSIONID, @Query("productId") String productId);

    /**
     * 95、投放商确认收货（C端还货的收货）
     */
    @POST("http://120.132.117.157:8083/distributor/receiptB2C.shtml")
    Call<CommitBean> commit(@Header("JSESSIONID") String JSESSIONID, @Query("productId") String productId, @Query("distributorId") String distributorId, @Query("feitid") String feitid);

    /**
     * 93、投放商扫码收货（C端还货的扫码）
     */
    @POST("http://120.132.117.157:8083/distributor/scanReceipt.shtml")
    Call<ScanReturnBean> scanReturn(@Header("JSESSIONID") String JSESSIONID, @Query("productId") String productId, @Query("distributorId") String distributorId);


    /**
     * 93、投放商扫码确认发货（C端还货的扫码）
     */
    @POST("http://120.132.117.157:8083/distributor/sureDistributorSend.shtml")
    Call<ScanDisSendBean> scanSend(@Header("JSESSIONID") String JSESSIONID, @Query("paId") String paId, @Query("product_Id") String product_Id, @Query("distributorId") String distributorId);


    /**
     * 代理商管理2.0（下级投放商）接口
     */
    @POST("http://120.132.117.157:8083/agency/selectAgencyJunior.shtml")
    Call<AgencyDisBean> agenceNext(@Header("JSESSIONID") String JSESSIONID, @Query("agencyId") String agencyId, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);


    /**
     * 109、代理商管理2.0（收益流水）接口
     */
    @POST("http://120.132.117.157:8083/agency/selectAgencyAccount.shtml")
    Call<AgencyIncomeBaen> agenceIncome(@Header("JSESSIONID") String JSESSIONID, @Query("agencyId") String agencyId, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);


    /**
     * 110、获取支付宝应用 私钥（APP支付宝认证使用）
     */
    @POST("http://120.132.117.157:8083/pay/getPrkey.shtml")
    Call<PrivateKeyBean> getPrivateKey(@Header("JSESSIONID") String JSESSIONID);


    /**
     * 112、获取账户信息
     */
    @POST("http://120.132.117.157:8083/account/getAccInfo.shtml")
    Call<AccountInfoBean> getAccountinfo(@Header("JSESSIONID") String JSESSIONID);

    /**
     * 114、银行卡列表
     */
    @POST("http://120.132.117.157:8083/bank/bankList.shtml")
    Call<BankListBean> getBanklist(@Header("JSESSIONID") String JSESSIONID);

    /**
     * 117、判断银行卡所处银行（POST）
     */
    @POST("http://120.132.117.157:8083/bank/bankType.shtml")
    Call<BankCardNumBean> banknum(@Header("JSESSIONID") String JSESSIONID, @Query("cardNo") String cardNo);


    /**
     * 37、修改投放商店铺资料（图片21-0）
     */
    @POST("http://120.132.117.157:8083/distributor/saveDistributorId.shtml")
    Call<UpdataShopDataBean> updatashopdata(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId, @Query("name") String name, @Query("address") String address, @Query("lgt") String lgt, @Query("lat") String lat, @Query("building") String building, @Query("contact1") String contact1, @Query("isStop") String isStop, @Query("isAllowed") String isAllowed, @Query("openTime2") String openTime2, @Query("closedTime2") String closedTime2);


    /**
     * 115、新增银行卡
     */
    @POST("http://120.132.117.157:8083/bank/saveBankCard.shtml")
    Call<SaveBankinfoBean> savebankinfo(@Header("JSESSIONID") String JSESSIONID, @Query("cardNo") String cardNo, @Query("bindingMobile") String bindingMobile, @Query("accountName") String accountName, @Query("bankName") String bankName, @Query("yzCode") String yzCode);


    /**
     * 116、提现保存接口（POST）
     */
    @POST("http://120.132.117.157:8083/pay/doCashApply.shtml")
    Call<DoCashApplyBean> doCashApply(@Header("JSESSIONID") String JSESSIONID, @Query("amount") String amount, @Query("cardId") String cardId);



    /**
     * 119、提现流水记录
     */
    @POST("http://120.132.117.157:8083/cust/getwithdrawRec.shtml")
    Call<DoCashDetailBean> doCashDetail(@Header("JSESSIONID") String JSESSIONID, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);


    /**
     * 118、字典表通用接口
     */
    @POST("http://120.132.117.157:8083/comm/dictionaryGeneric.shtml")
    Call<GetSystemTimeBean> getTime(@Header("JSESSIONID") String JSESSIONID, @Query("code") String code);



    /**
     * 113、LBS搜索功能
     */
    @POST("http://120.132.117.157:8083/comm/lbsSearch.shtml")
    Call<NearbyShopBean> nearbyData(@Query("lgt") String lgt, @Query("lat") String lat, @Query("range") String range, @Query("pageNum") String pageNum, @Query("pageSize") String pageSize);



    /**
     * 余额支付B2C押金支付
     */
    @POST("http://relay.aqcome.com/pay/depositBCAPPPay.shtml")
    Call<BalanceB2CBean> balancePay(@Header("JSESSIONID") String JSESSIONID, @Query("distributorId") String distributorId, @Query("pTypeId") String pTypeId, @Query("addressId") String addressId, @Query("receiveType") String receiveType, @Query("payMent") String payMent, @Query("unitFee") String unitFee, @Query("payZe") String payZe, @Query("zyNum") String zyNum, @Query("source") String source, @Query("creditkey") String creditkey);


}

