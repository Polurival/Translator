package com.github.polurival.translator.presentation.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.github.polurival.translator.business.model.TranslateModel;

import java.util.List;

/**
 * @author Польщиков Юрий.
 */

public class WordAdapter extends ArrayAdapter<String> {

    List<TranslateModel> words;

    public void setWords(List<TranslateModel> translateModel) {
        words = translateModel;
        notifyDataSetChanged();
    }

    public void addWord(TranslateModel translateModel) {
        words.add(translateModel);
        notifyDataSetChanged();
    }

    public WordAdapter(@NonNull Context context) {
        super(context, android.R.layout.simple_list_item_1);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String word = words.get(position).getText();
        if (convertView != null) {
            TextView textView = convertView.findViewById(android.R.id.text1);
            textView.setText(word);
        }

        return convertView;
    }
}
