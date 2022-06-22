DataBinding-ktx
=====

`DataBinding-ktx` make easy to use DataBinding.

[ViewBinding-ktx](https://github.com/wada811/ViewBinding-ktx) is here.

## Overview

- `DataBinding-ktx` is automatically calling `setLifecycleOwner`.
- `DataBinding-ktx` provides `withBinding` method accessing the `binding` variable by lambda.
- [Deprecated] `DataBinding-ktx` provides `dataBinding` method accessing the `binding` variable by delegated property.

## Usage

### Lambda

```kotlin
withBinding<DataBindingActivityBinding> { binding ->

}
```

### [Deprecated] Delegated Property

```kotlin
private val binding: DataBindingActivityBinding by dataBinding()
```

Note:
In Fragment, When fragment's view is destroyed, an IllegalStateException is thrown on accessing the binding property.  
If you access the binding property when fragment's view may be destroyed, you must use the Lambda way above.

## Gradle

[![](https://jitpack.io/v/wada811/DataBinding-ktx.svg)](https://jitpack.io/#wada811/DataBinding-ktx)

```groovy
android {
    buildFeatures {
        dataBinding = true
    }
}

repositories {
    maven { url "https://www.jitpack.io" }
}

dependencies {
    implementation 'com.github.wada811:DataBinding-ktx:x.y.z'
}
```

## License

Copyright (C) 2020 wada811

Licensed under the Apache License, Version 2.0
