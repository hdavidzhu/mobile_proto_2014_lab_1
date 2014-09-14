package com.hdavidzhu.projectwithfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MyFragment extends Fragment {
    public MyFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_my, container, false);
        final ListView myListView = (ListView) rootView.findViewById(R.id.my_list_view);
        final EditText text = (EditText) rootView.findViewById(R.id.my_edit_text);

        final ArrayList<String> listChats = new ArrayList<String>();
        listChats.add("hogi");
        listChats.add("asdads");
        listChats.add("zxczxvzvsxcv");
        listChats.add("asdasdasd");
        listChats.add("asdasdasda");
        final ChatAdapter adapter = new ChatAdapter(getActivity(), R.layout.chat_item,
                listChats
        );
        myListView.setAdapter(adapter);

        Button myButton = (Button) rootView.findViewById(R.id.my_submit_button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = text.getText().toString();

                listChats.add(value);
                adapter.notifyDataSetChanged();
                myListView.setSelection(listChats.size()-1);
            }
        });

        return rootView;
    }
}