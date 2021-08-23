package com.example.testfinerio.interfaces;

import com.example.testfinerio.model.LoginResponse;
import com.example.testfinerio.model.MovementsResponse;
import com.example.testfinerio.model.ProfileResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @POST("login")
    Call<LoginResponse> getLoginResponse(@Body RequestBody requestBody);

    @GET("me")
    Call<ProfileResponse> getProfileResponse(@Header("Authorization") String Bearer);

    @GET("users/{user_id}/movements")
    Call<MovementsResponse> getListMovements(
            @Header("Authorization") String Bearer,
            @Path(value = "user_id", encoded = true) String userId,
            @Query("includeDuplicates") boolean includeDuplicates,
            @Query("max") int max

            // TODO en el servivio principal se coloca para mostar cierta informacion pero en este caso solo es necesario incluir los duplicados en true  para mostar la lista en true
/*            @Query("max") int max,
            @Query("deep") boolean deep,
            @Query("offset") boolean offset,
            @Query("includeCharges") boolean includeCharges,
            @Query("includeDeposits") boolean includeDeposits,
            @Query("includeDuplicates") boolean includeDuplicates*/

            );
}
