package frontend.shoppingmall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import frontend.shoppingmall.R;
import frontend.shoppingmall.cinemaPage.CinemaActivity;
import frontend.shoppingmall.cinemaPage.CinemaSeatActivity;
import frontend.shoppingmall.homePage.HomePageActivity;
import frontend.shoppingmall.messagePage.MessaegPageActivity;

public class ScanActivity extends AppCompatActivity {

    private ImageView mIvScan;
    private Button btn;
    /**
     * 0:从上往下 1:从下往上
     */
    Animation mTop2Bottom, mBottom2Top;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        mIvScan = findViewById(R.id.scan_line);
        btn = findViewById(R.id.btn_face);

        mTop2Bottom = new TranslateAnimation(TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f, TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.7f);

        mBottom2Top = new TranslateAnimation(TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f, TranslateAnimation.RELATIVE_TO_PARENT, 0.7f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f);

        mBottom2Top.setRepeatMode(Animation.RESTART);
        mBottom2Top.setInterpolator(new LinearInterpolator());
        mBottom2Top.setDuration(1500);
        mBottom2Top.setFillEnabled(true);//使其可以填充效果从而不回到原地
        mBottom2Top.setFillAfter(true);//不回到起始位置
        //如果不添加setFillEnabled和setFillAfter则动画执行结束后会自动回到远点
        mBottom2Top.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mIvScan.startAnimation(mTop2Bottom);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mTop2Bottom.setRepeatMode(Animation.RESTART);
        mTop2Bottom.setInterpolator(new LinearInterpolator());
        mTop2Bottom.setDuration(1500);
        mTop2Bottom.setFillEnabled(true);
        mTop2Bottom.setFillAfter(true);
        mTop2Bottom.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mIvScan.startAnimation(mBottom2Top);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mIvScan.startAnimation(mTop2Bottom);
        setListener();
    }
    private void setListener(){
        OnClick onClick = new OnClick();
        btn.setOnClickListener(onClick);

    }
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_face:
                    intent = new Intent(ScanActivity.this,HomePageActivity.class);
                    break;
            }
            ToastCustom.makeText(getApplicationContext(),ScanActivity.this,"识别成功！",ToastCustom.LENGTH_SHORT).show();

            startActivity(intent);
        }
    }
}
