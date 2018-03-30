package practicaltest01var05.eim.systems.cs.pub.ro.practicaltest01var05;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01Var05MainActivity extends AppCompatActivity {

    private EditText add_number;
    private EditText str_number;
    private Button add_button, compute_button;


    private IntentFilter intentFilter = new IntentFilter();

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String new_str = String.valueOf(add_number.getText());
            String total_str = String.valueOf(str_number.getText());

            switch(view.getId()) {
                case R.id.add_button:
                    if (total_str.length() > 0) total_str += String.valueOf('+');
                    total_str += new_str;
                    str_number.setText(String.valueOf(total_str));
                    break;
                case R.id.compute_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var05SecondaryActivity.class);
                    String string_to_send = total_str;
                    intent.putExtra("final string", total_str);
                    startActivityForResult(intent, 1);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);

        add_number = (EditText)findViewById(R.id.add_number);
        str_number = (EditText)findViewById(R.id.str_number);
        add_button = (Button)findViewById(R.id.add_button);
        add_button.setOnClickListener(buttonClickListener);
        compute_button = (Button)findViewById(R.id.compute_button);
        compute_button.setOnClickListener(buttonClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

    }
}
