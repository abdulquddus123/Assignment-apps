package com.assignmentapps.Interrface;

import com.assignmentapps.Pojo.Data;
import com.assignmentapps.Pojo.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Android Dev on 7/27/2017.
 */

public interface ApiInterface {
    @POST("scarecrow/json.php")
    Call<Data> getUserValidity(@Body User userLoginCredential);

}
