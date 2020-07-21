package com.applex.snaplingo;

public class Items {
    private boolean isChecked = false;
    private String mDate;
    private String mText1;

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public Items(String str, String str2) {
        this.mText1 = str;
        this.mDate = str2;
    }

    public String getmText1() {
        return this.mText1;
    }

    public String getmText2() {
        return this.mDate;
    }
}
