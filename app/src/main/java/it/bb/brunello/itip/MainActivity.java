package it.bb.brunello.itip;

import java.util.List;
import java.util.Vector;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends FragmentActivity {

    static List<Fragment> fragments = new Vector<Fragment>();

    private PagerAdapter mPagerAdapter;
    private ViewPager mPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // creating fragments and adding to list
        fragments.add(Fragment.instantiate(this,Page1Fragment.class.getName()));
        fragments.add(Fragment.instantiate(this,Page2Fragment.class.getName()));
        fragments.add(Fragment.instantiate(this,Page3Fragment.class.getName()));

        // creating adapter and linking to view pager
        this.mPagerAdapter = new PagerAdapter(super.getSupportFragmentManager(),fragments);
        mPager = (ViewPager) super.findViewById(R.id.pager);
        mPager.setAdapter(this.mPagerAdapter);
    }

    public static Fragment getFrag(int frag)
    {
        return fragments.get(frag);
    }
}

