package uk.aber.ac.atc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button buyerBtn, sellerBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // When log in button is clicked, redirects to log in page

        buyerBtn = (Button)findViewById(R.id.btn_buyers);
        sellerBtn = (Button)findViewById(R.id.btn_sellers);


        buyerBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,authentication_buyer.class);
                startActivity(intent);
            }



        });

       /* sellerBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,authentication.class);
                startActivity(intent);
            }

        }); */
    }

}
