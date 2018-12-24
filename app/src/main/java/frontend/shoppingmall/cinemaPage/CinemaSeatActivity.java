package frontend.shoppingmall.cinemaPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import frontend.shoppingmall.R;
import frontend.shoppingmall.ScanActivity;
import frontend.shoppingmall.homePage.HomePageActivity;
import frontend.shoppingmall.messagePage.MessaegPageActivity;

public class CinemaSeatActivity extends AppCompatActivity {
    private Button btnRetrun,btnFace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema_seat);
        btnRetrun = findViewById(R.id.btn_cinema_seat_return);
        btnFace = findViewById(R.id.btn_cinema_return_2);
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
                case R.id.btn_cinema_seat_return:
                    intent = new Intent(CinemaSeatActivity.this,CinemaActivity.class);
                    break;
                case R.id.btn_cinema_return_2:
                    intent = new Intent(CinemaSeatActivity.this,ScanActivity.class);
                    break;
            }
            startActivity(intent);
            CinemaSeatActivity.this.finish();
        }
    }
}
