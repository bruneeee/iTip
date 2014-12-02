package it.bb.brunello.itip;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Page1Fragment extends Fragment {

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        View view = (LinearLayout)inflater.inflate(R.layout.page1,container,false);

        return view;
    }
}