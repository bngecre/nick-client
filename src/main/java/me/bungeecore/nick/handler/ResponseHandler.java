package me.bungeecore.nick.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.bungeecore.nickserver.model.exception.ApiException;
import me.bungeecore.nickserver.model.exception.ErrorBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class ResponseHandler {

    private static final Gson GSON = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

    public static <T> T handleResponse(final Call call) throws ApiException {
        try {
            final Response execute = call.execute();
            final ResponseBody errorBody = execute.errorBody();
            if(errorBody != null) {
                final ErrorBody body = GSON.fromJson(errorBody.string(), ErrorBody.class);
                throw new ApiException(body.getStatus(), body.getError(), body.getMessage());
            }
            return (T) execute.body();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ApiException(408, "Request Timeout", e.getMessage());
        }
    }
}