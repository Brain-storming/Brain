package com.example.alex.bs.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.alex.bs.R;

/**
 * Created by alex on 2015/5/18.
 */
public class TabPersonalFragment extends Fragment {

    private LinearLayout linearlayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        linearlayout = (LinearLayout)inflater.inflate(R.layout.fragment_tab_personal,container,false);

        return linearlayout;
    }
}
