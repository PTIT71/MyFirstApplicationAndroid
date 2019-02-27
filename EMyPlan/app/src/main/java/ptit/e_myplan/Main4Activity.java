package ptit.e_myplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    TextView txtEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        txtEdit= (TextView) findViewById(R.id.txtFullNameOfUser);
        System.out.println(Main2Activity.UserDefault.GetFullName());
        txtEdit.setText(Main2Activity.UserDefault.GetFullName());
        System.out.println(txtEdit.getText().toString());


    }
}
