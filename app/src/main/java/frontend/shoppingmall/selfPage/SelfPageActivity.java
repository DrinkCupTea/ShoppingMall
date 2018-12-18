package frontend.shoppingmall.selfPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import frontend.shoppingmall.R;
import frontend.shoppingmall.TranslucentStatusBar;
import frontend.shoppingmall.homePage.HomePageActivity;
import frontend.shoppingmall.messagePage.MessaegPageActivity;
import frontend.shoppingmall.shopsPage.ShopsPageActivity;

public class SelfPageActivity extends AppCompatActivity {
    private ImageButton toHome,toShop,toMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_page);
        toHome = findViewById(R.id.selfToHome);
        toShop = findViewById(R.id.selfToShop);
        toMessage = findViewById(R.id.selfToMessage);
        setListener();
    }

    private void setListener(){
        SelfPageActivity.OnClick onClick = new SelfPageActivity.OnClick();
        toHome.setOnClickListener(onClick);
        toShop.setOnClickListener(onClick);
        toMessage.setOnClickListener(onClick);
    }
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.selfToHome:
                    intent = new Intent(SelfPageActivity.this,HomePageActivity.class);
                    break;
                case R.id.selfToShop:
                    intent = new Intent(SelfPageActivity.this,ShopsPageActivity.class);
                    break;
                case R.id.selfToMessage:
                    intent = new Intent(SelfPageActivity.this,MessaegPageActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SelfPageActivity.this,HomePageActivity.class);
        startActivity(intent);
    }
}
