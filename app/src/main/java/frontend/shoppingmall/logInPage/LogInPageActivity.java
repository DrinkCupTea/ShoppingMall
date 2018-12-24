package frontend.shoppingmall.logInPage;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import frontend.shoppingmall.R;
import frontend.shoppingmall.ScanActivity;
import frontend.shoppingmall.cinemaPage.CinemaActivity;
import frontend.shoppingmall.cinemaPage.CinemaSeatActivity;
import frontend.shoppingmall.homePage.HomePageActivity;

public class LogInPageActivity extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn = findViewById(R.id.login_btn_login);
        setListener();
        EditText usert=findViewById(R.id.logInUser);
        EditText passwordt=findViewById(R.id.logInPassword);
        Drawable user = getResources().getDrawable(R.drawable.icon_user);
        Drawable password = getResources().getDrawable(R.drawable.icon_password);
        user.setBounds(0,0,43,43);
        password.setBounds(0,0,43,43);
        usert.setCompoundDrawables(user,null,null,null);
        passwordt.setCompoundDrawables(password,null,null,null);
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
                case R.id.login_btn_login:
                    intent = new Intent(LogInPageActivity.this,HomePageActivity.class);
                    break;
            }
            startActivity(intent);
            LogInPageActivity.this.finish();
        }
    }
}
