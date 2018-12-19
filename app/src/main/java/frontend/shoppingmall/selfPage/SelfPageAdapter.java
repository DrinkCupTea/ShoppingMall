package frontend.shoppingmall.selfPage;

import android.content.Context;
import android.renderscript.Script;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import frontend.shoppingmall.R;

public class SelfPageAdapter extends ArrayAdapter {
    private final int resourceId;
    public SelfPageAdapter(Context context, int textViewResource, List<SelfSetting> objects){
        super(context,textViewResource,objects);
        resourceId = textViewResource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        SelfSetting set = (SelfSetting) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView icon = view.findViewById(R.id.settingImage);
        TextView name = view.findViewById(R.id.settingName);
        icon.setImageResource(set.getImageId());
        name.setText(set.getContent());
        return view;
    }
}
