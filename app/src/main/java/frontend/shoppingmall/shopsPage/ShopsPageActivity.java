package frontend.shoppingmall.shopsPage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import frontend.shoppingmall.R;
import frontend.shoppingmall.TranslucentStatusBar;

public class ShopsPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops_page);
        TranslucentStatusBar.translucentStatusBar(ShopsPageActivity.this,true);

    }
}
