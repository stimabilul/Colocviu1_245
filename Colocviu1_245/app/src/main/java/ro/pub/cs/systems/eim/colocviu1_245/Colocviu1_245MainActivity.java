package ro.pub.cs.systems.eim.colocviu1_245;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Colocviu1_245MainActivity extends AppCompatActivity {

    private Button addButton;
    private Button computeButton;
    private EditText inputEditText;
    private EditText outputEditText;
    private String nextTerm = "";
    private int lastSum = 0;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.add_button:
                    if (!inputEditText.getText().toString().equals("")) {
                        String text = inputEditText.getText().toString();
                        if (nextTerm.equals(""))
                            nextTerm += text;
                        else
                            nextTerm += " + " + text;

                        outputEditText.setText(nextTerm);
                    }
                    break;
                case R.id.compute_button:
                    Intent intent = new Intent(getApplicationContext(), Colocviu1_245SecondaryActivity.class);
                    intent.putExtra(Constants.ALL_TERMS, nextTerm);
                    Log.d("TEST", "Intent Ready");
                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.LAST_SUM, String.valueOf(lastSum));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.LAST_SUM))
            lastSum = Integer.parseInt(savedInstanceState.getString(Constants.LAST_SUM));
        Toast.makeText(this, "The last sum saved is " + lastSum, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        lastSum = resultCode;
        Toast.makeText(this, "The activity returned with sum " + resultCode, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_245_main);

        addButton = (Button)findViewById(R.id.add_button);
        computeButton = (Button)findViewById(R.id.compute_button);
        inputEditText = (EditText)findViewById(R.id.input_text);
        outputEditText = (EditText)findViewById(R.id.output_text);

        addButton.setOnClickListener(buttonClickListener);
        computeButton.setOnClickListener(buttonClickListener);
    }
}
