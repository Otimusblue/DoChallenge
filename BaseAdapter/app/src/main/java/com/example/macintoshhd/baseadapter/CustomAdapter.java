package com.example.macintoshhd.baseadapter;

import android.content.Context;
import android.provider.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Person> mPeople;

    public CustomAdapter(Context context, ArrayList<Person> people) {
        mContext = context;
        mPeople = people;
    }

    @Override
    public int getCount() {
        return mPeople.size();
    }

    @Override
    public Object getItem(int position) {
        return mPeople.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Inflate the layout for each row
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.custom_layout),parent,false);
        }
        //Get current item to be displayed.
        Person currentPerson = (Person) getItem(position);
        


        return convertView;
    }
}
