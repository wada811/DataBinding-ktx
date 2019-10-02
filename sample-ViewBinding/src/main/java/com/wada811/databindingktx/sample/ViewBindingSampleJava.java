package com.wada811.databindingktx.sample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;

import com.wada811.databinding.ActivityViewBinding;
import com.wada811.databinding.FragmentViewBindingKt;
import com.wada811.databindingktx.databinding.ViewBindingActivityBinding;
import com.wada811.databindingktx.databinding.ViewBindingFragmentBinding;

import kotlin.jvm.functions.Function1;

@SuppressWarnings("ALL")
public class ViewBindingSampleJava {

public class ViewBindingActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewBindingActivityBinding binding = ViewBindingActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}

public class SampleActivity  extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityViewBinding.setContentView(this, new Function1<LayoutInflater, ViewBinding>() {
            @Override
            public ViewBinding invoke(LayoutInflater layoutInflater) {
                return ViewBindingActivityBinding.inflate(layoutInflater);
            }
        });
    }
}

public class ViewBindingFramgent extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewBindingFragmentBinding binding = ViewBindingFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}

public class SampleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewBindingFragmentBinding binding = ViewBindingFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}

}
