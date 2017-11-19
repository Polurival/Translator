package com.github.polurival.translator.data.repository;

import com.github.polurival.translator.TranslatorApplication;
import com.github.polurival.translator.business.model.YandexTranslateRequestModel;
import com.github.polurival.translator.business.model.YandexTranslateResponseModel;
import com.github.polurival.translator.business.repository.ITranslatorRepository;
import com.github.polurival.translator.data.network.YandexTranslatorApiService;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * @author Polurival on 19.11.2017.
 */

public class TranslatorRepository implements ITranslatorRepository {

    @Inject
    YandexTranslatorApiService yandexTranslatorApiService;

    public TranslatorRepository() {
        TranslatorApplication.getApplicationComponent().inject(this);
    }

    @Override
    public Single<YandexTranslateResponseModel> getTranslate(YandexTranslateRequestModel requestModel) {
        return yandexTranslatorApiService.getTranslate(requestModel.toMap());
    }
}
