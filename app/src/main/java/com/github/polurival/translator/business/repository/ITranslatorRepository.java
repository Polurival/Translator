package com.github.polurival.translator.business.repository;

import com.github.polurival.translator.business.model.YandexTranslateRequestModel;
import com.github.polurival.translator.business.model.YandexTranslateResponseModel;

import io.reactivex.Single;

/**
 * @author Polurival on 19.11.2017.
 */

public interface ITranslatorRepository {

    Single<YandexTranslateResponseModel> getTranslate(YandexTranslateRequestModel requestModel);
}
