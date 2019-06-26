package com.example.basicapprequire.customfontforviews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class HelveticaEditText extends AppCompatEditText {
    public HelveticaEditText(Context context) {
        super(context);
        setFaceType();
    }

    public HelveticaEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFaceType();
    }

    public HelveticaEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFaceType();
    }

    private void setFaceType() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "HelveticaNeue-LightExt.otf");
        setTypeface(typeface);
    }
}
