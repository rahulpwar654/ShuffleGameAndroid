package com.rahulp.shufflegame;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;


/**
 * Created by warlord on 10/7/2017.
 */

public class CustomImageView extends android.support.v7.widget.AppCompatImageView {


    /**
     * get size of minimum side (height or width )
     * and store it in  edgeSize
     */
    private  int edgeSize=0;


    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //setWidgetWidth((int) (widthSize * 0.6));
        //setWidgetHeight((int) (heightSize * 0.6));

      /*  int width;
        int height;

        width=widthSize;
        height=heightSize;*/

        /*//Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(getWidgetWidth(), widthSize);
        } else {
            width = getWidgetWidth();
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = Math.min(getWidgetHeight(), heightSize);
        } else {
            height = getWidgetHeight();
        }*/


        if(widthSize==Math.min(widthSize,heightSize))
        {
            heightSize=widthSize;
            edgeSize=widthSize;
        }else{
            widthSize=heightSize;
            edgeSize=heightSize;
        }

        setMeasuredDimension(widthSize,heightSize);
    }

    public int getEdgeSize() {
        return edgeSize;
    }

    public void setEdgeSize(int edgeSize) {
        this.edgeSize = edgeSize;
    }
    @Override
    public boolean isInEditMode() {
        return true;
    }
}
