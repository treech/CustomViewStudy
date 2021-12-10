package com.treech.custom.viewstudy;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;

public class MatrixApiTestActivity extends Activity {

    private static final String TAG = "MatrixApiTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 计算结果依然放置pts中
         */
        //初始数据为四个点 (0, 0) (100, 0) (100, 100) (0,100)
        float[] pts = new float[]{0, 0, 100, 0, 100, 100, 0, 100};
        //构造一个Matrix，并使其x轴坐标缩放0.5 y轴坐标缩放0.5
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f);
        //输出原有的pts值
        Log.d(TAG, "before:" + Arrays.toString(pts));
        //调用mapPoints方法计算，即将Matrix的值映射至pts中
        matrix.mapPoints(pts);
        //属于计算后的pts值
        Log.d(TAG, "after:" + Arrays.toString(pts));

        /**
         * 原始数据需要保留，用此方法
         */
        float[] src = new float[]{0, 0, 80, 100, 400, 300};
        float[] dst = new float[]{0, 0, 0, 0, 0, 0};
        Matrix matrix2 = new Matrix();
        matrix2.setScale(0.5f, 1f);
        Log.d(TAG, "before:\n" + "src:" + Arrays.toString(src) + "  dst:" + Arrays.toString(dst));
        matrix2.mapPoints(dst, src);
        Log.d(TAG, "after:\n" + "src:" + Arrays.toString(src) + "  dst:" + Arrays.toString(dst));

        /**
         * 将第二个第三个计算后存储在dst最初始位置
         */
        float[] src2 = new float[]{0, 0, 80, 100, 400, 300};
        float[] dst2 = new float[6];
        Matrix matrix3 = new Matrix();
        matrix3.setScale(0.5f, 1f);
        Log.d(TAG, "before:\n" + "src:" + Arrays.toString(src2) + "  dst:" + Arrays.toString(dst2));
        matrix3.mapPoints(dst2, 0, src2, 2, 2);
        Log.d(TAG, "before:\n" + "src:" + Arrays.toString(src2) + "  dst:" + Arrays.toString(dst2));

        /**
         * 返回值是boolean值，表示矩阵经过变换后是否依然为矩阵（这里使用了斜切，故返回值是false）
         */
        RectF rectF = new RectF(400, 400, 1000, 800);
        Matrix matrix4 = new Matrix();
        matrix4.setScale(0.5f, 1f);
        matrix4.postSkew(1, 0);
        Log.d(TAG, "before:mapRect:" + rectF.toString());
        boolean result = matrix4.mapRect(rectF);
        Log.d(TAG, "after:mapRect:" + rectF.toString());
        Log.d(TAG, "result:" + result);
    }

}
