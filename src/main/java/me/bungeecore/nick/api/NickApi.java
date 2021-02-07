package me.bungeecore.nick.api;

import me.bungeecore.nickserver.model.nick.Nick;
import me.bungeecore.nickserver.model.nick.NickPlayer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

import java.util.UUID;

public interface NickApi {

    @GET("status/")
    Call<String> status();

    @GET("nick/get/uuid/")
    Call<NickPlayer> getNickPlayer(@Query("uuid") UUID uuid);

    @GET("nick/get/nick/uuid/")
    Call<NickPlayer> getNickPlayerWithNickUUID(@Query("nickUUID") UUID nickUUID);

    @GET("nick/get/nickInfo/uuid/")
    Call<Nick> getNickname(@Query("uuid") UUID uuid);

    @GET("nick/info/isNicked/")
    Call<Boolean> isNicked(@Query("uuid") UUID uuid);

    @GET("nick/info/isNetworkNick/")
    Call<Boolean> isNetworkNick(@Query("uuid") UUID uuid);

    @GET("nick/info/isNickedAndIsNetworkNick/")
    Call<Boolean> isNickedAndIsNetworkNick(@Query("uuid") UUID uuid);

    @PUT("nick/nick/")
    Call<NickPlayer> nick(@Query("uuid") UUID uuid);

    @PUT("nick/nickWithRank/")
    Call<NickPlayer> nick(@Query("uuid") UUID uuid, @Query("rank") String rank);

    @PUT("nick/networkNick/")
    Call<NickPlayer> networkNick(@Query("uuid") UUID uuid);

    @PUT("nick/networkNickWithRank/")
    Call<NickPlayer> networkNick(@Query("uuid") UUID uuid, @Query("rank") String rank);

    @PUT("nick/unnick/")
    Call<UUID> unnick(@Query("uuid") UUID uuid);
}
