/**
 * Project Name:Android_Car_Example
 * File Name:Utils.java
 * Package Name:com.amap.api.car.example
 * Date:2015年4月7日下午3:43:05
 */

package com.example.aiqing.sharerobot.lib;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.example.aiqing.sharerobot.R;

import java.util.ArrayList;


/**
 * ClassName:Utils <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2015年4月7日 下午3:43:05 <br/>  
 * @author yiyi.qi
 * @version
 * @since JDK 1.6
 * @see
 */
public class Utils {

    private static ArrayList<MarkerOptions> markers = new ArrayList<>();

    /**
     * 添加模拟测试的车的点
     */
    public static void addEmulateData(final AMap amap, final LatLng center) {
//        if (markers.size() == 0) {
//            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory
//                    .fromResource(R.mipmap.shop);
//
//            for (int i = 0; i < 20; i++) {
//                double latitudeDelt;
//                double longtitudeDelt;
//                if(i%2==0) {
//                     latitudeDelt = (Math.random() - 0.5) * 0.1;
//                     longtitudeDelt = (Math.random() - 0.5) * 0.1;
//                }else
//                {
//                     latitudeDelt = (Math.random() - 0.5) * 0.01;
//                     longtitudeDelt = (Math.random() - 0.5) * 0.01;
//                }
//                MarkerOptions markerOptions = new MarkerOptions();
////                markerOptions.setFlat(true);
////                markerOptions.anchor(0.5f, 0.5f);
//                markerOptions.icon(bitmapDescriptor);
//
//                markerOptions.position(new LatLng(center.latitude + latitudeDelt, center.longitude + longtitudeDelt));
//                Marker marker = amap.addMarker(markerOptions);
//                markers.add(marker);
//            }
//        } else {
//            for (Marker marker : markers) {
//                double latitudeDelt = (Math.random() - 0.5) * 0.1;
//                double longtitudeDelt = (Math.random() - 0.5) * 0.1;
//                marker.setPosition(new LatLng(center.latitude + latitudeDelt, center.longitude + longtitudeDelt));
//
//            }
//        }
        final BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory
                    .fromResource(R.mipmap.shop);
//        Retrofit builder = new Retrofit.Builder()
//                .baseUrl("http://192.168.1.56:8083/comm/getAgentInfo.shtml")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        ApiService apiService = builder.create(ApiService.class);
//        Call<AibotNumBean> call = apiService.getAibot("30.3268900000","120.1751500000","10");
//        call.enqueue(new Callback<AibotNumBean>() {
//            @Override
//            public void onResponse(Response<AibotNumBean> response, Retrofit retrofit) {
////                if (response.body().getObj().size() > 0) {
////                    for (int i = 0; i < response.body().getObj().size(); i++) {
////                        AibotNumBean.ObjBean robot = response.body().getObj().get(i);
////                        MarkerOptions markerOptions = new MarkerOptions();
////                        markerOptions.icon(bitmapDescriptor);
////                        markerOptions.visible(true);
////                        markerOptions.position(new LatLng(Double.valueOf(robot.getLat()), Double.valueOf(robot.getLgt())));
////                Marker marker = amap.addMarker(markerOptions);
////                        markers.add(markerOptions);
////                    }
////                    amap.addMarkers(markers, true);
////                }else {
////
////                }
//                response.body().getMdList().get(0);
//
//            }
//            @Override
//            public void onFailure(Throwable t) {
//
//                Log.e("失败", "失败" + t.getMessage());
//            }
//        });
    }


    /**
     * 移除marker
     */
    public static void removeMarkers() {
        for (MarkerOptions marker : markers) {
//            marker.remove();
//            marker.destroy();
        }
        markers.clear();
    }

}
  
