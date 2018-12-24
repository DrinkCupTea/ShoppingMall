package frontend.shoppingmall.childPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import frontend.shoppingmall.R;
import frontend.shoppingmall.ScanActivity;
import frontend.shoppingmall.cinemaPage.CinemaActivity;
import frontend.shoppingmall.cinemaPage.CinemaSeatActivity;
import frontend.shoppingmall.homePage.HomePageActivity;

public class ChildActivity extends AppCompatActivity {
    private Button btnRetrun,btnFace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        btnRetrun = findViewById(R.id.btn_child_return);
        btnFace = findViewById(R.id.btn_child);
        setListener();
    }
    private void setListener(){
        OnClick onClick = new OnClick();
        btnRetrun.setOnClickListener(onClick);
        btnFace.setOnClickListener(onClick);
    }
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_child_return:
                    intent = new Intent(ChildActivity.this,HomePageActivity.class);
                    break;
                case R.id.btn_child:
                    intent = new Intent(ChildActivity.this,ScanActivity.class);
                    break;
            }
            startActivity(intent);
            ChildActivity.this.finish();
        }
    }
}
