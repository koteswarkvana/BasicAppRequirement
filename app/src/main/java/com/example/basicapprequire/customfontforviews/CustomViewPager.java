package com.example.basicapprequire.customfontforviews;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomViewPager extends ViewPager {
    public static boolean swipe;
    public static String TAG = CustomViewPager.class.getName();


    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        //return (this.swipe) ? super.onInterceptTouchEvent(arg0) : false;
        //if(this.swipe)
        //((MainActivity)getContext()).toggleMessaging();
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return swipe ? super.onTouchEvent(event) : false;
        //if(this.swipe)
        //((MainActivity)getContext()).toggleMessaging();
        return false;
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, false);
    }
}
