package com.bignerddranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by hyuntae on 2016-05-16.
 *
 * CrimeLab은 싱글톤이다. private로 된 생성자와 인스턴스를 반환하는 get함수 반드시 선언
 */
public class CrimeLab {
    private ArrayList<Crime> mCrimes;
    private static CrimeLab sCrimeLab;
    private Context mAppContent;

    private CrimeLab(Context appContext){//싱글톤에서 Context는 액티비티를 시작, 리소스 액세스, private 저장소를 찾는다.
        mAppContent = appContext;
        mCrimes = new ArrayList<>();
        for(int i=0; i <100; i++){
            Crime c = new Crime();//Crime 객체를 여기 생성해서 타이틀 설정
            c.setTitle("범죄 #" +i);
            //범죄해결여부 홀수는 false, 짝수는 true
            c.setSolved(i%2==0);
            mCrimes.add(c);
        }
    }

    public static CrimeLab get(Context c){//Context 파라메터는 직접 생성자에 전달하지 않고 get을 통해 전달.
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(c.getApplicationContext());//getApplicationContext는 앱 생명 주기동안 없어지지 않고 전체앱에서 사용가능
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for(Crime c: mCrimes){
            if(c.getId().equals(id))
                return c;
        }
        return null;
    }
}
