package com.assignmentapps.Pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Android Dev on 7/27/2017.
 */

public class Data {

    @SerializedName("success")
    boolean success;
    @SerializedName("message")
    String messageString;

    public boolean isSuccess(){
        return success;
    }

    public String getMessage() {
        return messageString;
    }
}

