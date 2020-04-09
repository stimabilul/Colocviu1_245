package ro.pub.cs.systems.eim.colocviu1_245;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Colocviu1_245SecondaryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String allTerms = intent.getStringExtra(Constants.ALL_TERMS);

        int sum = 0;
        Log.d("INPUT", allTerms);
        for (String s : allTerms.split(" \\+ ")) {
            sum += Integer.parseInt(s);
        }

        Log.d("TEST", "Secondary Works. The sum is: " + sum);
        setResult(sum, null);
        finish();
    }
}
