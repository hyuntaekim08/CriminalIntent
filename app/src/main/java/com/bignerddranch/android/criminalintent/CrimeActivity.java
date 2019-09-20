package com.bignerddranch.android.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

public class CrimeActivity extends SingleFragmentActivity {//프라그먼트 쓰려면 반드시 FragmentActivity써야됨

    private String string = "this is tag 0.0.5";
    @Override
    protected Fragment createFragment(){
        return new CrimeFragment();
    }
}
