package com.bignerddranch.android.criminalintent;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by hyuntae on 2016-05-13.
 */
public class CrimeFragment extends Fragment{

    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mCrime = new Crime();

        UUID crimeId = (UUID)getActivity().getIntent().getSerializableExtra(Constants.EXTRA_CRIME_ID);//자신을 호스팅하는 CrimeActivity의 인텐트의 정보를 이렇게 불러온다.
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);//위의 id를 가지고 crimelab에 매치된 crime 요소를 가지고 온다.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){//프레그먼트는 뷰를 onCreate에 생성하지 않고 여기에 함
        View v = inflater.inflate(R.layout.fragment_crime, parent, false);//첫번째 인자 레이아웃, 두번째 뷰의 부모, 세번째 뷰를 뷰의 부모에 추가할것인지 여부
        //세번째 인자가 false인 이유는 뷰를 부모가 아니라 호스팅 액티비티에 추가할 것이기 때문.

        mTitleField = (EditText)v.findViewById(R.id.crime_title); //주의!!!!! v.으로 시작 해야 됨
        mTitleField.setText(mCrime.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDateButton = (Button)v.findViewById(R.id.crime_date);
        mDateButton.setText(mCrime.getDate().toString());
        mDateButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });
        return v;
    }
}
