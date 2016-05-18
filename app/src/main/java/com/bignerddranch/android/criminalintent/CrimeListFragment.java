package com.bignerddranch.android.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hyuntae on 2016-05-16.
 */
public class CrimeListFragment extends ListFragment {
    private static final String TAG = "CrimeListFragment";
    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);//getActivity는 호스팅하는 액티비티를 반환
        mCrimes = CrimeLab.get(getActivity()).getCrimes(); //와 씨발 이거 잘봐 어떻게 객체불러오는지;;;어려움.
        //첫번째 2번인자인 리소스id에 필요한 context객체, ArrayAdapter가 사용할 레이아웃, 모델
        //ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(), android.R.layout.simple_list_item_1, mCrimes);
        //setListAdapter(adapter);//ListFragment의 편의 메소드

        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);//getListAdapter는 ListFragment의 편의 메소드. 리스트뷰에 설정된 어답터 반환.
        //Log.d(TAG, c.getTitle()+" was Clicked");

        Intent i = new Intent(getActivity(), CrimeActivity.class);
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getId());
        startActivity(i);
    }

    private class CrimeAdapter extends ArrayAdapter<Crime>{
        public CrimeAdapter(ArrayList<Crime> crimes){//Crime객체만을 저장한다.
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView ==  null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
            }
            Crime c = getItem(position);//제대로된 item을 가져와야 view나 버튼에 알맞은 값을 저장한다.

            TextView titleTextView = (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
            titleTextView.setText(c.getTitle());//반드시 setText메소드로 저장하고 값은 crime 클래스에 정의된 것을 가지고 온다.

            TextView dateTextView = (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateTextView.setText(c.getDate().toString());

            CheckBox solvedCheckBox = (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(c.isSolved());

            return convertView;
        }

    }
}
