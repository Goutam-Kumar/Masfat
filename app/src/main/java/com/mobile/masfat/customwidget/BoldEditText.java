package com.mobile.masfat.customwidget;

import android.content.Context;
import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatEditText;

import android.util.AttributeSet;
import android.util.Log;

public class BoldEditText extends AppCompatEditText {
    private static Typeface mTypeface;

    public BoldEditText(final Context context) {
        super(context);
        setCustomFont(context);
    }

    public BoldEditText(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context);
    }

    public BoldEditText(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);

        if (mTypeface == null) {
            mTypeface = Typeface.createFromAsset(context.getAssets(), "font/bold.ttf");
        }
        setTypeface(mTypeface);
    }

    public boolean setCustomFont(Context ctx) {
        Typeface typeface = null;
        try {
            typeface = Typeface.createFromAsset(ctx.getAssets(),"font/bold.ttf");
        } catch (Exception e) {
            Log.e("BoldEditText", "Unable to load typeface: "+e.getMessage());
            return false;
        }
        setTypeface(typeface);
        return true;
    }
}
