package techbridge.rockpaperscissors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textViewResult;
    Button btnPlay,btnScissors,btnRock,btnPaper;
    ImageView imageViewMe, imageViewComputer;

    ///7.2////////
    String me = "";
    /*가위바위보 프로그램에서 me 와 computer의 가위, 바위,보 변수를 받아서
    * 누가 이겼는지 토스트로 보여주는 함수를 만들어라. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = (TextView) findViewById(R.id.textViewResult);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnScissors = (Button) findViewById(R.id.btnSissors);
        btnRock = (Button) findViewById(R.id.btnRock);
        btnPaper = (Button) findViewById(R.id.btnPaper);
        imageViewMe = (ImageView) findViewById(R.id.imageViewMe);
        imageViewComputer = (ImageView) findViewById(R.id.imageViewComputer);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String computer = randomComputer();
                setComputerImage(computer);
                String result = whoWon(me, computer);
                showToast(me + " vs " + computer);
                showResult(result);
            }
        });
        btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                me = "scissors";
                setMeImage(me);
                btnScissors.setEnabled(false);
                btnRock.setEnabled(true);
                btnPaper.setEnabled(true);

            }
        });
        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                me = "paper";
                setMeImage(me);
                btnScissors.setEnabled(true);
                btnRock.setEnabled(true);
                btnPaper.setEnabled(false);

            }
        });
        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                me = "rock";
                setMeImage(me);
                btnScissors.setEnabled(true);
                btnRock.setEnabled(false);
                btnPaper.setEnabled(true);

            }
        });
    }

    public void setMeImage(String me){
        if(me.equals("scissors")){
            imageViewMe.setImageResource(R.drawable.left_scissors);
        } else if(me.equals("rock")){
            imageViewMe.setImageResource(R.drawable.left_rock);
        } else if(me.equals("paper")){
            imageViewMe.setImageResource(R.drawable.left_paper);
        }
    }

    public void setComputerImage(String computer){
                if(computer.equals("scissors")){
                        imageViewComputer.setImageResource(R.drawable.right_scissors);
                    } else if(computer.equals("rock")){
                        imageViewComputer.setImageResource(R.drawable.right_rock);
                    } else if(computer.equals("paper")){
                        imageViewComputer.setImageResource(R.drawable.right_paper);
                    }
            }

    public void showToast(String message){
        //textViewResult.setText(result);
        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();

    }
    public void showResult(String result){
        textViewResult.setText(result);
    }

    public String randomComputer(){
        String computer = "";
        Random rand = new Random();
        int random = rand.nextInt(3);
        if(random==0){
            computer = "scissors";
        } else if(random==1){
            computer = "rock";
        } else if(random==2){
            computer = "paper";
        } else {
            computer = "error";
        }
        return computer;
    }
    public String whoWon(String me, String computer){
        String result = "";
        /*if와 if else ,else문을 통해서 result에 어떤 값을 저장할지*/

        if (me.equals("rock")) {
            if(computer.equals("rock")){
                result = "Draw!";
            } else if(computer.equals("paper")){
                result = "Lose!";
            } else if(computer.equals("scissors")){
                result = "Win!";
            } else {
                result = "Typo!";
            }
        } else if(me.equals("paper")){
            if(computer.equals("rock")){
                result = "Win!";
            } else if(computer.equals("paper")){
                result = "Draw!";
            } else if(computer.equals("scissors")){
                result = "Lose!";
            } else {
                result = "Typo!";
            }
        } else if(me.equals("scissors")){
            if(computer.equals("rock")){
                result = "Lose!";
            } else if(computer.equals("paper")){
                result = "Win!";
            } else if(computer.equals("scissors")){
                result = "Draw!";
            } else {
                result = "Typo!";
            }
        } else {
            result = "Select your move!";/////////////예외처리
        }//////////////////////////if 절의 끝//////////////////////////
        return result;
    }
}
