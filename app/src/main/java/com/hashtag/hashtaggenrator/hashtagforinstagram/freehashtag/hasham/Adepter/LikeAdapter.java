package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Adepter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity.BioActivity;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity.EyeActivity;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;

import java.util.List;

import static android.content.Context.CLIPBOARD_SERVICE;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.Maincontex;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.likedbio;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.sharepref;

public class LikeAdapter extends BaseAdapter {

    List<String> classicbio;
    LikeAdapter likeAdapter = this;

    public LikeAdapter(List<String> likedbio) {
        classicbio = likedbio;
    }

    @Override
    public int getCount() {
        return classicbio.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView ==  null) {
            convertView = LayoutInflater.from(utils.heartconterx).inflate(R.layout.liked_layout, parent, false);
        }
        TextView textView;
        textView = convertView.findViewById(R.id.biotext);

        ImageView delete = convertView.findViewById(R.id.delete);
        ImageView copy = convertView.findViewById(R.id.copy);
        ImageView eye = convertView.findViewById(R.id.eye);
        ImageView share = convertView.findViewById(R.id.share);
        ImageView edit = convertView.findViewById(R.id.edit);
        textView.setText(classicbio.get(position));

        final String bio = textView.getText().toString();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("sapata","delete");

                likedbio.remove(position);
                sharepref(Maincontex);
                Toast.makeText(Maincontex, "Deleted !", Toast.LENGTH_SHORT).show();
                likeAdapter.notifyDataSetChanged();

            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("sapata","copy");
                
                ClipboardManager clipboard = (ClipboardManager) utils.heartconterx.getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("", bio);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(utils.heartconterx, "Hashtag Copied", Toast.LENGTH_SHORT).show();
            }
        });
        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("sapata","eye");
                utils.heartconterx.startActivity(new Intent(utils.heartconterx, EyeActivity.class));
                utils.biotext = bio;

            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("sapata","share");

                String shareBody = bio;
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                utils.heartconterx.startActivity(Intent.createChooser(sharingIntent, "Share Hashtag Using"));
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("sapata","edit");

                utils.biotext = bio;
                utils.heartconterx.startActivity(new Intent(utils.heartconterx, BioActivity.class));
                utils.editflag = 1;
            }
        });
        return convertView;
    }
}
