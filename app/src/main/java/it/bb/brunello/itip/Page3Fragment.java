package it.bb.brunello.itip;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Page3Fragment extends Fragment {
   
   public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

      if (container == null) {
         return null;
      }
      View view = (LinearLayout)inflater.inflate(R.layout.page3,container,false);

      return view;
   }
   
   // set text helper function
   public void setText(String totale, String totalePers) {

      TextView lblTotale = (TextView) getView().findViewById(R.id.lblTotale);
      TextView lblTotalePers = (TextView) getView().findViewById(R.id.lblTotalePers);

      lblTotale.setText(totale);
      lblTotalePers.setText(totalePers);
   } 
   
}