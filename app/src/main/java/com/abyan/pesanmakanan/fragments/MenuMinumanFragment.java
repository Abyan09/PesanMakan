package com.abyan.pesanmakanan.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abyan.pesanmakanan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuMinumanFragment extends Fragment {

    public MenuMinumanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_minuman, container, false);

        return view;
    }

}
