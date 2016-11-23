package com.oakraw.testmimicproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    @InjectView(R.id.email)
    EditText emailEditText;
    @InjectView(R.id.password)
    EditText passwordEditText;
    @InjectView(R.id.email_sign_in_button)
    Button emailSignInButton;

    private APIService apiService;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        apiService = new APIService();

        emailEditText.setText("Dum.rong");
        passwordEditText.setText("1234");
    }


    @OnClick(R.id.email_sign_in_button)
    public void onClick() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        showLoading();

        apiService.login(email, password, new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    showMessage(response.body().toString());
                    if(response.body().status){
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                }else{
                    showMessage(response.message());
                }
                hideLoading();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                showMessage(t.getMessage());
                hideLoading();
            }
        });
    }

    private void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showLoading(){
        progressDialog = ProgressDialog.show(this, null, "Logging in...", true);
    }

    private void hideLoading(){
        if(progressDialog != null)
            progressDialog.dismiss();
    }
}

