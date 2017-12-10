package com.github.polurival.translator.business.repository;

import com.github.polurival.translator.business.model.TranslateModel;
import com.github.polurival.translator.business.model.YandexTranslateResponseModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * @author Polurival on 19.11.2017.
 */

public interface ITranslatorRepository {

    Single<YandexTranslateResponseModel> getTranslate(TranslateModel translateModel);

    Flowable<List<TranslateModel>> getSavedWords(String languageFrom);

    void saveWord(TranslateModel responseModel);
}
