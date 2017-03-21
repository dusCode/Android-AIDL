package com.dus.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class HelloMsg implements Parcelable {
    private String msg;
    private int id;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HelloMsg(String msg, int pid) {
        this.msg = msg;
        this.id = pid;
    }

    protected HelloMsg(Parcel in) {
        msg = in.readString();
        id = in.readInt();
    }

    public static final Creator<HelloMsg> CREATOR = new Creator<HelloMsg>() {
        @Override
        public HelloMsg createFromParcel(Parcel in) {
            return new HelloMsg(in);
        }

        @Override
        public HelloMsg[] newArray(int size) {
            return new HelloMsg[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(msg);
        parcel.writeInt(id);
    }
}
