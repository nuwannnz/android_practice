package com.example.practice1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageAdapter extends BaseAdapter {

    private ArrayList<Message> itemList = new ArrayList<Message>();
    private Context context;

    public MessageAdapter(ArrayList<Message> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.itemList.size();
    }

    @Override
    public Message getItem(int i) {
        return this.itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.message_list_item, viewGroup, false);
        }

        ((TextView) view.findViewById(R.id.titleID)).setText(getItem(i).getSubject());
        ((TextView) view.findViewById(R.id.subID)).setText(getItem(i).getMsg());

        return view;
    }


}
