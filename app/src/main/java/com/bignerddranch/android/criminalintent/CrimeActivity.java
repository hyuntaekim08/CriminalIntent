package com.bignerddranch.android.criminalintent;

import androidx.fragment.app.Fragment;

public class CrimeActivity extends SingleFragmentActivity {//프라그먼트 쓰려면 반드시 FragmentActivity써야됨

    @Override
    protected Fragment createFragment(){
        return new CrimeFragment();
    }
}
