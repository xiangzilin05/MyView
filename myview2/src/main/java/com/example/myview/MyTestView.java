package com.example.myview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/7/22.
 */
public class MyTestView extends TextView {

    Paint mPaint1;
    Paint mpaint2;
    Paint mpaint;

    int mViewWidth;
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;
    private int mTranslate;

    public MyTestView(Context context) {
        this(context, null, 0);
    }

    public MyTestView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);
        mpaint2 = new Paint();
        mpaint2.setColor(Color.YELLOW);
        mpaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0){
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0){
                mpaint = getPaint();
                mLinearGradient = new LinearGradient( 0,
                                    0,
                                    mViewWidth,
                                    0,
                                    new int[]{
                                            Color.BLUE, 0xffffffff,
                                            Color.BLUE},
                                    null,
                        Shader.TileMode.CLAMP);
                mpaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint1);
//        canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, mpaint2);
//        canvas.save();
//        //canvas.translate(10, 0);
//        super.onDraw(canvas);
//        canvas.restore();
//    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mGradientMatrix != null){
            mTranslate += mViewWidth / 5;
            if (mTranslate > 2 * mViewWidth){
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }
    }
}














