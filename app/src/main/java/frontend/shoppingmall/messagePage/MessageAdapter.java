package frontend.shoppingmall.messagePage;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import frontend.shoppingmall.R;
import frontend.shoppingmall.messagePage.Contacts;

public class MessageAdapter extends ArrayAdapter {
    private final int resourceId;
    public MessageAdapter(Context context, int textViewResource, List<Contacts> objects){
        super(context,textViewResource,objects);
        resourceId = textViewResource;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        Contacts contacts = (Contacts) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView contactImage = (ImageView) view.findViewById(R.id.contacts_image);
        TextView contactName = (TextView) view.findViewById(R.id.contacts_name);
        TextView contactMessage = (TextView) view.findViewById(R.id.contacts_message);
        TextView contactTime = (TextView) view.findViewById(R.id.contacts_time);
        contactImage.setImageResource(contacts.getImageId());
        contactName.setText(contacts.getName());
        contactMessage.setText(contacts.getMessage());
        contactTime.setText(contacts.getTime());
        return view;
    }
}
