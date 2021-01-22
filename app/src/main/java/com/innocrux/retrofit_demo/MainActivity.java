package com.innocrux.retrofit_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=findViewById(R.id.textview);

        // retrofitbuilder intialisation

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //we need now api instance for interface and by this we call Api class INTERFACE


        MyAPICall myAPICall=retrofit.create(MyAPICall.class);


         //calling an api call method and get data from api-interface

        Call<DataModel> call  = myAPICall.getData() ;

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {

                if(response.code()!=200){

                    textView1.setText("Check the Connection");
                    return;
                }

                // go get the data in text view
                //now data in all format of string we can parse it 1 single string for this example

                String Jsony="";
                Jsony="Id= "+ response.body().getId()+"\nUserId="+response.body().getTitle()+
                        "\nTitle="+response.body().getTitle()+"\nCompleted="+response.body().isCompleted();

                 textView1.append(Jsony);


            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });




    }
}