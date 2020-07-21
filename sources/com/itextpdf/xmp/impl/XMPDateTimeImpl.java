package com.itextpdf.xmp.impl;

import com.itextpdf.xmp.XMPDateTime;
import com.itextpdf.xmp.XMPException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class XMPDateTimeImpl implements XMPDateTime {
    private int day = 0;
    private boolean hasDate = false;
    private boolean hasTime = false;
    private boolean hasTimeZone = false;
    private int hour = 0;
    private int minute = 0;
    private int month = 0;
    private int nanoSeconds;
    private int second = 0;
    private TimeZone timeZone = null;
    private int year = 0;

    public XMPDateTimeImpl() {
    }

    public XMPDateTimeImpl(Calendar calendar) {
        Date time = calendar.getTime();
        TimeZone timeZone2 = calendar.getTimeZone();
        GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance(Locale.US);
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        gregorianCalendar.setTimeZone(timeZone2);
        gregorianCalendar.setTime(time);
        this.year = gregorianCalendar.get(1);
        this.month = gregorianCalendar.get(2) + 1;
        this.day = gregorianCalendar.get(5);
        this.hour = gregorianCalendar.get(11);
        this.minute = gregorianCalendar.get(12);
        this.second = gregorianCalendar.get(13);
        this.nanoSeconds = gregorianCalendar.get(14) * 1000000;
        this.timeZone = gregorianCalendar.getTimeZone();
        this.hasTimeZone = true;
        this.hasTime = true;
        this.hasDate = true;
    }

    public XMPDateTimeImpl(Date date, TimeZone timeZone2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone2);
        gregorianCalendar.setTime(date);
        this.year = gregorianCalendar.get(1);
        this.month = gregorianCalendar.get(2) + 1;
        this.day = gregorianCalendar.get(5);
        this.hour = gregorianCalendar.get(11);
        this.minute = gregorianCalendar.get(12);
        this.second = gregorianCalendar.get(13);
        this.nanoSeconds = gregorianCalendar.get(14) * 1000000;
        this.timeZone = timeZone2;
        this.hasTimeZone = true;
        this.hasTime = true;
        this.hasDate = true;
    }

    public XMPDateTimeImpl(String str) throws XMPException {
        ISO8601Converter.parse(str, this);
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public int getYear() {
        return this.year;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public void setYear(int i) {
        this.year = Math.min(Math.abs(i), 9999);
        this.hasDate = true;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public int getMonth() {
        return this.month;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public void setMonth(int i) {
        if (i < 1) {
            this.month = 1;
        } else if (i > 12) {
            this.month = 12;
        } else {
            this.month = i;
        }
        this.hasDate = true;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public int getDay() {
        return this.day;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public void setDay(int i) {
        if (i < 1) {
            this.day = 1;
        } else if (i > 31) {
            this.day = 31;
        } else {
            this.day = i;
        }
        this.hasDate = true;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public int getHour() {
        return this.hour;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public void setHour(int i) {
        this.hour = Math.min(Math.abs(i), 23);
        this.hasTime = true;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public int getMinute() {
        return this.minute;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public void setMinute(int i) {
        this.minute = Math.min(Math.abs(i), 59);
        this.hasTime = true;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public int getSecond() {
        return this.second;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public void setSecond(int i) {
        this.second = Math.min(Math.abs(i), 59);
        this.hasTime = true;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public int getNanoSecond() {
        return this.nanoSeconds;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public void setNanoSecond(int i) {
        this.nanoSeconds = i;
        this.hasTime = true;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        float signum;
        XMPDateTime xMPDateTime = (XMPDateTime) obj;
        long timeInMillis = getCalendar().getTimeInMillis() - xMPDateTime.getCalendar().getTimeInMillis();
        if (timeInMillis != 0) {
            signum = Math.signum((float) timeInMillis);
        } else {
            signum = Math.signum((float) ((long) (this.nanoSeconds - xMPDateTime.getNanoSecond())));
        }
        return (int) signum;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public void setTimeZone(TimeZone timeZone2) {
        this.timeZone = timeZone2;
        this.hasTime = true;
        this.hasTimeZone = true;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public boolean hasDate() {
        return this.hasDate;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public boolean hasTime() {
        return this.hasTime;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public boolean hasTimeZone() {
        return this.hasTimeZone;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public Calendar getCalendar() {
        GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance(Locale.US);
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        if (this.hasTimeZone) {
            gregorianCalendar.setTimeZone(this.timeZone);
        }
        gregorianCalendar.set(1, this.year);
        gregorianCalendar.set(2, this.month - 1);
        gregorianCalendar.set(5, this.day);
        gregorianCalendar.set(11, this.hour);
        gregorianCalendar.set(12, this.minute);
        gregorianCalendar.set(13, this.second);
        gregorianCalendar.set(14, this.nanoSeconds / 1000000);
        return gregorianCalendar;
    }

    @Override // com.itextpdf.xmp.XMPDateTime
    public String getISO8601String() {
        return ISO8601Converter.render(this);
    }

    public String toString() {
        return getISO8601String();
    }
}
