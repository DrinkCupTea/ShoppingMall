package frontend.shoppingmall.homePage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import frontend.shoppingmall.R;
import frontend.shoppingmall.TranslucentStatusBar;


public class HomePageActivity extends AppCompatActivity {

//    private ImageButton toshop,togoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        TranslucentStatusBar.translucentStatusBar(HomePageActivity.this,true);

//        toshop = findViewById(R.id.toShopPage);
//        togoods = findViewById(R.id.toGoodPage);
//        setListener();
    }

//    private void setListener(){
//        OnClick onClick = new OnClick();
//        toshop.setOnClickListener(onClick);
//        togoods.setOnClickListener(onClick);
//    }

//    class OnClick implements View.OnClickListener {
//
//        @Override
//        public void onClick(View v) {
//            Intent intent = null;
//            switch (v.getId()){
//                case R.id.toShopPage:
//                    intent = new Intent(HomePageActivity.this,ShopsPageActivity.class);
//                    break;
//                case R.id.toGoodPage:
//                    intent = new Intent(HomePageActivity.this,GoodsPageActivity.class);
//                    break;
//
//            }
//            startActivity(intent);
//        }
//    }

}
