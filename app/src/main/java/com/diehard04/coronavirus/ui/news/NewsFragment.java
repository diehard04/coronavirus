package com.diehard04.coronavirus.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.diehard04.coronavirus.R;

/**
 * Created by DIPAK on 3/4/2020.
 */
public class NewsFragment extends Fragment {
    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news, container, false);
        webView = root.findViewById(R.id.webview);
        final TextView textView = root.findViewById(R.id.text_dashboard);

        webView.loadUrl("https://www.journaldev.com");
        return root;
    }
}
