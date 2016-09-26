package com.domain.product.activity;

import android.os.Bundle;

import com.domain.product.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int layoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected int toolbarTitleId() {
        return R.string.app_name;
    }

    @Override
    protected boolean displayHomeAsUp() {
        return false;
    }

    @Override
    protected boolean homeButtonEnabled() {
        return false;
    }

}
