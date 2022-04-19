package com.treech.custom.viewstudy;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;

/**
 * 参考blog
 * https://blog.csdn.net/u012440207/article/details/88255881
 * https://blog.csdn.net/sinat_31057219/article/details/82656796
 */
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
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }


    private void test1(){
        Log.e("matrix", "=======================单位矩阵===========================");
        Matrix matrix = new Matrix();
        Log.e("matrix", "是否单位矩阵========" + matrix.isIdentity());//true
        matrix.postTranslate(200, 0);
        Log.e("matrix", "是否单位矩阵========" + matrix.isIdentity());//false
    }

    private void test2(){
        Log.e("matrix", "=======================平移===========================");
        Matrix matrix = new Matrix();
        Matrix invert = new Matrix();
        matrix.setTranslate(200, 500);

        Log.e("matrix", "before - matrix ===" + matrix.toShortString());
        //[1.0, 0.0, 200.0][0.0, 1.0, 500.0][0.0, 0.0, 1.0]
        matrix.invert(invert);
        Log.e("matrix", "after  - invert ===" + invert.toShortString());
        //[1.0, 0.0, -200.0][0.0, 1.0, -500.0][0.0, 0.0, 1.0]
    }

    private void test3(){
        Log.e("matrix", "=======================缩放===========================");
        Matrix matrix = new Matrix();
        Matrix invert = new Matrix();
        matrix.setScale(2, 2);

        Log.e("matrix", "before - matrix ===" + matrix.toShortString());
        //[2.0, 0.0, 0.0][0.0, 2.0, 0.0][0.0, 0.0, 1.0]
        matrix.invert(invert);
        Log.e("matrix", "after  - invert ===" + invert.toShortString());
        //[0.5, 0.0, -0.0][0.0, 0.5, -0.0][0.0, 0.0, 1.0]
    }

    private void test4(){
        Log.e("matrix", "=========================斜切=========================");
        Matrix matrix = new Matrix();
        Matrix invert = new Matrix();
        matrix.setSkew(20, 20);

        Log.e("matrix", "before - matrix ===" + matrix.toShortString());
        //[1.0, 20.0, 0.0][20.0, 1.0, 0.0][0.0, 0.0, 1.0]
        matrix.invert(invert);
        Log.e("matrix", "after  - invert ===" + invert.toShortString());
        //[-0.0025062656, 0.050125312, -0.0][0.050125312, -0.0025062656, -0.0][0.0, 0.0, 1.0]
    }

    private void test5(){
        Log.e("matrix", "=======================旋转90°===========================");
        Matrix matrix = new Matrix();
        Matrix invert = new Matrix();
        matrix.setRotate(90);

        Log.e("matrix", "before - matrix ===" + matrix.toShortString());
        //[0.0, -1.0, 0.0][1.0, 0.0, 0.0][0.0, 0.0, 1.0]
        matrix.invert(invert);
        Log.e("matrix", "after  - invert ===" + invert.toShortString());
        //[0.0, 1.0, -0.0][-1.0, 0.0, 0.0][0.0, 0.0, 1.0]
    }

    private void test6(){
        Log.e("matrix", "=======================旋转-90°===========================");
        Matrix matrix = new Matrix();
        Matrix invert = new Matrix();
        matrix.setRotate(-90);

        Log.e("matrix", "before - matrix ===" + matrix.toShortString());
        //[0.0, 1.0, 0.0][-1.0, 0.0, 0.0][0.0, 0.0, 1.0]
        matrix.invert(invert);
        Log.e("matrix", "after  - invert ===" + invert.toShortString());
        //[0.0, -1.0, 0.0][1.0, 0.0, -0.0][0.0, 0.0, 1.0]
    }

}
