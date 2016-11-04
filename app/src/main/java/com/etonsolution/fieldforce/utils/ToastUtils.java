package com.etonsolution.fieldforce.utils;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by BawejaTushar on 11/3/2016.
 */

public class ToastUtils {
    public static void showToast(Activity activity, String message){
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
    }
}
