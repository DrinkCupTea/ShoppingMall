package frontend.shoppingmall.goodsPage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import frontend.shoppingmall.R;
import frontend.shoppingmall.TranslucentStatusBar;

public class GoodsPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_page);
        TranslucentStatusBar.translucentStatusBar(GoodsPageActivity.this,true);


    }
}
