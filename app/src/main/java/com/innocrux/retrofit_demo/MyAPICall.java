package com.innocrux.retrofit_demo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPICall {

    //

    // https://run.mocky.io/v3/26051376-dfd1-4f45-8719-8e0ca65e95e3

    //(  https://run.mocky.io/ --base url)

    //

    // json reference in url-----v3/26051376-dfd1-4f45-8719-8e0ca65e95e3(Relative or variable url)

    //

    // using a get method and assign them with the json url ---ie ----after the first slash
    @GET("v3/26051376-dfd1-4f45-8719-8e0ca65e95e3")

    // calling a method Call method which is in the DataModel style

    Call<DataModel> getData();


}
