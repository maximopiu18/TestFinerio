package com.example.testfinerio.ui.perfil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testfinerio.R;
import com.example.testfinerio.api.ApiAdapter;
import com.example.testfinerio.interfaces.ApiService;
import com.example.testfinerio.model.LoginResponse;
import com.example.testfinerio.model.ProfileResponse;
import com.example.testfinerio.ui.custom.AlertDialogs;
import com.example.testfinerio.ui.login.LoginActivity;
import com.example.testfinerio.ui.movements.MovementsActivity;
import com.example.testfinerio.utils.NetworkChangeReceiver;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    TextView tvId;
    TextView tvAccountExpired;
    TextView tvAccountLocked;
    TextView tvCustomerId;
    TextView tvDateCreated;
    TextView tvEmail;
    TextView tvEnable;
    TextView tvLastUpdate;
    TextView tvName;
    TextView tvNotificationsEnabled;
    TextView tvPasswordExpired;
    TextView tvSignupCredentialEmailSent;
    TextView tvSignupCredentialPushSent;
    TextView tvSignupEmailSent;
    TextView tvSignupFrom;
    TextView tvTermsAndConditionsAccepted;
    TextView tvType;
    TextView tvFinerioCode;
    TextView tvHasNewTerms;
    Button btnMovimientos;
    LoginResponse loginResponse;
    ProfileResponse profileResponse;
    private NetworkChangeReceiver networkChangeReceiver;
    AlertDialogs alertDialogs;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvId = findViewById(R.id.activity_profile_tv_id);
        tvAccountExpired = findViewById(R.id.activity_profile_tv_accountExpired);
        tvAccountLocked = findViewById(R.id.activity_profile_tv_accountLocked);
        tvCustomerId = findViewById(R.id.activity_profile_tv_customerId);
        tvDateCreated = findViewById(R.id.activity_profile_tv_dateCreated);
        tvEmail = findViewById(R.id.activity_profile_tv_email);
        tvEnable = findViewById(R.id.activity_profile_tv_enabled);
        tvLastUpdate = findViewById(R.id.activity_profile_tv_lastUpdated);
        tvName = findViewById(R.id.activity_profile_tv_name);
        tvNotificationsEnabled = findViewById(R.id.activity_profile_tv_notificationsEnabled);
        tvPasswordExpired = findViewById(R.id.activity_profile_tv_passwordExpired);
        tvSignupCredentialEmailSent = findViewById(R.id.activity_profile_tv_signupEmailSent);
        tvSignupCredentialPushSent = findViewById(R.id.activity_profile_tv_signupCredentialPushSent);
        tvSignupEmailSent = findViewById(R.id.activity_profile_tv_signupEmailSent);
        tvSignupFrom = findViewById(R.id.activity_profile_tv_signupFrom);
        tvTermsAndConditionsAccepted = findViewById(R.id.activity_profile_tv_termsAndConditionsAccepted);
        tvType = findViewById(R.id.activity_profile_tv_type);
        tvFinerioCode = findViewById(R.id.activity_profile_tv_finerioCode);
        tvHasNewTerms = findViewById(R.id.activity_profile_tv_hasNewTerms);

        btnMovimientos = findViewById(R.id.activity_profile_btn_movimientos);
        btnMovimientos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMovements();
            }
        });
        alertDialogs = new AlertDialogs();
        initGetData();


    }
    public void initGetData(){
        if(getIntent().hasExtra("loginResponse")){
            loginResponse = (LoginResponse) getIntent().getExtras().getSerializable("loginResponse");
            checkNetwork();
        }
    }

    public void servicioRest() {

        alertDialogs.dialogCustomDownload(this);
        String bearer = "Bearer " + loginResponse.getAccess_token();
        ApiService apiService = ApiAdapter.getInstance().create(ApiService.class);
        Call<ProfileResponse> call = apiService.getProfileResponse(bearer);

        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                Log.e("Response", "response: " + response.body().getId());
               profileResponse = new ProfileResponse();
                profileResponse = response.body();
                setValuesProfile();
                alertDialogs.dialogHideCustomDownload();
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Log.e("error", "error" + t);
            }
        });

    }

    public void setValuesProfile(){
        tvId.setText("id: "+profileResponse.getId());
        tvAccountExpired.setText("Account Expirated: " + profileResponse.isAccountExpired());
        tvAccountLocked.setText("Account Locked: " + profileResponse.isAccountLocked());
        tvCustomerId.setText("CustomerID: " + profileResponse.getCustomerId());
        tvDateCreated.setText("DateCreated: " + profileResponse.getDateCreated());
        tvEmail.setText("Email: " + profileResponse.getEmail());
        tvEnable.setText("enable: " + profileResponse.isEnabled());
        tvLastUpdate.setText("LastUpdate: " + profileResponse.getLastUpdated());
        tvName.setText("Name: " + profileResponse.getName());
        tvNotificationsEnabled.setText("NotificationsEnable: " + profileResponse.isNotificationsEnabled());
        tvPasswordExpired.setText("PasswordExpirated: " + profileResponse.isPasswordExpired());
        tvSignupEmailSent.setText("SignupEmalSend: " + profileResponse.isSignupEmailSent());
        tvSignupCredentialPushSent.setText("SignupCredentialsPushSend: " + profileResponse.isSignupCredentialPushSent());
        tvSignupCredentialEmailSent.setText("SignuoCredentialsEmailSend: " + profileResponse.isSignupCredentialPushSent());
        tvSignupFrom.setText("SignupFrom: " + profileResponse.getSignupFrom());
        tvTermsAndConditionsAccepted.setText("TErmsAndConditionsAccepted: " + profileResponse.isTermsAndConditionsAccepted());
        tvType.setText("type: " + profileResponse.getType());
        tvFinerioCode.setText("finerioCode: " + profileResponse.getFinerioCode());
        tvHasNewTerms.setText("HasNewTerms: " + profileResponse.isHasNewTerms());

    }
    public  void openMovements(){
        Intent intent = new Intent(this, MovementsActivity.class);
        intent.putExtra("bearer", loginResponse.getAccess_token());
        intent.putExtra("profileResponse", profileResponse);
        startActivity(intent);
    }

    public void checkNetwork(){
        networkChangeReceiver = new NetworkChangeReceiver();
        if(networkChangeReceiver.isOnline(this)) {
            servicioRest();
        }
        else{
            Toast.makeText(this, "No tienes conexión a internet", Toast.LENGTH_SHORT).show();
        }
    }
}
