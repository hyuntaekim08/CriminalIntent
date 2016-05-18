package com.bignerddranch.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by hyuntae on 2016-05-16.
 */
public class SingleListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }
}
