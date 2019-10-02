DataBinding-ktx
=====

`DataBinding-ktx` make easy declaring DataBinding and ViewBinding.

## Usage in DataBinding
### Activity

#### Delegated Property

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

#### Top-level function

```diff
 class DataBindingActivity : FragmentActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
-        val binding = DataBindingUtil.setContentView<DataBindingActivityBinding>(this, R.layout.data_binding_activity)
-        binding.lifecycleOwner = this
+        val binding = setContentView<DataBindingActivityBinding>(this, R.layout.data_binding_activity)
     }
 }
```

### Fragment

#### Delegated Property

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

#### Top-level function

```diff
 class DataBindingFragment : Fragment() {
     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
-        val binding = DataBindingUtil.inflate<DataBindingFragmentBinding>(inflater, R.layout.data_binding_fragment, container, false)
-        binding.lifecycleOwner = viewLifecycleOwner
+        val binding = inflate<DataBindingFragmentBinding>(this, R.layout.data_binding_fragment, container, false)
         return binding.root
     }
 }

```
## Usage in ViewBinding
### Activity

#### Delegated Property

```diff
 class ViewBindingActivity : FragmentActivity() {
+    private val binding by viewBinding { ViewBindingActivityBinding.inflate(it) }
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
-        val binding = ViewBindingActivityBinding.inflate(layoutInflater)
-        setContentView(binding.root)
     }
 }
```

#### Delegated Property with Reflection

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

#### Top-level function

```diff
 class ViewBindingActivity : FragmentActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
-        val binding = ViewBindingActivityBinding.inflate(layoutInflater)
-        setContentView(binding.root)
+        val binding = setContentView { ViewBindingActivityBinding.inflate(it) }
     }
 }
```

### Fragment
#### Delegated Property

```diff
 class ViewBindingFragment : Fragment() {
+    private val binding by viewBinding { inflater, container ->
+        ViewBindingFragmentBinding.inflate(inflater, container, false)
+    }
     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
-        val binding = ViewBindingFragmentBinding.inflate(inflater, container, false)
         return binding.root
     }
 }
```

#### Delegated Property with Reflection

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
