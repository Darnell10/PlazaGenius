package com.example.plazagenius;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.plazagenius.models.PostResponse;
import com.example.plazagenius.networking.ApiUtil;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewUser extends AppCompatActivity {

    PostResponse post;

    private final String TAG = "RESPONSE";


    EditText nameInput;


    EditText jobInput;


    Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        nameInput = findViewById(R.id.name_input);
        jobInput = findViewById(R.id.job_input);
        createButton = findViewById(R.id.button);


        String name = nameInput.getText().toString();
        String job = jobInput.getText().toString();

        post = new PostResponse(name, job);

        setCreateButton();


    }

    public void postMethod() {


        ApiUtil.getApiService().createPost(post).enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {

                int result = response.code();

                if (!response.isSuccessful()) {
                    return;
                }


                PostResponse postResponse = response.body();

                Log.e(TAG, String.valueOf(result));

                String content = postResponse.getId();


                Toast.makeText(NewUser.this, "New User ID: " + content,
                        Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {

                t.printStackTrace();

            }
        });

    }

    public void setCreateButton() {

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                postMethod();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name",nameInput.getText().toString());
        outState.putString("job",jobInput.getText().toString());
    }

}
