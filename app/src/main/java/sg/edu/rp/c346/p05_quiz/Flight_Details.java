package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Flight_Details extends AppCompatActivity {
TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight__details);
        details = findViewById(R.id.details);

        Intent intentReceived = getIntent();
        int pax = intentReceived.getIntExtra("pax",1);
        String ticketType = intentReceived.getStringExtra("ticket type");
        details.setText("You have selected "+ ticketType + "\n" + "Your air ticket costs " + pax * 100);
    }
}
