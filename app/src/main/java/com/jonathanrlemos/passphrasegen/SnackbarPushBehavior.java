package com.jonathanrlemos.passphrasegen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;

@SuppressWarnings("unused")
public class SnackbarPushBehavior extends CoordinatorLayout.Behavior<View> {
    /* prevents onCreate from crashing program */
    public SnackbarPushBehavior(Context c, AttributeSet attrs){

    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency){
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency){
        super.onDependentViewChanged(parent, child, dependency);
        float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
        child.setTranslationY(translationY);
        return true;
    }
}
