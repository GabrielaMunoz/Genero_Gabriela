package com.example.sistemas.asuntosgenero.api;

import com.example.sistemas.asuntosgenero.models.Genero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sistemas on 13/10/17.
 */

public interface DatosApi {
    @GET("6xwp-race.json")
    Call<List<Genero>> obtenerListaGenero();
    //@GET("6xwp-race.json")
    //Call<GeneroRespuesta> obtenerListaGenero();

}
