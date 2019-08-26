package com.example.lenovo.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class President implements Parcelable {
    String nama;
    String remaks;
    String photo;

    public President() {
    }

    public President(String nama, String remaks, String photo) {
        this.nama = nama;
        this.remaks = remaks;
        this.photo = photo;
    }

    protected President(Parcel in) {
        nama = in.readString();
        remaks = in.readString();
        photo = in.readString();
    }

    public static final Creator<President> CREATOR = new Creator<President>() {
        @Override
        public President createFromParcel(Parcel in) {
            return new President(in);
        }

        @Override
        public President[] newArray(int size) {
            return new President[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRemaks() {
        return remaks;
    }

    public void setRemaks(String remaks) {
        this.remaks = remaks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(remaks);
        dest.writeString(photo);
    }
}
