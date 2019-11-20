package com.example.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class MainActivity extends AppCompatActivity {

    EditText edtUserName;
    EditText edtPassword;
    CheckBox cbSave;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPassword = findViewById(R.id.edittextPassword);
        edtUserName = findViewById(R.id.edittextUsername);
        cbSave = findViewById(R.id.checkboxSave);
        btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();

//                if (username.equals("phat") && password.equals("123456")){
//
//                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MainActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
//                }

            }
        });
        try {
            SecretKey secret = EncUtil.generateKey();
            byte[] encryptcode = EncUtil.encryptMsg("phat", secret);
            String text = EncUtil.decryptMsg(encryptcode, secret);
            Log.d("BBB",text);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
