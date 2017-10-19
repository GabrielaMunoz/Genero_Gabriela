package com.example.sistemas.asuntosgenero;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.sistemas.asuntosgenero.api.DatosApi;
import com.example.sistemas.asuntosgenero.models.Genero;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AsuntosGenero extends AppCompatActivity {


    private static final String TAG = "GENERO";

    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private ListaGeneroAdapter listaGeneroAdapter;

    private boolean aptoParaCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asuntos_genero);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaGeneroAdapter = new ListaGeneroAdapter(this);
        recyclerView.setAdapter(listaGeneroAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;
                            obtenerDatos();
                        }
                    }
                }
            }
        });


        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        aptoParaCargar = true;
        obtenerDatos();
    }

    private void obtenerDatos() {
        DatosApi service = retrofit.create(DatosApi.class);
        Call<List<Genero>> generoRespuestaCall = service.obtenerListaGenero();

        generoRespuestaCall.enqueue(new Callback<List<Genero>>() {
            @Override
            public void onResponse(Call<List<Genero>> call, Response<List<Genero>> response) {
                aptoParaCargar = true;
                if (response.isSuccessful()) {

                    ArrayList<Genero> generoRespuesta = (ArrayList<Genero>) response.body();
                    listaGeneroAdapter.adicionarListaPokemon(generoRespuesta);

                } else {
                    Log.e(TAG, " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Genero>> call, Throwable t) {
                aptoParaCargar = true;
                Log.e(TAG, " onFailure: " + t.getMessage());
            }
        });
    }
}

