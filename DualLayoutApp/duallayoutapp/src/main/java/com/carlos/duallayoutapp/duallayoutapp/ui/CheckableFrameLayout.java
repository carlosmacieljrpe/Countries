package com.carlos.duallayoutapp.duallayoutapp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.FrameLayout;

/**
 * Created by Carlos Jr on 08/06/2014.
 */
public class CheckableFrameLayout extends FrameLayout implements Checkable {

    private boolean mChecked;

    public CheckableFrameLayout(Context context) {
        super(context);
    }

    public CheckableFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setChecked(boolean checked) {
        mChecked = checked;

        setBackgroundColor(checked ? 0xff0000a0 : 0xff000000);
    }

    public boolean isChecked() {
        return mChecked;
    }

    public void toggle() {
        setChecked(!mChecked);
    }
}
