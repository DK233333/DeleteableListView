package com.example.administrator.mylistviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * /**
 * <p/>
 * ----------Dragon be here!----------/
 * 　　　 ┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 */

public class MyListView extends ListView {

    boolean isdis;
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }


    float downX;
    float moveX;
    float downY;
    float moveY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                downX = ev.getX();
                downY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = ev.getX();
                moveY = ev.getY();
                if(Math.abs(moveX-downX)>Math.abs(moveY-downY))
                {
                    isdis = true;
                    return false;
                }
            case MotionEvent.ACTION_UP:
                isdis = false;
                break;
        }
            if(!isdis)
                return super.onInterceptTouchEvent(ev);
            else
                return false;
    }

}
