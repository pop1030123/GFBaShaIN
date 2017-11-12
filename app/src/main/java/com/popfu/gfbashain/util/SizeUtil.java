package com.popfu.gfbashain.util;

import android.content.Context;

import com.popfu.gfbashain.App;

/**
 * Created by pengfu on 12/11/2017.
 */

public final class SizeUtil {


    public static int dp2px(float value, Context context) {
        final float scale = context.getResources().getDisplayMetrics().densityDpi;
        return (int) (value * (scale / 160) + 0.5f);
    }


    public static int dp2px(float value) {
        final float scale = App.getInstance().getResources().getDisplayMetrics().densityDpi;
        return (int) (value * (scale / 160) + 0.5f);
    }
}
