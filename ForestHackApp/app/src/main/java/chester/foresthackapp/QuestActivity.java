package chester.foresthackapp;

import android.app.Activity;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class QuestActivity extends AppCompatActivity {
    private boolean questIsDone;
    private int[] questArray;

    private TextView tv_quest1;
    private TextView tv_quest2;
    private TextView tv_quest3;
    private TextView tv_quest4;
    private TextView tv_quest5;

    private Button btn_back;
    private Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);

        rnd = new Random(System.currentTimeMillis());
        questIsDone = true;
        questArray = new int[5];

        tv_quest1 = (TextView) findViewById(R.id.tv_quest1);
        tv_quest2 = (TextView) findViewById(R.id.tv_quest2);
        tv_quest3 = (TextView) findViewById(R.id.tv_quest3);
        tv_quest4 = (TextView) findViewById(R.id.tv_quest4);
        tv_quest5 = (TextView) findViewById(R.id.tv_quest5);

        btn_back = (Button) findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ((Activity) QuestActivity.this).finish();
            }
        });

        getQuests();
    }

    private void getQuests(){
        if(questIsDone){
            ArrayList<Integer> listOfRandom = new ArrayList<>();
            Random rand = new Random();

            while (listOfRandom.size() != 5) { //generating 5 numbers between 0 to 14
                int x = rand.nextInt(15);
                if (listOfRandom.contains(x)) {
                } else {
                    listOfRandom.add(x);
                }
            }

            for(int i = 0; i < questArray.length; i++){
                    questArray[i] = listOfRandom.get(i);
            }

            updateQuests(tv_quest1,questArray[0]);
            updateQuests(tv_quest2,questArray[1]);
            updateQuests(tv_quest3,questArray[2]);
            updateQuests(tv_quest4,questArray[3]);
            updateQuests(tv_quest5,questArray[4]);
        }
    }

    private void updateQuests(TextView tv, int qrID){
        tv.setText("Scan a " + qrID);
    }
}
