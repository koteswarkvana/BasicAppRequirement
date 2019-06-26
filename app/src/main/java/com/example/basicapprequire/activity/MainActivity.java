package com.example.basicapprequire.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.basicapprequire.R;
import com.example.basicapprequire.fragments.FirstFragment;
import com.example.basicapprequire.fragments.SecondFragment;
import com.example.basicapprequire.fragments.ThirdFragment;

import java.util.List;
import java.util.Vector;

// Showing steepers with previous and next button action.
// Showing dots as per selection based on view pager position.
public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private PagerAdapter mPagerAdapter;

    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    ViewPager pager;
    Button btNext;
    Button btPrevious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initialisePaging();
        pager_indicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);
        btNext = (Button) findViewById(R.id.bt_next);
        btPrevious = (Button) findViewById(R.id.bt_previous);
        setPageViewIndicator();
        btNext.setOnClickListener(this);
        btPrevious.setOnClickListener(this);
    }

    /**
     * Initialise the fragments to be paged
     */
    private void initialisePaging() {

        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, FirstFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, SecondFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, ThirdFragment.class.getName()));
        this.mPagerAdapter = new PagerAdapter(super.getSupportFragmentManager(), fragments);
        //
        pager = (ViewPager) super.findViewById(R.id.viewpager);
        pager.setAdapter(this.mPagerAdapter);
        pager.setOnPageChangeListener(this);
    }

    private void setPageViewIndicator() {

        Log.d("###setPageViewIndicator", " : called");
        dotsCount = mPagerAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            final int presentPosition = i;
            dots[presentPosition].setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    pager.setCurrentItem(presentPosition);
                    return true;
                }

            });


            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("###onPageSelected, pos ", String.valueOf(position));
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
        }
        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));

        if (position + 1 == dotsCount) {

        } else {

        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    private int getItem(int i) {
        return pager.getCurrentItem() + i;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Stepper forward next screen
            case R.id.bt_next:
                pager.setCurrentItem(getItem(+1), true);
                break;
            // Stepper back previous screen
            case R.id.bt_previous:
                pager.setCurrentItem(getItem(-1), true);
                break;
        }
    }

    class PagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments;

        public PagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }

        // Showing page as per our requirement it can compose.
        @Override
        public float getPageWidth(int position) {
            return 1.0f;
        }
    }
}
