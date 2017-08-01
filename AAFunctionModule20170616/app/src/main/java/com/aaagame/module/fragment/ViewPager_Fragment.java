package com.aaagame.module.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aaagame.module.R;

public class ViewPager_Fragment extends Fragment {
    int position;
    public void setPosition(int position) {
        this.position = position;
    }

    public ViewGroup rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_view_pager_, container, false);
        Integer[] colors={R.color.blue500,R.color.purple500,R.color.green500,R.color.amber500,R.color.deeporange500};
        rootView.setBackgroundColor(ContextCompat.getColor(getActivity(),colors[position]));
        return rootView;
    }
}
