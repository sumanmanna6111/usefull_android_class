package com.suman.trucksharing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class ImageBase64 {
    public static String encode(Bitmap imgBitmap){
        // Encode Image Bitmap to base64
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        imgBitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] bytesOfImage = byteArrayOutputStream.toByteArray();
        return android.util.Base64.encodeToString(bytesOfImage, Base64.DEFAULT);
    }

    private String encode(Context context , Uri filepath)
    {
        //encode image to base64 via filepath
        InputStream inputStream = null;
        try {
            inputStream= context.getContentResolver().openInputStream(filepath);
        }catch (Exception e){
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] bytesofimage = byteArrayOutputStream.toByteArray();
        return android.util.Base64.encodeToString(bytesofimage, Base64.DEFAULT);
    }

    public static Bitmap decode(String encodedImg){
        // Decode base64 to image bitmap
        byte[] decodedString = Base64.decode(encodedImg, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }
}
