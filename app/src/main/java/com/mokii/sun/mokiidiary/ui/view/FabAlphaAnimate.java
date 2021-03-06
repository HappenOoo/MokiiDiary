package com.mokii.sun.mokiidiary.ui.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.design.widget.FloatingActionButton;
import android.view.animation.DecelerateInterpolator;

import com.azhon.suspensionfab.ExpandOrientation;
import com.azhon.suspensionfab.SuspensionFab;
import com.azhon.suspensionfab.manager.AnimationManager;
public class FabAlphaAnimate extends AnimationManager {


    public FabAlphaAnimate(SuspensionFab fabView) {
        super(fabView);
    }

    @Override
    public void openAnimation(FloatingActionButton fab, ExpandOrientation orientation) {
        //判断展开的方向
        switch (orientation) {
            case FAB_TOP:
                if (fab.getTag().equals(3)) {
                    //透明动画
                    ObjectAnimator alpha = ObjectAnimator.ofFloat(fab, "alpha", 0f, 1f);
                    alpha.setDuration(fabView.getAnimateDuration() + 400);
                    alpha.start();
                } else if (fab.getTag().equals(2)) {
                    //组合动画
                    AnimatorSet animatorSet = new AnimatorSet();
                    ObjectAnimator scaleX = ObjectAnimator.ofFloat(fab, "scaleX", 0f, 1f);
                    ObjectAnimator scaleY = ObjectAnimator.ofFloat(fab, "scaleY", 0f, 1f);
                    animatorSet.setDuration(fabView.getAnimateDuration() + 400);
                    animatorSet.setInterpolator(new DecelerateInterpolator());
                    //两个动画同时开始
                    animatorSet.play(scaleX).with(scaleY);
                    animatorSet.start();
                }
                break;
            case FAB_BOTTOM:
                break;
            case FAB_LEFT:
                break;
            case FAB_RIGHT:
                break;
        }
    }

    @Override
    public void closeAnimation(final FloatingActionButton fab, ExpandOrientation orientation) {
        switch (orientation) {
            case FAB_TOP:
                break;
            case FAB_BOTTOM:
                break;
            case FAB_LEFT:
                break;
            case FAB_RIGHT:
                break;
        }
    }

    @Override
    public void defaultFabAnimation(FloatingActionButton fab, ExpandOrientation orientation,
                                    boolean currentState) {
        if (currentState) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(fab, "rotation", 0, 45);
            animator.setDuration(fabView.getAnimateDuration());
            animator.start();
        } else {
            ObjectAnimator animator = ObjectAnimator.ofFloat(fab, "rotation", -45, -90);
            animator.setDuration(fabView.getAnimateDuration());
            animator.start();
        }
    }

}
