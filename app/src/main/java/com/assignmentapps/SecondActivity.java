package com.assignmentapps;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.assignmentapps.Interrface.ApiInterface;
import com.assignmentapps.Pojo.Data;
import com.assignmentapps.Pojo.User;
import com.assignmentapps.Retrofit.RetrofitApiClient;
import com.assignmentapps.SharedPreferences.Preference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {
         TextView emailET,passwordET;
    private ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        emailET=(EditText)findViewById(R.id.email);
        passwordET=(EditText)findViewById(R.id.password);
        apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);

    }


    public void Login(View view) {
        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        String tag="login";
        String email,password;
        email=emailET.getText().toString();
        password=passwordET.getText().toString();
        User user=new User();
        user.setEmail(email);
        user.setTag(tag);
        user.setPassword(password);
        CheckUserLogin(user);


    }

    public void CheckUserLogin(User userCredential){
        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();

        Call<Data> call = apiInterface.getUserValidity(userCredential);

        call.enqueue(new Callback<Data>() {

            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Log.d("response:"+","+"Response" ,response.message().toString());

                Data data = response.body();
                saveinfo();

                String message=data.getMessage().toString();
                Intent intent = new Intent(SecondActivity.this, Dashboard.class);
                intent.putExtra("message", message);
                startActivity(intent);
               // Toast.makeText(getApplicationContext(), data.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
              //  Log.e(TAG, t.toString());
            }
        });

    }
    public void saveinfo(){
        User user=new User();
        Preference p=new Preference();
        p.saveUserData(user.getEmail(),user.getPassword());
    }

}
