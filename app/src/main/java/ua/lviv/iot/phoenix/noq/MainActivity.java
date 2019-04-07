package ua.lviv.iot.phoenix.noq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);

        Button Order = findViewById(R.id.makeOrder);
        Order.setOnClickListener( (View view) -> {
            TextView User = findViewById(R.id.name);
            String userName = (String) User.getText();
            Intent OpenListOfCafes = new Intent(MainActivity.this, ListOfCafes.class);
            OpenListOfCafes.putExtra("UserName", userName);
            startActivity(OpenListOfCafes);
            overridePendingTransition(R.anim.from_bottom_to_top, R.anim.from_bottom_to_top_exit);
        });


        Button myOrders = findViewById(R.id.myOrders);
        myOrders.setOnClickListener( (View view) ->
                Toast.makeText(getApplicationContext(), "У розробці...", Toast.LENGTH_SHORT).show()
        );
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.from_top_to_bottom_exit, R.anim.from_top_to_bottom);
    }
}
