package frontend.shoppingmall.messagePage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import frontend.shoppingmall.R;
import frontend.shoppingmall.TranslucentStatusBar;
import frontend.shoppingmall.homePage.HomePageActivity;
import frontend.shoppingmall.selfPage.SelfPageActivity;
import frontend.shoppingmall.shopsPage.ShopsPageActivity;

public class MessaegPageActivity extends AppCompatActivity {
    private List<Contacts> contactsList = new ArrayList<Contacts>();
    private ImageButton toHome,toShop,toSelf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaeg_page);
//        TranslucentStatusBar.translucentStatusBar(MessaegPageActivity.this, true);
        initContacts();
        MessageAdapter adapter = new MessageAdapter(MessaegPageActivity.this,R.layout.message_contacts_layout,contactsList);
        ListView listView = findViewById(R.id.messageListView);
        listView.setAdapter(adapter);
        toHome = findViewById(R.id.messageToHome);
        toShop = findViewById(R.id.messageToShop);
        toSelf = findViewById(R.id.messageToSelf);
        setListener();
    }

    private void initContacts(){
        Contacts shop1 = new Contacts(getResources().getString(R.string.shop_001),getResources().getString(R.string.shopMessage_001),getResources().getString(R.string.shopTime_001),R.drawable.shop1_0);
        Contacts shop2 = new Contacts(getResources().getString(R.string.shop_002),getResources().getString(R.string.shopMessage_002),getResources().getString(R.string.shopTime_002),R.drawable.shop2_0);
        Contacts shop3 = new Contacts(getResources().getString(R.string.shop_003),getResources().getString(R.string.shopMessage_003),getResources().getString(R.string.shopTime_003),R.drawable.shop3_0);
        contactsList.add(shop1);
        contactsList.add(shop2);
        contactsList.add(shop3);
    }

    private void setListener(){
        MessaegPageActivity.OnClick onClick = new MessaegPageActivity.OnClick();
        toHome.setOnClickListener(onClick);
        toShop.setOnClickListener(onClick);
        toSelf.setOnClickListener(onClick);
    }
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.messageToHome:
                    intent = new Intent(MessaegPageActivity.this,HomePageActivity.class);
                    break;
                case R.id.messageToShop:
                    intent = new Intent(MessaegPageActivity.this,ShopsPageActivity.class);
                    break;
                case R.id.messageToSelf:
                    intent = new Intent(MessaegPageActivity.this,SelfPageActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MessaegPageActivity.this,HomePageActivity.class);
        startActivity(intent);
    }
}
