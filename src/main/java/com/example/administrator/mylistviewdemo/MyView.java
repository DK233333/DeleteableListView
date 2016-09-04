package com.example.administrator.mylistviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

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

public class MyView extends ViewGroup {
    private float currentX;
    Scroller scroller;

    public void init(){
        scroller = new Scroller(getContext());
    };

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        view0.layout(0,0,view0.getMeasuredWidth(),view0.getMeasuredHeight());
        view1.layout(view0.getMeasuredWidth(),0,view1.getLayoutParams().width+view0.getMeasuredWidth(),view1.getMeasuredHeight());
    }
    View view0;
    View view1;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();
        if(count == 2)
        {

            view0 = getChildAt(0);
            view0.measure(widthMeasureSpec,heightMeasureSpec);

            view1 = getChildAt(1);
            view1.measure(50,heightMeasureSpec);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    float downX;
    float moveX;
    float upX;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = event.getX();
                currentX = moveX - downX;
                if(getScrollX()-currentX<=0)
                {
                    scrollTo(0,0);
                }
                else if(getScrollX()-currentX>=view1.getLayoutParams().width)
                {
                    scrollTo(view1.getLayoutParams().width,0);
                }
                else
                    scrollBy((int) -currentX,0);
                downX = moveX;
                return true;
            case MotionEvent.ACTION_UP:
                upX = event.getX();
                int dx;
                if(getScrollX()<view1.getLayoutParams().width/2)
                {
                    dx = 0-getScrollX();
                }
                else
                {
                    dx = view1.getLayoutParams().width-getScrollX();
                }
                scroller.startScroll(getScrollX(),0,dx,0,Math.abs(dx*5));
                invalidate();
                break;
        }
        return true;
    }





    float downY;
    float moveY;

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(scroller.computeScrollOffset())
        {
            int currX = scroller.getCurrX();
            scrollTo(currX,0);
            invalidate();
        }
    }
}
