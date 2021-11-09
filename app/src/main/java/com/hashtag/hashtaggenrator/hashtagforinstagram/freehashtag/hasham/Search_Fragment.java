package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham;


import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity.HomeActivity;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Adepter.recyclemodel;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;

public class Search_Fragment extends Fragment {


    static View view;
    private ProgressDialog pDialog;
    private ListView lv;
    public static String value;
    public static ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_sexfragment, container, false);

        lv = view.findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(utils.maincontext, R.layout.searchlist, R.id.product_name, utils.cat);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                utils.key(utils.maincontext);

                pDialog = new ProgressDialog(getActivity());
                pDialog.setMessage("Please wait...");
                pDialog.setCancelable(false);
                pDialog.show();

               value = (String)adapter.getItemAtPosition(position);
                switch (value) {
                    case "Beauty":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.beautyhash));
                        break;
                    case "Fashion":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.fashionhash));
                        break;
                    case "Gaming":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.gaminghash));
                        break;
                    case "Game":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.gaminghash));
                        break;
                    case "Gym":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.gymhash));
                        break;
                    case "Holi":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.holihash));
                        break;
                    case "MEME":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.memehash));
                        break;
                    case "Photography":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.photographyhash));
                        break;
                    case "Sports and Fitness":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.sportsfitnesshash));
                        break;
                    case "TikTok":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.tiktokhash));
                        break;
                    case "Travel":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.travelhash));
                        break;
                    case "Traveling":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.travelhash));
                        break;
                    case "Actor":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.actorshash));
                        break;
                    case "Adventure":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.adventurehash));
                        break;
                    case "Android":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.androidhash));
                        break;
                    case "Animal":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.animalshash));
                        break;
                    case "Anime":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.animeshash));
                        break;
                    case "Architecture":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.architecturehash));
                        break;
                    case "Autumn":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.autumnhash));
                        break;
                    case "Babies":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.babieshash));
                        break;
                    case "Basketball":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.basketballhash));
                        break;
                    case "Battlefield":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.battlefieldhash));
                        break;
                    case "Bike":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.bikeshash));
                        break;
                    case "Birthday":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.birthdayhash));
                        break;
                    case "Bollywood":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.bollywoodhash));
                        break;
                    case "Black and White (B&W)":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.blackandwhitehash));
                        break;
                    case "B&w":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.blackandwhitehash));
                        break;
                    case "Boxing":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.boxinghash));
                        break;
                    case "Cars":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.carshash));
                        break;
                    case "Cats":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.catshash));
                        break;
                    case "Drawing":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.drawinghash));
                        break;
                    case "Flowers":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.flowershash));
                        break;
                    case "Family":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.familyhash));
                        break;
                    case "Dancer":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.dancerhash));
                        break;
                    case "Dancing":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.dancerhash));
                        break;
                    case "Cricker":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.crickethash));
                        break;
                    case "Cricket":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.crickethash));
                        break;
                    case "Biker":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.bikeshash));
                        break;
                    case "Comedy":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.comedyhash));
                        break;
                    case "College":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.collegehash));
                        break;
                    case "Coffee":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.coffeehash));
                        break;
                    case "Coding":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.codinghash));
                        break;
                    case "Clash Royal":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.clashroyalehash));
                        break;
                    case "Clash of clans":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.clashofclanshash));
                        break;
                    case "City":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.cityhash));
                        break;
                    case "Christmas":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.christmashash));
                        break;
                    case "Food":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.foodhash));
                        break;
                    case "Foody":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.foodhash));
                        break;
                    case "Football":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.footballhash));
                        break;
                    case "Fortnite":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.fortnitehash));
                        break;
                    case "Free Fire":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.freefirehash));
                        break;
                    case "Golf":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.golfhash));
                        break;
                    case "GTA V":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.gtavhash));
                        break;
                    case "Guitar":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.guitarhash));
                        break;
                    case "Halloween":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.halloweenhash));
                        break;
                    case "HDR":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.hdrhash));
                        break;
                    case "Hockey":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.hockeyhash));
                        break;
                    case "Horse":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.horseshash));
                        break;
                    case "Jewelry":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.jewelryhash));
                        break;
                    case "Instalike":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.instalikehash));
                        break;
                    case "Makeup":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.makeuphash));
                        break;
                    case "Minecraft":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.minecrafthash));
                        break;
                    case "Money":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.moneyhash));
                        break;
                    case "Motivation":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.motivationhash));
                        break;
                    case "Movie":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.movieshash));
                        break;
                    case "Music":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.musichash));
                        break;
                    case "Photographer":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.photographerhash));
                        break;
                    case "PUBG":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.pubghash));
                        break;
                    case "Rain":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.rainhash));
                        break;
                    case "Raining":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.rainhash));
                        break;
                    case "Reading":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.readinghash));
                        break;
                    case "Running":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.runninghash));
                        break;
                    case "Skating":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.skatinghash));
                        break;
                    case "Snapchat":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.snapchathash));
                        break;
                    case "Snow":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.snowhash));
                        break;
                    case "Snowing":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.snowhash));
                        break;
                    case "Summer":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.summerhash));
                        break;
                    case "Tattoo":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.tattooshash));
                        break;
                    case "Wedding":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.weddinghash));
                        break;
                    case "Work":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.workhash));
                        break;
                    case "Yoga":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.yogahash));
                        break;
                    case "Follow":
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.followhash));
                        break;
                    default:
                        HomeActivity.recyclerView.setAdapter(new recyclemodel(utils.bollywoodhash));
                }
                view.setVisibility(View.GONE);
                HomeActivity.text.setVisibility(View.VISIBLE);
                HomeActivity.sex.setVisibility(View.VISIBLE);
                HomeActivity.submit.setVisibility(View.VISIBLE);
                HomeActivity.inputsearch.setVisibility(View.GONE);



//                pDialog.dismiss();
            new Thread(new Runnable() {
            public void run() {

                try {
                    Thread.sleep(1500);
                    pDialog.dismiss();

                    if(HomeActivity.check){
                        HomeActivity.check = false;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
//
            }
        });


        return view;
    }

}
