package jef.catipay.com.mockups;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jef on 8/11/2017.
 */

public class LeagueScreen_Act extends Activity{
    public static final String KEY_TEXT = "key_text";
    public static final int KEY_CODE = 101;
    private Button  mensBtn, womensBtn, coedBtn,nextBtn;
    private TextView output, outputSkill;
    private String leagueInputTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.league_screen);
        findViews();

        mensBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clicked(mensBtn.getText().toString());
            }
        });
        womensBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clicked(womensBtn.getText().toString());
            }
        });

        coedBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clicked(coedBtn.getText().toString());
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),ballerScreen_Act.class);
                intent.putExtra(KEY_TEXT, "");
                startActivityForResult(intent, KEY_CODE);
            }
        });


    }
    private void findViews(){
    mensBtn = (Button) findViewById(R.id.mensBtn);
    womensBtn = (Button) findViewById(R.id.womensBtn);
    coedBtn = (Button)findViewById(R.id.coedBtn);
    nextBtn = (Button) findViewById(R.id.nextBtn);
    output = (TextView) findViewById(R.id.outputIAM);
    outputSkill = (TextView) findViewById(R.id.outputSkill);
    }

    public String getLeagueInputTxt(){return leagueInputTxt;}
    public void setLeagueInputTxt(String leagueInputTxt){this.leagueInputTxt=leagueInputTxt;}

    private void clicked(String s){
        nextBtn.setEnabled(true);
        nextBtn.setBackgroundResource(R.drawable.custom_button1);
        nextBtn.setTextColor(Color.WHITE);
        setLeagueInputTxt(s);

    }

    private void visibleSkillDisplay(String s){
        nextBtn.setVisibility(View.GONE);
        output.setVisibility(View.VISIBLE);
        outputSkill.setVisibility(View.VISIBLE);
        outputSkill.setText(s);
    }
    private void greyButtons(String s){

        switch (s) {
            case "Mens":
                womensBtn.setBackgroundResource(R.drawable.custom_button2);
                coedBtn.setBackgroundResource(R.drawable.custom_button2);
                womensBtn.setTextColor(555555);
                coedBtn.setTextColor(555555);
                break;
            case "Womens":
                mensBtn.setBackgroundResource(R.drawable.custom_button2);
                coedBtn.setBackgroundResource(R.drawable.custom_button2);
                mensBtn.setTextColor(555555);
                coedBtn.setTextColor(555555);
                break;
            case "Co-ed":
                womensBtn.setBackgroundResource(R.drawable.custom_button2);
                mensBtn.setBackgroundResource(R.drawable.custom_button2);
                womensBtn.setTextColor(555555);
                mensBtn.setTextColor(555555);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode== KEY_CODE){
                String skillReplyTxt = data.getStringExtra(ballerScreen_Act.KEY_TEXT);
                if(this.getLeagueInputTxt().equalsIgnoreCase(mensBtn.getText().toString())){
                    visibleSkillDisplay(skillReplyTxt);
                    greyButtons(mensBtn.getText().toString());
                }
                if(this.getLeagueInputTxt().equalsIgnoreCase(womensBtn.getText().toString())){
                    visibleSkillDisplay(skillReplyTxt);
                    greyButtons(womensBtn.getText().toString());
                }
                if(this.getLeagueInputTxt().equalsIgnoreCase(coedBtn.getText().toString())){
                    visibleSkillDisplay(skillReplyTxt);
                    greyButtons(coedBtn.getText().toString());
                }

            }
        }
    }
}
