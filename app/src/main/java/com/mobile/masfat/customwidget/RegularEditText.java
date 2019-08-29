package com.mobile.masfat.customwidget;

import android.content.Context;
import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

public class RegularEditText extends AppCompatEditText {

    public RegularEditText(final Context context) {
        super(context);
        setCustomFont(context);
    }

    public RegularEditText(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context);
    }

    public RegularEditText(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(context);
    }

    public boolean setCustomFont(Context ctx) {
        Typeface typeface = null;
        try {
            typeface = Typeface.createFromAsset(ctx.getAssets(),"font/regular.ttf");
        } catch (Exception e) {
            Log.e("RegularEditText", "Unable to load typeface: "+e.getMessage());
            return false;
        }
        setTypeface(typeface);
        return true;
    }
}
