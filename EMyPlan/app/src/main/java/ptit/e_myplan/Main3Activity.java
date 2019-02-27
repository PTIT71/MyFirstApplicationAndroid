package ptit.e_myplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Model.User;

public class Main3Activity extends AppCompatActivity {

    EditText txtFullName, txtUserName, txtPassword, txtRePassword;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        GetDataFromLayout();
        ControlButton();

    }
    private void ControlButton()
    {
        //Conding of button Register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check empty EditText
                if(txtFullName.getText().toString().length()!=0 && txtUserName.getText().toString().length()!=0 &&
                   txtPassword.getText().toString().length()!=0 && txtRePassword.getText().toString().length()!=0 )
                {
                    //No Empty
                    //Check Password and Re-Password
                    String IdentifyPassword = txtRePassword.getText().toString();
                    if(txtPassword.getText().toString().equals(IdentifyPassword))
                    {
                        //OK
                        //Create Account for you
                        String FullName = txtFullName.getText().toString();
                        String Password = txtPassword.getText().toString();
                        String Username = txtUserName.getText().toString();

                        Main2Activity.UserDefault = new User(FullName,Username , Password);
                        Toast.makeText(Main3Activity.this,"Đăng ký thành công" , Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        //Not OK
                        Toast.makeText(Main3Activity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                        txtPassword.getText().clear();
                        txtRePassword.getText().clear();
                    }

                }
                else
                {
                    //One of EditText Empty
                    if(txtFullName.getText().toString().length()==0)
                    {
                        txtFullName.setError("Chưa điền tên của bạn");
                    }
                    if(txtUserName.getText().toString().length()==0)
                    {
                        txtUserName.setError("Chưa điền Tên đăng nhập");
                    }
                    if(txtPassword.getText().toString().length()==0)
                    {
                        txtPassword.setError("Chưa nhập mật khẩu");
                    }
                    if(txtRePassword.getText().toString().length()==0)
                    {
                        txtRePassword.setError("Không có mật khẩu xác nhận");
                    }
                }
            }
        });
    }

    private  void GetDataFromLayout()
    {
        txtFullName = (EditText)findViewById(R.id.txtFullName);
        txtUserName  = (EditText)findViewById(R.id.txtUsername);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        txtRePassword = (EditText)findViewById(R.id.txtRePassword);
        btnRegister = (Button)findViewById(R.id.buttonRegister);
    }
}
