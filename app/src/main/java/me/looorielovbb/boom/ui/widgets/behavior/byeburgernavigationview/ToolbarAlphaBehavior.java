package me.looorielovbb.boom.ui.widgets.behavior.byeburgernavigationview;

import android.content.Context;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.appcompat.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import me.looorielovbb.boom.R;

/**
 * Created by Lulei on 2017/4/14.
 * time : 16:55
 * date : 2017/4/14
 * mail to lulei4461@gmail.com
 */

public class ToolbarAlphaBehavior extends CoordinatorLayout.Behavior<Toolbar> {
    private static final String TAG = "ToolbarAlphaBehavior";
    private int offset = 0;
    private int startOffset = 0;
    private int endOffset = 0;
    private Context context;

    public ToolbarAlphaBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, Toolbar child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }


    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, Toolbar toolbar, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        startOffset = 0;
        endOffset = context.getResources().getDimensionPixelOffset(R.dimen.actionbarSize) -
                    toolbar.getHeight();
        offset += dyConsumed;
        if (offset <= startOffset) {  //alpha为0
            toolbar.getBackground().setAlpha(0);
        } else if (offset > startOffset && offset < endOffset) { //alpha为0到255
            float precent = (float) (offset - startOffset) / endOffset;
            int alpha = Math.round(precent * 255);
            toolbar.getBackground().setAlpha(alpha);
        } else if (offset >= endOffset) {  //alpha为255
            toolbar.getBackground().setAlpha(255);
        }
    }

}