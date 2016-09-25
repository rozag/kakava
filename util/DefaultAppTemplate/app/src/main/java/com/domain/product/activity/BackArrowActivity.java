package com.domain.product.activity;

import android.view.MenuItem;

public abstract class BackArrowActivity extends BaseActivity {

    @Override
    protected boolean displayHomeAsUp() {
        return true;
    }

    @Override
    protected boolean homeButtonEnabled() {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item != null && item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
