package frontend.shoppingmall.homePage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import frontend.shoppingmall.R;
import frontend.shoppingmall.TranslucentStatusBar;
import frontend.shoppingmall.goodsPage.GoodsPageActivity;
import frontend.shoppingmall.shopsPage.ShopsPageActivity;


public class HomePageActivity extends Activity {

    private ImageButton toshop,togoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        TranslucentStatusBar.translucentStatusBar(HomePageActivity.this,true);

        toshop = findViewById(R.id.toShopPage);
        togoods = findViewById(R.id.toGoodPage);
        setListener();
    }

    private void setListener(){
        OnClick onClick = new OnClick();
        toshop.setOnClickListener(onClick);
        togoods.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.toShopPage:
                    intent = new Intent(HomePageActivity.this,ShopsPageActivity.class);
                    break;
                case R.id.toGoodPage:
                    intent = new Intent(HomePageActivity.this,GoodsPageActivity.class);
                    break;

            }
            startActivity(intent);
        }
    }

}
