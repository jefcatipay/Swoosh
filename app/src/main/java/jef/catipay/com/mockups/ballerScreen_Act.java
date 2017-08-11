package jef.catipay.com.mockups;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Jef on 8/11/2017.
 */

public class ballerScreen_Act extends Activity {
    public static final String KEY_TEXT = "key_text";
    private Button begBtn, ballBtn, finBtn;
    private String skillInputTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.baller_screen);
        findViews();

        begBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clicked(begBtn.getText().toString());
            }
        });
        ballBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clicked(ballBtn.getText().toString());
            }
        });


        finBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent data = new Intent();
                data.putExtra(KEY_TEXT,getskillInputTxt());
                setResult(Activity.RESULT_OK, data);
                finish();

            }
        });
    }



    private void findViews(){
        begBtn = (Button) findViewById(R.id.beginnerBtn);
        ballBtn = (Button) findViewById(R.id.ballerBtn);
        finBtn = (Button)findViewById(R.id.finishBtn);
    }

    public String getskillInputTxt(){return skillInputTxt;}
    public void setskillInputTxt(String skillInputTxt){this.skillInputTxt=skillInputTxt;}

    private void clicked(String s){
        finBtn.setEnabled(true);
        finBtn.setBackgroundResource(R.drawable.custom_button1);
        finBtn.setTextColor(Color.WHITE);
        setskillInputTxt(s);

    }


}
