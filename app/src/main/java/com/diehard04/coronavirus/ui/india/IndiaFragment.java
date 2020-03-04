package com.diehard04.coronavirus.ui.india;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.diehard04.coronavirus.R;

public class IndiaFragment extends Fragment {

    private IndiaViewModel indiaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        indiaViewModel =
                ViewModelProviders.of(this).get(IndiaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_india, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        indiaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}