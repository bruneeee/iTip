package it.bb.brunello.itip;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Page2Fragment extends Fragment {

    private float conto,mancia,persone;
    private float tip = 10;

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        // fragment not when container null
        if (container == null) {
            return null;
        }
        View view = (LinearLayout) inflater.inflate(R.layout.page2, container, false);

        EditText txtConto = (EditText) view.findViewById(R.id.txtConto);
        EditText txtPersone = (EditText) view.findViewById(R.id.txtPersone);
        final EditText txtMancia = (EditText) view.findViewById(R.id.txtMancia);

        RadioGroup rg = (RadioGroup) view.findViewById(R.id.rgTip);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Check which radio button was clicked
                switch (checkedId) {
                    case R.id.rb10:
                        setTip(10);
                        break;
                    case R.id.rb15:
                        setTip(15);
                        break;
                    case R.id.rb20:
                        setTip(20);
                        break;
                    case R.id.rbPers:
                        if(!txtMancia.getText().toString().isEmpty())
                            setTip(Float.parseFloat(txtMancia.getText().toString()));
                        else
                            setTip(0);
                        break;
                }

            }
        });


        txtConto.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        aggiorna();
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
        txtPersone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                aggiorna();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

    public float getconto()
    {
        EditText txtConto = (EditText) getView().findViewById(R.id.txtConto);
        if(!txtConto.getText().toString().isEmpty())
        {
            return Float.parseFloat(txtConto.getText().toString());
        }
        return 100;
    }

    public int getPersone()
    {
        EditText txtPersone = (EditText) getView().findViewById(R.id.txtPersone);
        if(!txtPersone.getText().toString().isEmpty())
        {
            return Integer.parseInt(txtPersone.getText().toString());
        }
        return 1;
    }

    public float getMancia()
    {
        TextView lblMancia = (TextView) getView().findViewById(R.id.lblValMancia);
        mancia = (getconto()/100)*tip;
        String mancia = String.format("Mancia: %.2f", (getconto()/100)*tip);
        lblMancia.setText(mancia);

        return (conto/100)*tip;
    }

    private void aggiorna()
    {
        Page3Fragment f3 = (Page3Fragment) MainActivity.getFrag(2);
        View v3 = f3.getView();

        if (v3 != null) {
            conto = getconto();
            persone = getPersone();
            mancia = getMancia();

            String tot = String.format("Totale: %.2f €", conto + mancia);
            String totPers = String.format("Totale per Persona: %.2f €", (conto + mancia) / persone);
            f3.setText(tot, totPers);
        }

    }

    public void setTip(float tip)
    {
        this.tip = tip;
        Log.w("Tip","tipChange");
        aggiorna();
    }
}