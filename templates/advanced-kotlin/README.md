# advanced-kotlin template
The aim of this template is to provide ready interfaces for different things (analytics, crash reporting, remote config, etc.) to improve decoupling and overall architecture of an app. These interfaces are:
* `AnalyticsProvider` - an abstraction for different mobile analytics services (FirebaseAnalytics, GoogleAnalytics, etc.)
* `CrashProvider` - an abstraction for different mobile crash reporting services (Fabric, FirebaseCrash, etc.)
* `PrefsProvider` - an abstraction for `SharedPreferences`. It prevents Android framework dependencies in your code and allows you to use different `SharedPreferences` implementations (e.g. [binaryprefs](https://github.com/iamironz/binaryprefs))
* `RemoteConfigProvider` - an abstraction for the remote config services (e.g. FirebaseRemoteConfig)
* `ResProvider` - an abstraction for `Resources`. Like `PrefsProvider` it prevents Android dependencies in your code

Moreover, the [Timber](https://github.com/JakeWharton/timber) library with the `ReleaseTree` is already imported in this template.

For more details on `BaseActivity` and `BackArrowActivity` check out [the default-kotlin template](https://github.com/rozag/kakava/tree/master/templates/default-kotlin).
