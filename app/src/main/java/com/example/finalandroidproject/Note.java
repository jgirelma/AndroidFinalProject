package com.example.finalandroidproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable, Comparable<Note> {
    private String Title;
    private String Body;
    private String id;
    private long time;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public Note(Parcel in){
        this.Title = in.readString();
        this.Body = in.readString();
        this.id = in.readString();
        this.time = in.readLong();
    }

    public Note(String title, String body) {
        Title = title;
        Body = body;
        time = System.currentTimeMillis() / 1000l;
    }


    public Note(String title, String body, String id, long time) {
        Title = title;
        Body = body;
        this.id = id;
        this.time = time;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIdNull() {
        if(id == null) return true;
        else return false;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Title);
        parcel.writeString(this.Body);
        parcel.writeString(this.id);
        parcel.writeLong(this.time);
    }

    public long getTime() {
        return time;
    }

    public int compareTo(Note note) {

        return (this.getTime() < note.getTime() ? -1 :

                (this.getTime() == this.getTime() ? 0 : 1));

    }

}
