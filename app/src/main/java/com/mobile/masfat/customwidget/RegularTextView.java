package com.mobile.masfat.customwidget;

import android.content.Context;
import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatTextView;
import android.util.AttributeSet;

public class RegularTextView extends AppCompatTextView {
    private static Typeface mTypeface;

    public RegularTextView(final Context context) {
        this(context, null);
    }

    public RegularTextView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RegularTextView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);

        if (mTypeface == null) {
            mTypeface = Typeface.createFromAsset(context.getAssets(), "font/regular.ttf");
        }
        setTypeface(mTypeface);
    }
}
