package com.bignerddranch.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by hyuntae on 2016-05-16.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {
    protected abstract Fragment createFragment(); //SingleFragmentActivity의 섭 클래스들은 이 메소드를 구현하여 액티비티가 호스팅하는 프레그먼트의 인스턴스를 반환해야함.


    private int thisistest = 0;
    private int thisistest2 = 1;

    private int testfromfeaturetest = 0;

    private string diff = "this is still 0.0.2"
    private int differencewithtag = 1;

    private double tag = 0.2;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if(fragment == null){
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }
}
