package com.jbm.vehicletracking.util

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

object WaterMark {

         fun mark(src: Bitmap, watermark: String): Bitmap {
            val w = src.width
            val h = src.height
            val result = Bitmap.createBitmap(w, h, src.config)
            val canvas = Canvas(result)
            canvas.drawBitmap(src, 0f, 0f, null)
            val paint = Paint()
            paint.color = Color.RED
            paint.textSize = 10f
            paint.isAntiAlias = true
            paint.isUnderlineText = true
            canvas.drawText(watermark, 20f, 25f, paint)
            return result
    }


    /*
    *   public static Bitmap mark(Bitmap src, String watermark, Point location, Color color, int size) {
        int w = src.getWidth();
        int h = src.getHeight();
        Bitmap result = Bitmap.createBitmap(w, h, src.getConfig());

        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(src, 0, 0, null);

        Paint paint = new Paint();
        paint.setColor(color);
        paint.setTextSize(size);
        paint.setAntiAlias(true);
        paint.setUnderlineText(underline);
        canvas.drawText(watermark, location.x, location.y, paint);
        return result;
    }
    *
    * public static Bitmap mark(Bitmap src, String watermark){
        int w = src.getWidth();
        int h = src.getHeight();
        Bitmap result = Bitmap.createBitmap(w, h, src.getConfig());
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(src, 0f, 0f, null);
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setTextSize( 10f);
        paint.setAntiAlias(true);
        canvas.drawText(watermark, 20f, 25f, paint);
        return result;
    }
    * */
}