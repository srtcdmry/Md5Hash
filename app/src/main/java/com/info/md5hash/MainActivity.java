package com.info.md5hash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.info.md5hash.databinding.ActivityMainBinding;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final String hashData = "9e69e5df21d99aea0e757ad6ff634583";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
       // String s1 = "125125124";
        binding.buttonMd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = binding.editTextMd5.getText().toString();
                if(hashData.equals(getMd5(s1))) {
                    Toast.makeText(getApplicationContext(), "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Şifre Yanlış !", Toast.LENGTH_SHORT).show();
                }
            }
        });


//        binding.buttonMd5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String s1 = binding.editTextMd5.getText().toString();
//                System.out.println(s1 + ": " + getMd5(s1));
//                binding.textMd5.setText(getMd5(s1));
//            }
//        });
    }

    public static String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}