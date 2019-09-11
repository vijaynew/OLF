package com.raushan.roomapps.ui.item.detail;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.databinding.DataBindingUtil;

import com.raushan.roomapps.Config;
import com.raushan.roomapps.R;
import com.raushan.roomapps.databinding.ActivityItemBinding;
import com.raushan.roomapps.ui.common.PSAppCompactActivity;
import com.raushan.roomapps.utils.Constants;
import com.raushan.roomapps.utils.MyContextWrapper;


public class ItemActivity extends PSAppCompactActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityItemBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_item);

        initUI(binding);

    }

    @Override
    protected void attachBaseContext(Context newBase) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(newBase);
        String CURRENT_LANG_CODE = preferences.getString(Constants.LANGUAGE_CODE, Config.DEFAULT_LANGUAGE);
        String CURRENT_LANG_COUNTRY_CODE = preferences.getString(Constants.LANGUAGE_COUNTRY_CODE, Config.DEFAULT_LANGUAGE_COUNTRY_CODE);

        super.attachBaseContext(MyContextWrapper.wrap(newBase, CURRENT_LANG_CODE, CURRENT_LANG_COUNTRY_CODE, true));
    }

    private void initUI(ActivityItemBinding binding) {

//        String title = getIntent().getStringExtra(Constants.ITEM_NAME);
//
//        initToolbar(binding.toolbar, title);

        // setup Fragment
        setupFragment(new ItemFragment());

    }
}
