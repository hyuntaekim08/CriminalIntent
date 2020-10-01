package com.bignerddranch.android.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by hyuntae on 2016-05-13.
 */
public class Crime {
    private final UUID mId;
    private String mTitle;
    private final Date mDate;
    private boolean mSolved;

    public Crime(){
        mId = UUID.randomUUID();
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

    public boolean isSolved(){
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    @Override
    public String toString(){
        return mTitle;
    }
}
