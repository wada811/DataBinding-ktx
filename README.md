DataBinding-ktx
=====

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
