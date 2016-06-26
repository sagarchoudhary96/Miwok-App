package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 24-06-2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    //Resource id for background color of list
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // check if the current view is reused else inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //get the object located at position
        Word word_item = getItem(position);

        //find the textview in list_item with id default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        //gets the default Translation and set it to the text of this textView
        defaultTextView.setText(word_item.getDefaultTranslation());

        //find the textview in list_item with id miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        //gets the miwok Translation and set it to the text of this textView
        miwokTextView.setText(word_item.getMiwokTranslation());

        //find the image view with id image
        ImageView mImageView = (ImageView) listItemView.findViewById(R.id.image);
        if(word_item.hasImage()) {

            //get the imageResource get and set it as source of the image view
            mImageView.setImageResource(word_item.getImageResourceId());

            //make the image view visible
            mImageView.setVisibility(View.VISIBLE);
        }
        else {
            mImageView.setVisibility(View.GONE);
        }

        //seach for the view with the give id
        View textContainer = listItemView.findViewById(R.id.text_container);

        // set its backgroung resource to the mColorResourceId
        textContainer.setBackgroundResource(mColorResourceId);

        return listItemView;
    }
}
