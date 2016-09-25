package com.domain.product.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.domain.product.R;

public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResourceId());
        setUpToolbar();
    }

    protected void setUpToolbar() {
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        if (toolBar != null) {
            setSupportActionBar(toolBar);
            setTitle(toolbarTitleId());
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(displayHomeAsUp());
            actionBar.setHomeButtonEnabled(homeButtonEnabled());
        }
    }

    @LayoutRes
    protected abstract int layoutResourceId();

    @StringRes
    protected abstract int toolbarTitleId();

    protected abstract boolean displayHomeAsUp();

    protected abstract boolean homeButtonEnabled();

}
