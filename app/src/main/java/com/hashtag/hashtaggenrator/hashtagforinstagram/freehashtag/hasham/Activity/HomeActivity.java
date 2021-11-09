package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity;

import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.yolo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Adepter.recyclemodel;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Search_Fragment;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.intuit.sdp.BuildConfig;
import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private MoPubInterstitial mInterstitial;

    BottomNavigationView bottomNavigation;
    public static ImageView sex,submit;
    public static GridView recyclerView;
    recyclemodel adapter;
    public static EditText inputsearch;
    public static TextView text;
    public static boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fainalmain);

        // for interstitial
        SdkConfiguration sdkConfigurationInterstitals = new SdkConfiguration.Builder("24534e1901884e398f1253216226017e").build();
        MoPub.initializeSdk(this, sdkConfigurationInterstitals, initSdkListener());

        mInterstitial = new MoPubInterstitial(this, "24534e1901884e398f1253216226017e");
        mInterstitial.setInterstitialAdListener(new MoPubInterstitial.InterstitialAdListener() {
            @Override
            public void onInterstitialLoaded(MoPubInterstitial moPubInterstitial) {
                moPubInterstitial.show();
                mInterstitial = moPubInterstitial;
                Log.d("TAG", "onInterstitialLoaded: ");
            }

            @Override
            public void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode) {
                Log.d("TAG", "onInterstitialFailed: ");
            }

            @Override
            public void onInterstitialShown(MoPubInterstitial moPubInterstitial) {
                Log.d("TAG", "onInterstitialShown: ");
            }

            @Override
            public void onInterstitialClicked(MoPubInterstitial moPubInterstitial) {
                Log.d("TAG", "onInterstitialClicked: ");
            }

            @Override
            public void onInterstitialDismissed(MoPubInterstitial moPubInterstitial) {
                Log.d("TAG", "onInterstitialDismissed: ");
            }
        });
        mInterstitial.load();
        // MoPub interstitial over

        utils.maincontext = getApplicationContext();
        text = findViewById(R.id.text);
        Log.e("sapata","Main Activity");

        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(Color.BLACK);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        init();
        recyclerView = findViewById(R.id.classicrec);
        recyclerView.setNestedScrollingEnabled(true);
        adapter = new recyclemodel(utils.carshash);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(getApplicationContext(), BioActivity.class));

                    utils.biotext = String.valueOf(utils.carshash.get(position));
                Log.e("TTTT","Mi---tag>"+ utils.biotext);
            }
        });

        sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setVisibility(View.GONE);
                sex.setVisibility(View.GONE);
                submit.setVisibility(View.GONE);
                inputsearch.setVisibility(View.VISIBLE);

                check = true;

                inputsearch.requestFocus();
                utils.key(getApplicationContext());

                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new Search_Fragment());
                fragmentTransaction.commit();

                inputsearch.addTextChangedListener(new TextWatcher() {

                    @Override
                    public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                        // When user changed the Text
                       Search_Fragment.adapter.getFilter().filter(cs);
                    }

                    @Override
                    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                                  int arg3) {
                    }

                    @Override
                    public void afterTextChanged(Editable arg0) {
                    }
                });


            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Submit Click", Toast.LENGTH_SHORT).show();

                try {

                    startActivity(new Intent(getApplicationContext(), com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity.submit.class));

                }catch (Exception e){

                    Log.d("TAG", "onClick: ");
                }

               // startActivity(new Intent(getApplicationContext(), SubmitedActivity.class));

            }
        });

        yolo(getApplicationContext());
        utils.Maincontex = getApplicationContext();

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_heart) {
                    Intent i = new Intent(getApplicationContext(), heart.class);
                    startActivity(i);
                    return true;
                }else if (item.getItemId() == R.id.nav_saved) {
                    Intent j = new Intent(getApplicationContext(), saved.class);
                    startActivity(j);
                }
                else if (item.getItemId() == R.id.nav_submit) {
                    Intent k = new Intent(getApplicationContext(), SubmitedActivity.class);
                    startActivity(k);
                }
                return true;
            }
        });
    }

    private SdkInitializationListener initSdkListener() {
        return new SdkInitializationListener() {
            @Override
            public void onInitializationFinished() {

            }
        };
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_share) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
            String shareMessage = getResources().getString(R.string.app_name) + "\n" + "Let me recommend you this application\n\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID;
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } else if (id == R.id.nav_rateus) {
            Intent new_intent = Intent.createChooser(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID)), "Share via");
            new_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(new_intent);
        }else if(id == R.id.about_us){
            Intent aboutus = new Intent(getApplicationContext(), Aboutus.class);
            startActivity(aboutus);
        }
        else if (id == R.id.nav_tuto) {
            Intent l = new Intent(getApplicationContext(), TutoActivity.class);
            startActivity(l);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void init() {

        sex = findViewById(R.id.sex);
        submit = findViewById(R.id.submit);

        inputsearch = findViewById(R.id.inputSearch);

        bottomNavigation = findViewById(R.id.bottom_navigation);

    }

    @Override
    public void recreate()
    {
            startActivity(getIntent());
            finish();
    }
}