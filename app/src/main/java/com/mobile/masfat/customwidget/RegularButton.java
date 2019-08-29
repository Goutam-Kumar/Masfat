package com.mobile.masfat.customwidget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

public class RegularButton extends AppCompatButton {
    private static Typeface mTypeface;

    public RegularButton(final Context context) {
        this(context, null);
    }

    public RegularButton(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RegularButton(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);

        if (mTypeface == null) {
            mTypeface = Typeface.createFromAsset(context.getAssets(), "font/regular.ttf");
        }
        setTypeface(mTypeface);
    }
}
