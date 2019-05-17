package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView pax;
    CheckBox oneWay;
    CheckBox roundtrip;

    Button minus;
    Button plus;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneWay =  findViewById(R.id.oneway);
        roundtrip = findViewById(R.id.rtrip);

        minus = findViewById(R.id.btnminus);
        plus = findViewById(R.id.btnplus);
        submit = findViewById(R.id.submit);

        pax = findViewById(R.id.textViewPax);

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Integer numPax = Integer.parseInt(pax.toString());
                    if(numPax > 0){
                        numPax -= 1;
                    }else{
                        numPax = 0;
                    }


            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer numPax = Integer.parseInt(pax.toString());
                numPax +=1;
            }
        });

         if(oneWay.isChecked()){
            Intent intent = new Intent(MainActivity.this, Flight_Details.class);
            intent.putExtra("ticket type","One Way Trip");
        }
        else if(roundtrip.isChecked()){
            Intent intent = new Intent(MainActivity.this, Flight_Details.class);
            intent.putExtra("ticket type","Round Trip");
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oneWay.isChecked() && roundtrip.isChecked()){
                    Toast.makeText(MainActivity.this,"Check only 1 ticket type",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, Flight_Details.class);
                intent.putExtra("pax",1);
                startActivity(intent);
            }
        });






    }
}
