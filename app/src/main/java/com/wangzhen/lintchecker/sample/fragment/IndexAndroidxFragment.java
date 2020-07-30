package com.wangzhen.lintchecker.sample.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wangzhen.lintchecker.sample.R;
import com.wangzhen.lintchecker.sample.activity.BaseFragment;

public class IndexAndroidxFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout._activity_main, container, false);
    }
}
