package com.domain.product.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.domain.product.R;

/**
 * Simple base class for all activities in the app.
 * {@link BaseActivity} finds {@link Toolbar} by R.id.toolbar id and sets it up.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Nullable
    protected Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = layoutResourceId();
        if (layoutId != 0) {
            setContentView(layoutId);
        }
        setUpToolbar();
    }

    protected void setUpToolbar() {
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        if (toolBar != null) {
            setSupportActionBar(toolBar);
            int titleId = toolbarTitleId();
            if (titleId != 0) {
                setTitle(titleId);
            }
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(displayHomeAsUp());
            actionBar.setHomeButtonEnabled(homeButtonEnabled());
        }
    }

    /**
     * @return id of your activity layout. Return 0 if you don't want to provide the layout.
     */
    @LayoutRes
    protected abstract int layoutResourceId();

    /**
     * @return id of your toolbar title. Return 0 if you don't want to provide the title.
     */
    @StringRes
    protected abstract int toolbarTitleId();

    /**
     * @return whether home should be displayed as an "up" affordance.
     */
    protected abstract boolean displayHomeAsUp();

    /**
     * @return whether home button in the corner of {@link Toolbar} should be enabled
     */
    protected abstract boolean homeButtonEnabled();

}
