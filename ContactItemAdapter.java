package com.example.apolymoxic.smsreply;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class ContactItemAdapter extends ArrayAdapter<ContactItem> {

    public ContactItemAdapter(Context context, int resource, List<ContactItem> itemList) {
        super(context, resource, itemList);
    }

    public View getView(int position, View view, ViewGroup parent) {

        if(view == null) {
            LayoutInflater layoutInflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // using customized layout
            view = layoutInflater.inflate(R.layout.contact_item, null);
        }

        // step 1: retrieve the data
        ContactItem item = getItem(position);

        // step 2: show the data on the UI
        if(item != null) {
            // get the id
            Integer idValue = item.getId();

            // get the title
            String contactString = item.getContact();

            // get the content
            String messageString = item.getMessage();

            // define the views
            TextView contactText   = (TextView) view.findViewById(R.id.contact);
            TextView messageText = (TextView) view.findViewById(R.id.message);
            TextView idText      = (TextView) view.findViewById(R.id.itemID);

            // set the views
            idText.setText(idValue.toString());
            contactText.setText(contactString);
            messageText.setText(messageString);
        }

        return view;
    }

}
