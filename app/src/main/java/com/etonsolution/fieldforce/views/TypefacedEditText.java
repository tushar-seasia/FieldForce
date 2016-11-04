package com.etonsolution.fieldforce.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by BawejaTushar on 10/19/2016.
 */

public class TypefacedEditText extends EditText{

    private Context context;
    private String font = "Lato-Regular.ttf";

    public TypefacedEditText(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public TypefacedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context, attrs);
    }

    public TypefacedEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context, attrs);
    }

    private void init() {
        if(!isInEditMode()){
            //Typeface typeface=TypefaceL
        }
    }

    private void init(Context context, AttributeSet attrs) {
    }
}
