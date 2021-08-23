package com.example.testfinerio.ui.login;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testfinerio.R;
import com.example.testfinerio.api.ApiAdapter;
import com.example.testfinerio.interfaces.ApiService;
import com.example.testfinerio.model.LoginResponse;
import org.json.JSONException;
import org.json.JSONObject;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.testfinerio.ui.custom.AlertDialogs;
import com.example.testfinerio.ui.perfil.ProfileActivity;
import com.example.testfinerio.utils.NetworkChangeReceiver;

public class LoginActivity extends AppCompatActivity {
    private NetworkChangeReceiver networkChangeReceiver;
    private EditText edCorreo;
    private EditText edPass;
    private Button btnLogin;
    private String user;
    private String pass;
    private  LoginResponse loginResponse;
    AlertDialogs alertDialogs;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edCorreo = findViewById(R.id.activity_login_ed_correo);
        edPass = findViewById(R.id.activity_login_ed_pass);
        btnLogin = findViewById(R.id.activity_login_btn_entrar);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNetwork();
            }
        });
        edCorreo.setText("maximo_piu18@hotmail.com");
        edPass.setText("Pscw42s1");

    }

    public void servicioRest() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", user);
            jsonObject.put("password", pass);
        }
        catch (JSONException e){
            Log.e("error", "error" +e);
        }


        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), String.valueOf((jsonObject)));
        ApiService apiService = ApiAdapter.getInstance().create(ApiService.class);
        Call<LoginResponse> call = apiService.getLoginResponse(body);
        alertDialogs = new AlertDialogs();
        alertDialogs.dialogCustomDownload(this);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.code()==200){
                    loginResponse = new LoginResponse();
                    loginResponse = response.body();
                    openProfile();
                }
                else{
                    alertDialogs.dialogHideCustomDownload();
                    alertDialogs.dialogCustomButtonAccept(LoginActivity.this, "!Sesion Incorrecta¡", "Usuario y/o Contaseñas incorrectas");
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("error", "error" + t);
            }
        });

    }

    public void openProfile(){
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("loginResponse", loginResponse);
        startActivity(intent);
        finish();
    }
    public void checkNetwork(){
        networkChangeReceiver = new NetworkChangeReceiver();
        if(networkChangeReceiver.isOnline(this)){
            if(!edCorreo.getText().toString().isEmpty() && !edPass.getText().toString().isEmpty()) {
                user = edCorreo.getText().toString();
                pass = edPass.getText().toString();
                servicioRest();
            }
            else {
                Toast.makeText(LoginActivity.this, "Ingrese correo y contraseña", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this, "No tienes conexión a internet", Toast.LENGTH_SHORT).show();
        }
    }
}
