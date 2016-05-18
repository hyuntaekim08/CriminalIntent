package com.bignerddranch.android.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by hyuntae on 2016-05-13.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
        mId = UUID.randomUUID();//crime이 생성될때 마다 임의의 ID를 넣는다(그럼 id는 게터 함수로 확인해야겠다)
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isSolved(){
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    @Override//리스트 뷰에 다른 정보는 빼고(toString오버라이드 안하면 잡다한거 들어감) 타이틀만 넣는다.
    public String toString(){
        return mTitle;
    }
}
