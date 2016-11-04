package com.etonsolution.fieldforce.utils;

import android.support.annotation.Nullable;

/**
 * Created by BawejaTushar on 11/3/2016.
 */

public class StringUtils {

    public static boolean isEmpty(@Nullable CharSequence str){
        if(str==null || str.toString().trim().length()==0){
            return true;
        }else{
            return false;
        }
    }
}
