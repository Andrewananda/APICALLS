package com.example.andrew.apicallsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.andrew.apicallsapp.models.User;
import com.example.andrew.apicallsapp.models.UserDetails;
import com.example.andrew.apicallsapp.network.APIClient;
import com.example.andrew.apicallsapp.network.APIInterface;
import com.example.andrew.apicallsapp.utilities.common;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText editEmail,editPass;
    Button btnLogin,btnSignUp;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        editEmail = findViewById(R.id.editEmail);
        editPass = findViewById(R.id.editPass);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDetails();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(s);
            }
        });
    }

    private void checkDetails(){
        if(editEmail.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(),"Enter Email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(!common.isEmailValid(editEmail.getText().toString().trim())){
            Toast.makeText(getApplicationContext(),"Enter correct email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(editPass.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_SHORT).show();
            return;
        }

        if(!common.isNetworkAvailable(this)){
            Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_SHORT).show();
            return;
        }else{
            //make network call

            /**
             login user
             **/
            Call<UserDetails> call1 = apiInterface.loginUser("test@gmail.com","secret");
            call1.enqueue(new Callback<UserDetails>() {
                @Override
                public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
                    Log.d("******",response.body().toString());
                    UserDetails user1 = response.body();

                    if(user1.getStatus() == "success"){
                        //save state to shared preferences
                        //login user to home screen
                        Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(i);
                        finish();

                    }else{
                        Toast.makeText(getApplicationContext(), "Wrong credentials", Toast.LENGTH_SHORT).show();

                    }


                }

                @Override
                public void onFailure(Call<UserDetails> call, Throwable t) {
                    call.cancel();
                }
            });

        }

    }


}
