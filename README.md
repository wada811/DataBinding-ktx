DataBinding-ktx
=====

[![Build Status](https://app.bitrise.io/app/25a74c8a899d5c9a/status.svg?token=rSUoGqwaasQ6M5a7KKPTdA&branch=master)](https://app.bitrise.io/app/25a74c8a899d5c9a)

`DataBinding-ktx` make easy declaring ViewDataBinding by delegated property.

## Usage
### Activity

```kotlin
class MainActivity : AppCompatActivity() {
    private val binding: MainActivityBinding by bind(R.layout.main_activity)
}
```

### Fragment

```kotlin
class MainFragment : Fragment() {
    private val binding: MainFragmentBinding by bind(R.layout.main_fragment)
}
```

## Gradle

[![](https://jitpack.io/v/wada811/DataBinding-ktx.svg)](https://jitpack.io/#wada811/DataBinding-ktx)

```groovy
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation 'com.github.wada811:DataBinding-ktx:x.y.z'
}
```

## License

Copyright (C) 2019 wada811

Licensed under the Apache License, Version 2.0
