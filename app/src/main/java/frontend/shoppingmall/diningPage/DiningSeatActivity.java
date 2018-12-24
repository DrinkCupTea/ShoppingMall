package frontend.shoppingmall.diningPage;

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
import frontend.shoppingmall.messagePage.MessaegPageActivity;

public class DiningSeatActivity extends AppCompatActivity {
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
                    intent = new Intent(DiningSeatActivity.this,DiningRoomActivity.class);
                    break;
                case R.id.btn_cinema_return_2:
                    intent = new Intent(DiningSeatActivity.this,ScanActivity.class);
                    break;
            }
            startActivity(intent);
            DiningSeatActivity.this.finish();
        }
    }
}
