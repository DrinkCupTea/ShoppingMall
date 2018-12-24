package frontend.shoppingmall.shopsPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import frontend.shoppingmall.R;
import frontend.shoppingmall.TranslucentStatusBar;
import frontend.shoppingmall.homePage.HomePageActivity;
import frontend.shoppingmall.messagePage.MessaegPageActivity;
import frontend.shoppingmall.selfPage.SelfPageActivity;

public class ShopsPageActivity extends AppCompatActivity {
    private ImageButton toHome,toMessage,toSelf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops_page);
//        TranslucentStatusBar.translucentStatusBar(ShopsPageActivity.this,true);
        toHome = findViewById(R.id.shopToHome);
        toMessage = findViewById(R.id.shopToMessage);
        toSelf = findViewById(R.id.shopToSelf);
        setListener();
    }
    private void setListener(){
        ShopsPageActivity.OnClick onClick = new ShopsPageActivity.OnClick();
        toHome.setOnClickListener(onClick);
        toMessage.setOnClickListener(onClick);
        toSelf.setOnClickListener(onClick);
    }
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.shopToHome:
                    intent = new Intent(ShopsPageActivity.this,HomePageActivity.class);
                    break;
                case R.id.shopToMessage:
                    intent = new Intent(ShopsPageActivity.this,MessaegPageActivity.class);
                    break;
                case R.id.shopToSelf:
                    intent = new Intent(ShopsPageActivity.this,SelfPageActivity.class);
                    break;
            }
            startActivity(intent);
            overridePendingTransition(0, 0);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ShopsPageActivity.this,HomePageActivity.class);
        startActivity(intent);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
