package com.example.testfinerio.ui.movements;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testfinerio.R;
import com.example.testfinerio.api.ApiAdapter;
import com.example.testfinerio.interfaces.ApiService;
import com.example.testfinerio.model.MovementsResponse;
import com.example.testfinerio.model.ProfileResponse;
import com.example.testfinerio.ui.custom.AlertDialogs;
import com.example.testfinerio.ui.movements.adapter.AdapterMovements;
import com.example.testfinerio.utils.NetworkChangeReceiver;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovementsActivity extends AppCompatActivity {
    int cont1 =0;
    int cont2 =0;
    boolean isRefresh = false;
    int totalItems =0;
    int maxItemsDownload =10;
    ImageView imgBack;
    String bearerHeader;
    ProfileResponse profileResponse;
    RecyclerView recyclerView;
    AdapterMovements adapterMovements;
    MovementsResponse movementsResponse;
    private NetworkChangeReceiver networkChangeReceiver;
    AlertDialogs alertDialogs;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movements);
        imgBack = findViewById(R.id.activity_movements_img_back);
        recyclerView = findViewById(R.id.activity_movements_recycler_movimientos);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        alertDialogs = new AlertDialogs();
        if(getIntent().hasExtra("bearer")&&getIntent().hasExtra("profileResponse")){
            bearerHeader = getIntent().getExtras().getString("bearer");
            profileResponse = (ProfileResponse) getIntent().getExtras().getSerializable("profileResponse");
            checkNetwork();
        }
    }

    public void servicioRest() {

        alertDialogs.dialogCustomDownload(this);
        String bearer = "Bearer " + bearerHeader;
        ApiService apiService = ApiAdapter.getInstance().create(ApiService.class);
        Call<MovementsResponse> call = apiService.getListMovements(bearer, profileResponse.getId(), true, maxItemsDownload);

        call.enqueue(new Callback<MovementsResponse>() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onResponse(Call<MovementsResponse> call, Response<MovementsResponse> response) {
                movementsResponse = response.body();
                initRecyclerView();
            }

            @Override
            public void onFailure(Call<MovementsResponse> call, Throwable t) {
                Log.e("error", "error" + t);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void initRecyclerView(){
        adapterMovements = new AdapterMovements(movementsResponse.getMovements(), this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapterMovements);
        alertDialogs.dialogHideCustomDownload();
        if(isRefresh){
            recyclerView.smoothScrollToPosition(totalItems-2);
            isRefresh = false;
        }
        listenerRecyclerScroll();
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
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void listenerRecyclerScroll(){
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager= LinearLayoutManager.class.cast(recyclerView.getLayoutManager());
                int totalItemCount = layoutManager.getItemCount();
                int lastVisible = layoutManager.findLastVisibleItemPosition();
                totalItems = totalItemCount;
                cont1 = totalItemCount;
                if (totalItemCount-1 == lastVisible) {
                    if(!isRefresh){
                        if(cont1<= cont2){
                            // no recargar
                        }
                        else{
                            maxItemsDownload = maxItemsDownload+10;
                            cont2 = cont2+10;
                            adapterMovements = null;
                            isRefresh = true;
                            checkNetwork();
                        }

                    }

                }
            }
        });
    }
}
