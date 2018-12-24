package frontend.shoppingmall.parkingPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import frontend.shoppingmall.R;
import frontend.shoppingmall.homePage.HomePageActivity;

public class ParkingHomeActivity extends AppCompatActivity {
    private Button btn1,btnRetrun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);
        btn1 = findViewById(R.id.btn_parking_home);
        btnRetrun = findViewById(R.id.btn_parking_return_1);
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
                case R.id.btn_parking_return_1:
                    intent = new Intent(ParkingHomeActivity.this,HomePageActivity.class);
                    break;
                case R.id.btn_parking_home:
                    intent = new Intent(ParkingHomeActivity.this,ParkingActivity.class);
                    break;
            }
            startActivity(intent);
            ParkingHomeActivity.this.finish();
        }
    }
}
