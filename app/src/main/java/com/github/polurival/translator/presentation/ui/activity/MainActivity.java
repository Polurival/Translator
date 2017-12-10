package com.github.polurival.translator.presentation.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.github.polurival.translator.R;
import com.github.polurival.translator.business.model.TranslateModel;
import com.github.polurival.translator.presentation.mvp.presenter.MainPresenter;
import com.github.polurival.translator.presentation.mvp.view.MainView;
import com.github.polurival.translator.presentation.ui.adapter.WordAdapter;

import java.util.List;

/**
 * @author Polurival on 13.11.2017.
 */

public class MainActivity extends MvpAppCompatActivity implements MainView {

    public static final String LANGUAGE_FROM = "ru"; //todo добавить вьюхи для выбора языка
    public static final String LANGUAGE_TO = "en";

    @InjectPresenter
    MainPresenter presenter;

    private AutoCompleteTextView wordsForTranslateView;
    private Button translateButton;
    TextView translatedWordsView;
    ProgressBar progressBar;

    WordAdapter wordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordsForTranslateView = findViewById(R.id.autoCompleteTextView);
        wordAdapter = new WordAdapter(getApplicationContext());

        translatedWordsView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progress);

        initTranslateButton();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.subscribeWordsLoading(LANGUAGE_FROM);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unsubscribeWordsLoading();
    }

    @Override
    public void setLanguageFrom(String languageFrom) {

    }

    @Override
    public void setLanguageTo(String languageTo) {

    }

    @Override
    public void setTranslate(String word) {
        translatedWordsView.setText(word);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, getString(R.string.some_error) + error, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void updateAdapter(List<TranslateModel> words) {
        wordAdapter.setWords(words);
        wordsForTranslateView.setAdapter(wordAdapter);
    }

    private void initTranslateButton() {
        translateButton = findViewById(R.id.button);
        translateButton.setOnClickListener((view) -> {
            final String text = wordsForTranslateView.getText().toString();
            final TranslateModel dataForTranslate = new TranslateModel(LANGUAGE_FROM, LANGUAGE_TO, text);
            presenter.getTranslate(dataForTranslate);
        });
    }
}
