DataBinding-ktx
=====

`DataBinding-ktx` make easy declaring DataBinding and ViewBinding.

## Usage in DataBinding
### Activity
```diff
 class DataBindingActivity : FragmentActivity() {
+    private val binding: DataBindingActivityBinding by dataBinding(R.layout.data_binding_activity)
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
-        val binding = DataBindingUtil.setContentView<DataBindingActivityBinding>(this, R.layout.data_binding_activity)
-        binding.lifecycleOwner = this
     }
 }
```

### Fragment
```diff
 class DataBindingFragment : Fragment() {
+    private val binding: DataBindingFragmentBinding by dataBinding(R.layout.data_binding_fragment)
     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
-        val binding = DataBindingUtil.inflate<DataBindingFragmentBinding>(inflater, R.layout.data_binding_fragment, container, false)
-        binding.lifecycleOwner = viewLifecycleOwner
         return binding.root
     }
 }

```

## Usage in ViewBinding
### Activity
```diff
 class ViewBindingActivity : FragmentActivity() {
+    private val binding: ViewBindingActivityBinding by viewBinding()
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
-        val binding = ViewBindingActivityBinding.inflate(layoutInflater)
-        setContentView(binding.root)
     }
 }
```

### Fragment
```diff
 class ViewBindingFragment : Fragment() {
+    private val binding: ViewBindingFragmentBinding by viewBinding()
     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
-        val binding = ViewBindingFragmentBinding.inflate(inflater, container, false)
         return binding.root
     }
 }
```

## Gradle

[![](https://jitpack.io/v/wada811/DataBinding-ktx.svg)](https://jitpack.io/#wada811/DataBinding-ktx)

```groovy
repositories {
    maven { url "https://www.jitpack.io" }
}

dependencies {
    implementation 'com.github.wada811:DataBinding-ktx:x.y.z'
}
```

## License

Copyright (C) 2019 wada811

Licensed under the Apache License, Version 2.0
