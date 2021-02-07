package me.bungeecore.nick;

import lombok.Getter;
import me.bungeecore.nick.api.NickApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.concurrent.TimeUnit;

@Getter
public class NickClient {

    private NickApi nickApi;

    public NickClient() {

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(chain -> chain.proceed(chain.request().newBuilder().addHeader("x-api-key", "6a9ZdXeBYeen3MGHM9An2aBzCv").build())).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:7482/api/service/")
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create()).build();

        this.nickApi = retrofit.create(NickApi.class);
    }
}