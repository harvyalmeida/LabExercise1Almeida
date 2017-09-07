package com.harvy.labexercise1almeida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et_Quiz1;
    EditText et_Quiz2;
    EditText et_Seatworks;
    EditText et_LabExercises;
    EditText et_MajorExam;
    Button btn_Send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_Quiz1=(EditText)findViewById(R.id.Quiz1);
        et_Quiz2=(EditText)findViewById(R.id.Quiz2);
        et_Seatworks=(EditText)findViewById(R.id.Seatworks);
        et_LabExercises=(EditText)findViewById(R.id.LabExer);
        et_MajorExam=(EditText)findViewById(R.id.MajorExam);
        btn_Send=(Button)findViewById(R.id.btnSend);
    }
    public void callSecondActivity(View view){
        Intent intent=new Intent(this, Main2Activity.class);

        String quiz1Str = et_Quiz1.getText().toString();
        String quiz2Str = et_Quiz2.getText().toString();
        String seatworksStr =  et_Seatworks.getText().toString();
        String labExercisesStr = et_LabExercises.getText().toString();
        String majorExam = et_MajorExam.getText().toString();

        Double quiz1Dbl = Double.valueOf(quiz1Str);
        Double quiz2Dbl = Double.valueOf(quiz2Str);
        Double seatworksDbl = Double.valueOf(seatworksStr);
        Double labExercisesDbl = Double.valueOf(labExercisesStr);
        Double majorExamDbl = Double.valueOf(majorExam);

        Double totalRA;
        String convertedValue = "";

        totalRA = (quiz1Dbl * .10) + (quiz2Dbl * .10) + (seatworksDbl * .10) + (labExercisesDbl * .30) + (majorExamDbl *.40);

        if(totalRA  < 60 ){
            convertedValue = "5.0";
        }else if(totalRA >= 60 && totalRA < 66 ){
            convertedValue = "3.0";
        }else if(totalRA >= 66 && totalRA < 71 ){
            convertedValue = "2.75";
        }
        else if(totalRA >= 71 && totalRA < 76 ){
            convertedValue = "2.50";
        }
        else if(totalRA >= 76 && totalRA < 81 ){
            convertedValue = "2.25";
        }
        else if(totalRA >= 81 && totalRA < 86 ){
            convertedValue = "2.0";
        }
        else if(totalRA >= 86 && totalRA < 91 ){
            convertedValue = "1.75";
        }
        else if(totalRA >= 91 && totalRA < 93 ){
            convertedValue = "1.50";
        }
        else if(totalRA >= 93 && totalRA < 95 ){
            convertedValue = "1.25";
        }
        else if(totalRA >= 95 && totalRA <= 100 ){
            convertedValue = "1.0";
        }

        intent.putExtra("raTotal",totalRA.toString());
        intent.putExtra("finalGradeTotal",convertedValue);
        startActivity(intent);
    }
}