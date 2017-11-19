package com.github.polurival.translator.business.model;

import android.support.annotation.NonNull;

import com.github.polurival.translator.business.model.TranslateModel;
import com.github.polurival.translator.data.network.YandexTranslatorApiConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Модель запроса для перевода текста на заданный язык.
 * <br><a href="https://tech.yandex.ru/translate/doc/dg/reference/translate-docpage/">Документация</a>
 *
 * @author Polurival on 15.11.2017.
 */

public class YandexTranslateRequestModel {

    /**
     * API-ключ
     */
    private String key = YandexTranslatorApiConstants.API_KEY;

    /**
     * переводимый текст
     */
    private String text;

    /**
     * направление перевода
     */
    private String lang;

    public YandexTranslateRequestModel(TranslateModel translateModel) {
        this.text = translateModel.getText();
        this.lang = translateModel.getFromLanguageTo();
    }

    @NonNull
    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        map.put("text", text);
        map.put("lang", lang);
        return map;
    }
}
