package com.example.aiqing.sharerobot.utils;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.Hashtable;

/**
 * Created by aiqing on 2017/6/28.
 *  content   内容
 *  widthPix  图片宽度
 *  heightPix 图片高度
 *  logoBm    二维码中心的Logo图标（可以为null）
 *  filePath  用于存储二维码图片的文件路径
 * @return 生成二维码及保存文件是否成功

 * 二维码生成工具类
 */

public class QRCodeUtil {


    private static int IMAGE_HALFWIDTH = 50;

          /**
     * 生成二维码，默认大小为500*500
     *
     * @param text 需要生成二维码的文字、网址等
     * @return bitmap
     */
        public static Bitmap createQRCode(String text) {
               return createQRCode(text, 500);
          }


    public static Bitmap createQRCode(String text, int size) {
                try {
                        Hashtable<EncodeHintType, String> hints = new Hashtable<>();
                        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
                        BitMatrix bitMatrix = new QRCodeWriter().encode(text,
                                        BarcodeFormat.QR_CODE, size, size, hints);
                       int[] pixels = new int[size * size];
                       for (int y = 0; y < size; y++) {
                               for (int x = 0; x < size; x++) {
                                       if (bitMatrix.get(x, y)) {
                                               pixels[y * size + x] = 0xff000000;
                                          } else {
                                               pixels[y * size + x] = 0xffffffff;
                                        }
                                  }
                            }
                       Bitmap bitmap = Bitmap.createBitmap(size, size,
                                      Bitmap.Config.ARGB_8888);
                       bitmap.setPixels(pixels, 0, size, 0, 0, size, size);
                       return bitmap;
                  } catch (WriterException e) {
                      e.printStackTrace();
                      return null;
                   }
           }

}
