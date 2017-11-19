package com.github.polurival.translator.business.interactor;

import com.github.polurival.translator.TranslatorApplication;
import com.github.polurival.translator.business.model.TranslateModel;
import com.github.polurival.translator.business.model.YandexTranslateRequestModel;
import com.github.polurival.translator.business.model.YandexTranslateResponseModel;
import com.github.polurival.translator.business.repository.ITranslatorRepository;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * @author Polurival on 13.11.2017.
 */

public class TranslatorInteractor {

    @Inject
    ITranslatorRepository translatorRepository;

    public TranslatorInteractor() {
        TranslatorApplication.getApplicationComponent().inject(this);
    }

    public Single<YandexTranslateResponseModel> getTranslate(TranslateModel translateModel) {
        return translatorRepository.getTranslate(new YandexTranslateRequestModel(translateModel));
    }

    public void saveWord(String languageFrom, String word) {

    }

    public void loadWords(String languageFrom) {

    }
}
