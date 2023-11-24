DataBinding-ktx
=====

`DataBinding-ktx` makes it easy to use DataBinding.

[ViewBinding-ktx](https://github.com/wada811/ViewBinding-ktx) is here.

## Overview

- `DataBinding-ktx` is automatically calling `setLifecycleOwner`.
- `DataBinding-ktx` provides the `withBinding` method accessing the `binding` variable by lambda.
- `DataBinding-ktx` provides the `dataBinding` method accessing the `binding` variable by delegated property.

## Usage

### Lambda (Recommended)

```kotlin
withBinding<DataBindingActivityBinding> { binding ->

}
```

### Delegated Property

```kotlin
private val binding: DataBindingActivityBinding by dataBinding()
```

Note:
In Fragment, When the fragment's view is destroyed, an IllegalStateException is thrown on accessing the binding property.  
If you access the binding property when the fragment's view may be destroyed, you must use the Lambda way above.

## Gradle

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.wada811.databindingktx/databindingktx/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.wada811.databindingktx/databindingktx)

```groovy
android {
    buildFeatures {
        dataBinding = true
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'com.wada811.databindingktx:databindingktx:x.y.z'
}
```

## Migrations

### 7.0.0

#### dependencies

```diff
-    implementation 'com.github.wada811:DataBinding-ktx:x.y.z'
+    implementation 'com.wada811.databindingktx:databindingktx:x.y.z'
```

#### package

```diff
-import com.wada811.databinding
+import com.wada811.databindingktx
```

## License

Copyright (C) 2020 wada811

Licensed under the Apache License, Version 2.0
