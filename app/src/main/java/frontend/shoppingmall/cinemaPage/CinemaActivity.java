package frontend.shoppingmall.cinemaPage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import frontend.shoppingmall.R;
import frontend.shoppingmall.homePage.HomePageActivity;
import frontend.shoppingmall.messagePage.MessaegPageActivity;

public class CinemaActivity extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);
        btn1 = findViewById(R.id.btn_cinema_1);
        btn2 = findViewById(R.id.btn_cinema_2);
        btn3 = findViewById(R.id.btn_cinema_3);
        btn4 = findViewById(R.id.btn_cinema_4);
        btn5 = findViewById(R.id.btn_cinema_5);
        btnReturn = findViewById(R.id.btn_cinema_return_1);
        setListener();
    }
    private void setListener(){
        OnClick onClick = new OnClick();
        btn1.setOnClickListener(onClick);
        btn2.setOnClickListener(onClick);
        btn3.setOnClickListener(onClick);
        btn4.setOnClickListener(onClick);
        btn5.setOnClickListener(onClick);
        btnReturn.setOnClickListener(onClick);
    }
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_cinema_return_1:
                    intent = new Intent(CinemaActivity.this,HomePageActivity.class);
                    break;
                case R.id.btn_cinema_1:
                    intent = new Intent(CinemaActivity.this,CinemaSeatActivity.class);
                    break;
                case R.id.btn_cinema_2:
                    intent = new Intent(CinemaActivity.this,CinemaSeatActivity.class);
                    break;
                case R.id.btn_cinema_3:
                    intent = new Intent(CinemaActivity.this,CinemaSeatActivity.class);
                    break;
                case R.id.btn_cinema_4:
                    intent = new Intent(CinemaActivity.this,CinemaSeatActivity.class);
                    break;
                case R.id.btn_cinema_5:
                    intent = new Intent(CinemaActivity.this,CinemaSeatActivity.class);
                    break;
            }
            startActivity(intent);
            CinemaActivity.this.finish();
        }
    }
}
