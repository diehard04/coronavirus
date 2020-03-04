package com.diehard04.coronavirus.ui.world;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.diehard04.coronavirus.R;

public class WorldFragment extends Fragment {

    private WorldViewModel worldViewModel;
    private WebView webView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        worldViewModel =
                ViewModelProviders.of(this).get(WorldViewModel.class);
        View root = inflater.inflate(R.layout.fragment_world, container, false);
        return root;
    }
}