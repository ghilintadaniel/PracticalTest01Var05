package practicaltest01var05.eim.systems.cs.pub.ro.practicaltest01var05;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var05SecondaryActivity extends AppCompatActivity {

    private TextView sum_text;
    private Button return_button;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.return_button:
                    setResult(RESULT_OK, null);
                    break;

            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);


        return_button = (Button)findViewById(R.id.return_button);
        return_button.setOnClickListener(buttonClickListener);
        sum_text = (TextView) findViewById(R.id.sum_text);
        sum_text.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();

        String total_str = intent.getStringExtra("final string");
        int sum = 0;

        for (String s : total_str.split("\\+"))
        {
            sum += Integer.valueOf(s);
        }
        total_str += String.valueOf('=');
        total_str += String.valueOf(sum);
        sum_text.setText(String.valueOf(total_str));
    }

}
