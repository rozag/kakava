# default-kotlin template
The main purpose of this template is to provide you with an environment which is more comfortable for fast prototypes and experiments than the default one provided by Android Studio. It consists of:
* `App.kt` - an empty Application class
* `BaseActivity.kt` - a convenient abstract parent Activity class
* `BackArrowActivity.kt` - an abstract Activity class with basic "back button" functionality
* `MainActivity.kt` - an empty Activity class for the fast start

## BaseActivity details
This class provides basic Activity functions such as
* Layout resource id
* String resource id for the title
* Boolean flags for the home button

Here is the code:
```kotlin
/**
 * Simple base class for all activities in the app.
 * [BaseActivity] finds [Toolbar] by R.id.toolbar id and sets it up.
 */
abstract class BaseActivity : AppCompatActivity() {

    /**
     * id of your activity layout. Return 0 if you don't want to provide the layout.
     */
    protected abstract val layoutResourceId: Int

    /**
     * id of your toolbar title. Return 0 if you don't want to provide the title.
     */
    protected abstract val toolbarTitleId: Int

    /**
     * whether home should be displayed as an "up" affordance.
     */
    protected abstract val displayHomeAsUp: Boolean

    /**
     * whether home button in the corner of [Toolbar] should be enabled
     */
    protected abstract val homeButtonEnabled: Boolean

    protected var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (layoutResourceId != 0) {
            setContentView(layoutResourceId)
        }
        setUpToolbar()
    }

    protected fun setUpToolbar() {
        toolbar = findViewById(R.id.toolbar) as Toolbar
        if (toolbar != null) {
            setSupportActionBar(toolbar)
        }

        if (toolbarTitleId != 0) {
            setTitle(toolbarTitleId)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(displayHomeAsUp)
        supportActionBar?.setHomeButtonEnabled(homeButtonEnabled)
    }

}
```

## BackArrowActivity details
This class extends the BaseActivity and provides home button related flags for you.
Here is the code:
```kotlin
/**
 * Simple base class for activities with home toolbar arrow.
 * [BackArrowActivity.onBackPressed] is invoked on the arrow click,
 * so you can override [BackArrowActivity.onBackPressed] for customization.
 */
abstract class BackArrowActivity : BaseActivity() {

    override val displayHomeAsUp = true
    override val homeButtonEnabled = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar?.setNavigationOnClickListener { onBackPressed() }
    }

}
```