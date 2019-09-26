package com.example.plazagenius;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.plazagenius.controller.GP_Adapter;
import com.example.plazagenius.models.Data;
import com.example.plazagenius.models.UserResponse;
import com.example.plazagenius.networking.ApiUtil;
import com.example.plazagenius.networking.PlazaService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RETROFIT";

    private PlazaService plazaService;

    RecyclerView recyclerView;

    FloatingActionButton floatingActionButton;

    private List<Data> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.genius_rv);

        floatingActionButton = findViewById(R.id.fab);

        plazaService = ApiUtil.getApiService();

        retrofitCall();

        setFloatingActionButton();

    }


    public void retrofitCall() {

        plazaService.getUsers(12).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                UserResponse userResponse = response.body();

                Log.e(TAG, userResponse.getData().get(0).combineName());

                users = userResponse.getData();

                setRecyclerView(users);

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

                t.printStackTrace();

            }
        });
    }

    public void setRecyclerView(List<Data> dataModel) {
        recyclerView = findViewById(R.id.genius_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()
                , LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new GP_Adapter(dataModel));

    }

    public void setFloatingActionButton() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent newUserIntent = new Intent(MainActivity.this, NewUser.class);
                startActivity(newUserIntent);
            }
        });
    }
}
