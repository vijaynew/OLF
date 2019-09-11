package com.raushan.roomapps.ui.blog.detail;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.databinding.DataBindingUtil;

import com.raushan.roomapps.Config;
import com.raushan.roomapps.R;
import com.raushan.roomapps.databinding.ActivityBlogDetailBinding;
import com.raushan.roomapps.ui.common.PSAppCompactActivity;
import com.raushan.roomapps.utils.Constants;
import com.raushan.roomapps.utils.MyContextWrapper;

public class BlogDetailActivity extends PSAppCompactActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityBlogDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_blog_detail);

        initUI(binding);

    }

    @Override
    protected void attachBaseContext(Context newBase) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(newBase);
        String CURRENT_LANG_CODE = preferences.getString(Constants.LANGUAGE_CODE, Config.DEFAULT_LANGUAGE);
        String CURRENT_LANG_COUNTRY_CODE = preferences.getString(Constants.LANGUAGE_COUNTRY_CODE, Config.DEFAULT_LANGUAGE_COUNTRY_CODE);

        super.attachBaseContext(MyContextWrapper.wrap(newBase, CURRENT_LANG_CODE, CURRENT_LANG_COUNTRY_CODE, true));
    }

    private void initUI(ActivityBlogDetailBinding binding) {

        // Toolbar
        initToolbar(binding.toolbar, getResources().getString(R.string.blog_detail__title));

        // setup Fragment
        setupFragment(new BlogDetailFragment());

    }
}
