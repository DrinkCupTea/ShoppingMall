package frontend.shoppingmall.guidePage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import frontend.shoppingmall.R;
import frontend.shoppingmall.guidePage.fragment.StepOneFragment;
import frontend.shoppingmall.guidePage.fragment.StepThreeFragment;
import frontend.shoppingmall.guidePage.fragment.StepTwoFragment;
import frontend.shoppingmall.homePage.HomePageActivity;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private GuidePageAdapter mPageAdapter;
    private List<Fragment> mFragments;
    private LinearLayout mDotLayout;
    private ImageView[] dots;
    private int currentIndex;

    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.guide_view_pager);
        mDotLayout = (LinearLayout) findViewById(R.id.dots_layout);
    }

    private void initData() {

        mFragments = new ArrayList<Fragment>();
        mFragments.add(StepOneFragment.newInstance());
        mFragments.add(StepTwoFragment.newInstance());
        mFragments.add(StepThreeFragment.newInstance());
        mPageAdapter = new GuidePageAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mPageAdapter);
    }

    private void initListeners() {

        mViewPager.addOnPageChangeListener(this);
    }

    private void initDots() {

        dots = new ImageView[mFragments.size()];
        for (int i = 0; i < mFragments.size(); i++) {
            dots[i] = (ImageView) mDotLayout.getChildAt(i);
            if (i != 0) {
                dots[i].setImageResource(R.drawable.ic_circle_dot);
            }
        }
        currentIndex = 0;
        dots[currentIndex].setImageResource(R.drawable.ic_rect_dot);
    }

    private void setCurrentDot(int position) {

        if (position < 0 || position > mFragments.size() - 1
                || currentIndex == position) {
            return;
        }
        dots[position].setImageDrawable(null);
        dots[position].setImageResource(R.drawable.ic_rect_dot);
        dots[currentIndex].setImageDrawable(null);
        dots[currentIndex].setImageResource(R.drawable.ic_circle_dot);
        currentIndex = position;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        getSupportActionBar().hide();
        initView();
        initData();
        initDots();
        initListeners();
    }

    // 当前页面被滑动时调用
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    // 当新的页面被选中时调用
    @Override
    public void onPageSelected(int position) {

        // 设置底部小点选中状态
        setCurrentDot(position);
    }

    // 当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int state) {

    }

}