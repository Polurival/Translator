package com.github.polurival.translator.business.interactor;

import com.github.polurival.translator.TranslatorApplication;
import com.github.polurival.translator.business.model.TranslateModel;
import com.github.polurival.translator.business.model.YandexTranslateResponseModel;
import com.github.polurival.translator.business.repository.ITranslatorRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
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
        return translatorRepository.getTranslate(translateModel);
    }

    public void saveWord(TranslateModel translateModel) {
        translatorRepository.saveWord(translateModel);
    }

    public Flowable<List<TranslateModel>> getSavedWords(String languageFrom) {
        return translatorRepository.getSavedWords(languageFrom);
    }
}
