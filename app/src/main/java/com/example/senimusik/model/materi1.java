package com.example.senimusik.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.util.List;

public class materi1 implements Parcelable {
    private List<materi1s> materi1s;

    protected materi1(Parcel in) {
        id = in.readInt();
        soal = in.readString();
        a = in.readString();
        b = in.readString();
        c = in.readString();
        d = in.readString();
        benar = in.readString();
        image = in.readString();
    }

    public List<materi1.materi1s> getMateri1s() {
        return materi1s;
    }

    public void setMateri1s(List<materi1.materi1s> materi1s) {
        this.materi1s = materi1s;
    }



    private int id;
    private String soal;
    private String a;
    private String b;
    private String c;
    private String d;
    private String benar;
    private String image;

    public static final Creator<materi1> CREATOR = new Creator<materi1>() {
        @Override
        public materi1 createFromParcel(Parcel in) {
            return new materi1(in);
        }

        @Override
        public materi1[] newArray(int size) {
            return new materi1[size];
        }
    };

    public static materi1 objectFromData(String str) {

        return new Gson().fromJson(str, materi1.class);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getBenar() {
        return benar;
    }

    public void setBenar(String benar) {
        this.benar = benar;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(soal);
        dest.writeString(a);
        dest.writeString(b);
        dest.writeString(c);
        dest.writeString(d);
        dest.writeString(benar);
        dest.writeString(image);
    }

    private class materi1s {
    }
}
