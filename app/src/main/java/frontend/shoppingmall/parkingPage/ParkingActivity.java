package frontend.shoppingmall.parkingPage;

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

public class ParkingActivity extends AppCompatActivity {
    private Button btn1,btnRetrun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_final);
        btn1 = findViewById(R.id.btn_parking_join);
        btnRetrun = findViewById(R.id.btn_parking_return_2);
        setListener();

    }
    private void setListener(){
        OnClick onClick = new OnClick();
        btnRetrun.setOnClickListener(onClick);
        btn1.setOnClickListener(onClick);
    }
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_parking_return_2:
                    intent = new Intent(ParkingActivity.this,ParkingHomeActivity.class);
                    break;
                case R.id.btn_parking_join:
                    intent = new Intent(ParkingActivity.this,ScanActivity.class);
                    break;
            }
            startActivity(intent);
            ParkingActivity.this.finish();
        }
    }
}
