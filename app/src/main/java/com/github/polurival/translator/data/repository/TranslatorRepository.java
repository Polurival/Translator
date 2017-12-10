package com.github.polurival.translator.data.repository;

import com.github.polurival.translator.TranslatorApplication;
import com.github.polurival.translator.business.model.TranslateModel;
import com.github.polurival.translator.business.model.YandexTranslateRequestModel;
import com.github.polurival.translator.business.model.YandexTranslateResponseModel;
import com.github.polurival.translator.business.repository.ITranslatorRepository;
import com.github.polurival.translator.data.db.TranslatorDatabase;
import com.github.polurival.translator.data.db.Word;
import com.github.polurival.translator.data.network.YandexTranslatorApiService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * @author Polurival on 19.11.2017.
 */

public class TranslatorRepository implements ITranslatorRepository {

    @Inject
    YandexTranslatorApiService yandexTranslatorApiService;

    @Inject
    TranslatorDatabase translatorDatabase;

    public TranslatorRepository() {
        TranslatorApplication.getApplicationComponent().inject(this);
    }

    @Override
    public Single<YandexTranslateResponseModel> getTranslate(TranslateModel translateModel) {
        YandexTranslateRequestModel requestModel = new YandexTranslateRequestModel(translateModel);
        return yandexTranslatorApiService.getTranslate(requestModel.toMap());
    }

    @Override
    public Flowable<List<TranslateModel>> getSavedWords(String languageFrom) {
        return translatorDatabase.wordDao().loadWordsByLanguage(languageFrom)
                .flatMap(this::mapToTranslateModel);
    }

    @Override
    public void saveWord(TranslateModel translateModel) {
        Word word = new Word(translateModel);
        translatorDatabase.wordDao().insertAll(word);
    }

    private Flowable<List<TranslateModel>> mapToTranslateModel(List<Word> words) {
        final List<TranslateModel> translateModelWords = new ArrayList<>();
        for (Word word : words) {
            final TranslateModel translateModel = new TranslateModel(word.getLanguage(), "", word.getWord());
            translateModelWords.add(translateModel);
        }
        return Flowable.fromArray(translateModelWords);
    }
}
