package frontend.shoppingmall.homePage;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import frontend.shoppingmall.R;
import frontend.shoppingmall.TranslucentStatusBar;
import frontend.shoppingmall.childPage.ChildActivity;
import frontend.shoppingmall.cinemaPage.CinemaActivity;
import frontend.shoppingmall.diningPage.DiningRoomActivity;
import frontend.shoppingmall.messagePage.MessaegPageActivity;
import frontend.shoppingmall.parkingPage.ParkingHomeActivity;
import frontend.shoppingmall.selfPage.SelfPageActivity;
import frontend.shoppingmall.shopsPage.ShopsPageActivity;


public class HomePageActivity extends AppCompatActivity implements OnBannerListener {
    private Banner banner;
    private ArrayList<Drawable> list_path;
    private ArrayList<String> list_title;
    private ImageButton toShop,toMessage,toSelf;
    private ImageButton iV1,iV2,iV3,iV4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
//        TranslucentStatusBar.translucentStatusBar(HomePageActivity.this, true);
        initView();

        toShop = findViewById(R.id.homeToShop);
        toMessage = findViewById(R.id.homeToMessage);
        toSelf = findViewById(R.id.homeToSelf);
        iV1 = findViewById(R.id.btn_home_parking);
        iV2 = findViewById(R.id.btn_home_dining);
        iV3 = findViewById(R.id.btn_home_cinema);
        iV4 = findViewById(R.id.btn_home_child);
        setListener();

        EditText search = findViewById(R.id.homeSearchBar);
        Drawable drawable = getDrawable(R.drawable.search_icon);
        drawable.setBounds(0,0,40,40);
        search.setCompoundDrawables(drawable,null,null,null);
    }
    //轮播图的代码开始
    private void initView() {
        banner = (Banner) findViewById(R.id.homePageSlide);
        //放图片地址的集合
        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();

        list_path.add(getResources().getDrawable(R.drawable.ad_001));
        list_path.add(getResources().getDrawable(R.drawable.ad_002));
        list_path.add(getResources().getDrawable(R.drawable.ad_003));
        list_title.add("微星电脑");
        list_title.add("送福利！");
        list_title.add("过年大吉！");

        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new HomePageActivity.MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();
    }
    //轮播图的监听方法
    @Override
    public void OnBannerClick(int position) {
        Log.i("tag", "你点了第"+position+"张轮播图");
    }
    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
//            Glide.with(context).load((String) path).into(imageView);
            imageView.setImageDrawable((Drawable) path);
        }
    }
    //轮播图的代码结束
    private void setListener(){
        OnClick onClick = new OnClick();
        toShop.setOnClickListener(onClick);
        toMessage.setOnClickListener(onClick);
        toSelf.setOnClickListener(onClick);
        iV1.setOnClickListener(onClick);
        iV2.setOnClickListener(onClick);
        iV3.setOnClickListener(onClick);
        iV4.setOnClickListener(onClick);
    }
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.homeToShop:
                    intent = new Intent(HomePageActivity.this,ShopsPageActivity.class);
                    break;
                case R.id.homeToMessage:
                    intent = new Intent(HomePageActivity.this,MessaegPageActivity.class);
                    break;
                case R.id.homeToSelf:
                    intent = new Intent(HomePageActivity.this,SelfPageActivity.class);
                    break;
                case R.id.btn_home_parking:
                    intent = new Intent(HomePageActivity.this,ParkingHomeActivity.class);
                    break;
                case R.id.btn_home_dining:
                    intent = new Intent(HomePageActivity.this,DiningRoomActivity.class);
                    break;
                case R.id.btn_home_cinema:
                    intent = new Intent(HomePageActivity.this,CinemaActivity.class);
                    break;
                case R.id.btn_home_child:
                    intent = new Intent(HomePageActivity.this,ChildActivity.class);
                    break;
            }
            startActivity(intent);
            overridePendingTransition(0, 0);
            HomePageActivity.this.finish();
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
