package ptit.e_myplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Model.User;

public class Main2Activity extends AppCompatActivity {

    EditText txtUsername, txtPassword;
    Button btnSignIn, btnRegister;
    public static User UserDefault = new User("Nguyen Huu Tien", "admin", "1234");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        GetDataFromLayout();
        ControlButton();
    }

    private void ControlButton()
    {
        //Conding of Button Register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
        //Coding of Button Sign In
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        if(txtUsername.getText().toString().length()!=0 && txtPassword.getText().toString().length()!=0)
        {
            if(txtUsername.getText().toString().equals(UserDefault.GetUserName()) && txtPassword.getText().toString().equals(UserDefault.GetPassword()))
            {
                Toast.makeText(Main2Activity.this, "Bạn đăng nhập thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Main2Activity.this, Main4Activity.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(Main2Activity.this, "Bạn đăng nhập không thành công", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            if(txtUsername.getText().toString().length()==0)
                txtUsername.setError("Chưa có tên đăng nhập");
            if(txtPassword.getText().toString().length()==0)
                txtPassword.setError("Chưa có mật khẩu");
            Toast.makeText(Main2Activity.this, "Chưa nhập đủ thông tin", Toast.LENGTH_SHORT).show();
        }
            }
        });
    }
    private Boolean GetDataFromLayout()
    {
        try
        {
            txtUsername = (EditText)findViewById(R.id.editTextUsername);
            txtPassword = (EditText)findViewById(R.id.editTextPassword);
            btnSignIn = (Button)findViewById(R.id.buttonSignIn);
            btnRegister = (Button)findViewById(R.id.buttonRegister);

            return true;
        }
        catch (Exception MessageException)
        {
            return false;
        }
    }

}
