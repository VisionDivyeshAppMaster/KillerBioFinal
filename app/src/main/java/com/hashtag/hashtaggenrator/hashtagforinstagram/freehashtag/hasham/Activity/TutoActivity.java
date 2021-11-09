package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.setbiofragment.five;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.setbiofragment.four;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.setbiofragment.one;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.setbiofragment.six;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.setbiofragment.three;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.setbiofragment.two;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;

public class TutoActivity extends AppCompatActivity {

    Button done,next;
    Toolbar mToolbar;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuto);

            init();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Log.e("sapata","Tutorial Activity");


        pager = (ViewPager) findViewById(R.id.viewPagertuto);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //viewPager.setCurrentItem((utils.counter -1), true);
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem((utils.counter +1), true);

                if(utils.counter ==5){
                    next.setVisibility(View.GONE);
                    done.setVisibility(View.VISIBLE);
                }
            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                utils.counter = position;
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });



    }

    private void init() {

        done=findViewById(R.id.donebutton);
        next=findViewById(R.id.nextbutton);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {

            switch (pos) {
                case 0:
                    return new one();
                case 1:
                    return new two();
                case 2:
                    return new three();
                case 3:
                    return new four();
                case 4:
                    return new five();
                case 5:
                    return new six();
                default:
                    return new one();
            }
        }
        @Override
        public int getCount() {
            return 6;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}