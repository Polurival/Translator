package com.github.polurival.translator.data.network;

import com.github.polurival.translator.business.model.YandexTranslateResponseModel;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * @author Polurival on 15.11.2017.
 */

public interface YandexTranslatorApiService {

    @POST("/api/v1.5/tr.json/translate")
    Single<YandexTranslateResponseModel> getTranslate(@QueryMap Map<String, String> map);
}
