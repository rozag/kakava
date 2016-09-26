package ${packageName}.activity;

import android.view.MenuItem;

/**
 * Simple base class for activities with home toolbar arrow.
 * {@link BackArrowActivity#onBackPressed()} is invoked on the arrow click,
 * so you can override {@link BackArrowActivity#onBackPressed()} or
 * {@link BackArrowActivity#onOptionsItemSelected(MenuItem)} for customization.
 */
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
