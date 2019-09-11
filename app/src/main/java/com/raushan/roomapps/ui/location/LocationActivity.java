package com.raushan.roomapps.ui.location;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.databinding.DataBindingUtil;

import com.raushan.roomapps.Config;
import com.raushan.roomapps.R;
import com.raushan.roomapps.databinding.ActivityLocationBinding;
import com.raushan.roomapps.ui.common.PSAppCompactActivity;
import com.raushan.roomapps.ui.item.itemlocation.ItemLocationFragment;
import com.raushan.roomapps.utils.Constants;
import com.raushan.roomapps.utils.MyContextWrapper;

public class LocationActivity extends PSAppCompactActivity {


    //region Override Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLocationBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_location);

        // Init all UI
        initUI(binding);

    }

    @Override
    protected void attachBaseContext(Context newBase) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(newBase);
        String CURRENT_LANG_CODE = preferences.getString(Constants.LANGUAGE_CODE, Config.DEFAULT_LANGUAGE);
        String CURRENT_LANG_COUNTRY_CODE = preferences.getString(Constants.LANGUAGE_COUNTRY_CODE, Config.DEFAULT_LANGUAGE_COUNTRY_CODE);

        super.attachBaseContext(MyContextWrapper.wrap(newBase, CURRENT_LANG_CODE, CURRENT_LANG_COUNTRY_CODE, true));
    }

    //endregion


    //region Private Methods

    private void initUI(ActivityLocationBinding binding) {

        // Toolbar
        //initToolbar(binding.toolbar, "Location");

        setupFragment(new ItemLocationFragment());

    }

}