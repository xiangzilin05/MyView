package com.example.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/7/22.
 */
public class MyTopBar extends RelativeLayout {

    private LayoutParams mRightParams;
    private LayoutParams mLeftParams;
    private LayoutParams mTitlepParams;
    private Button mLeftButton;
    private Button mRightButton;
    private TextView mTitleView;
    private Context context;
    private AttributeSet attrs;

    private String mtitle;
    private float mtitleTextSize;
    private int mtitleTextColor;
    private String mleftText;
    private int leftTextColor;
    private Drawable leftBackground;
    private String rightText;
    private int rightTextColor;
    private Drawable rightBackground;

    public MyTopBar(Context context) {
        super(context);
        this.context = context;
    }

    public MyTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        leftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
        leftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
        mleftText = ta.getString(R.styleable.TopBar_leftText);
        rightTextColor = ta.getColor(
                R.styleable.TopBar_rightTextColor, 0);
        rightBackground = ta.getDrawable(
                R.styleable.TopBar_rightBackground);
        rightText = ta.getString(R.styleable.TopBar_rightText);

        mtitleTextSize = ta.getDimension(
                R.styleable.TopBar_titleTextSize, 10);
        mtitleTextColor = ta.getColor(
                R.styleable.TopBar_titleTextColor, 0);
        mtitle = ta.getString(R.styleable.TopBar_title);

        ta.recycle();

        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitleView = new TextView(context);

        mLeftButton.setTextColor(leftTextColor);
        mLeftButton.setBackground(leftBackground);
        mLeftButton.setText(mleftText);

        mRightButton.setTextColor(rightTextColor);
        mRightButton.setBackground(rightBackground);
        mRightButton.setText(rightText);

        mTitleView.setText(mtitle);
        mTitleView.setTextColor(mtitleTextColor);
        mTitleView.setTextSize(mtitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);

        mLeftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(ALIGN_PARENT_LEFT, TRUE);
        addView(mLeftButton, mLeftParams);

        mRightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mRightParams.addRule(ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButton, mRightParams);

        mTitlepParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mTitlepParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleView, mTitlepParams);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


}
