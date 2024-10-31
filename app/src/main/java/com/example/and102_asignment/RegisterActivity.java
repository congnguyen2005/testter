package com.example.and102_asignment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.and102_asignment.dao.NguoiDungDAO;

public class RegisterActivity extends AppCompatActivity {
    private NguoiDungDAO nguoiDungDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //ánh xạ
        EditText edtUser = findViewById(R.id.edtUser);
        EditText edtPassword = findViewById(R.id.edtPass);
        EditText edtRePassword = findViewById(R.id.edtRePass);
        EditText edtFullName = findViewById(R.id.edtFullName);
        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnGoBack = findViewById(R.id.btnGoBack);
        //Gán sự kiện

        nguoiDungDAO = new NguoiDungDAO(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String pass = edtPassword.getText().toString();
                String rePass = edtRePassword.getText().toString();
                String fullName = edtFullName.getText().toString();

               if (!pass.equals(rePass)){
                   Toast.makeText(RegisterActivity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
               } else{
                   boolean check = nguoiDungDAO.Register(user, pass, fullName);
                   if (check) {
                       Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                       finish();
                   } else {
                       Toast.makeText(RegisterActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });

            btnGoBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
    }
}