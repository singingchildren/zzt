package com.example.oneweek.weight;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.oneweek.R;

public class MyView extends LinearLayout {


    private final int widthPixels;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //获取屏幕的宽度
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        widthPixels = metrics.widthPixels;
        setOrientation(VERTICAL);
    }
    //加载数据
    public void setData(String[] data){
        LinearLayout linearLayout = getLin();
        for (int i = 0; i < data.length; i++) {
            String tmp = data[i];
            //每一个view的宽度
            int numWidth = 0;
            //每一行子view的个数
            int childCount = linearLayout.getChildCount();
            for (int j = 0; j < childCount; j++) {
                TextView tv = (TextView) linearLayout.getChildAt(j);
                //为每一行设置边距
                LayoutParams params = (LayoutParams) tv.getLayoutParams();
                params.topMargin = 5;
                params.leftMargin = 15;
                int leftMargin = params.leftMargin;
                linearLayout.setLayoutParams(params);
                linearLayout.measure(getMeasuredWidth(),getMeasuredHeight());
                //view的总宽 = 字体的宽度+左边距+左右内边距
                numWidth += tv.getMeasuredWidth()+leftMargin+tv.getPaddingLeft()+tv.getPaddingRight();
            }
            TextView dataText = getText();
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            params.topMargin = 5;
            params.leftMargin = 10;
            linearLayout.setLayoutParams(params);
            dataText.setText(tmp);
            linearLayout.measure(getMeasuredWidth(),getMeasuredHeight());
            int dataTextWidth = dataText.getMeasuredWidth()+dataText.getPaddingRight()+dataText.getPaddingLeft();
            //屏幕宽度和子view的宽度作比较
            if(widthPixels>=dataTextWidth+numWidth){
                linearLayout.addView(dataText);
            }else{
                //换行  继续加载
                linearLayout = getLin();
                linearLayout.addView(dataText);
            }
        }

    }

    private TextView getText() {
        TextView textView = new TextView(getContext());
        textView.setTextSize(15);
        //为TextView设置样式
        textView.setBackgroundResource(R.drawable.shape);
        return textView;
    }


    private LinearLayout getLin() {

        LinearLayout linearLayout = new LinearLayout(getContext());
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(params);
        //linearLayout.measure(getMeasuredWidth(),getMeasuredHeight());
        this.addView(linearLayout);
        return linearLayout;
    }
}
