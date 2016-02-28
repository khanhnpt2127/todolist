package com.example.tknguyen.todotasklist.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.tknguyen.todotasklist.Services.TodoDBDAO;

/**
 * Created by TK's-T420 on 2/28/2016.
 */
public class ToDo implements Parcelable {

    private int id;
    private String task;
    private String priority;

    public ToDo() {
        super();
    }


    private ToDo(Parcel in){
        super();
        this.id = in.readInt();
        this.task = in.readString();
        this.priority = in.readString();
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", task=" + task + ", priority="
                + priority + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ToDo other = (ToDo) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(getId());
        parcel.writeString(getTask());
        parcel.writeString(getPriority());
    }

    public static final Parcelable.Creator<ToDo> CREATOR = new Parcelable.Creator<ToDo>() {
        public ToDo createFromParcel(Parcel in) {
            return new ToDo(in);
        }

        public ToDo[] newArray(int size) {
            return new ToDo[size];
        }
    };


}
