package com.wada811.databindingktx.sample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.wada811.databinding.ActivityDataBinding;
import com.wada811.databinding.FragmentDataBinding;
import com.wada811.databindingktx.R;
import com.wada811.databindingktx.databinding.DataBindingActivityBinding;
import com.wada811.databindingktx.databinding.DataBindingFragmentBinding;

@SuppressWarnings("ALL")
public class DataBindingSampleJava {

    public class DataBindingActivity extends FragmentActivity {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            DataBindingActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.data_binding_activity);
            binding.setLifecycleOwner(this);
        }
    }

    public class TopLevelFunctionActivity extends FragmentActivity {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            DataBindingActivityBinding binding = ActivityDataBinding.setContentView(this, R.layout.data_binding_activity);
        }
    }

    public class DataBindingFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            DataBindingFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.data_binding_fragment, container, false);
            binding.setLifecycleOwner(getViewLifecycleOwner());
            return binding.getRoot();
        }
    }

    public class TopLevelFunctionFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            DataBindingFragmentBinding binding = FragmentDataBinding.inflate(this, R.layout.data_binding_fragment, container, false);
            return binding.getRoot();
        }
    }

}
