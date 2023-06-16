package com.example.test2_login;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyPage extends AppCompatActivity {

    private FirebaseUser user;
    private FirebaseAuth userAuth;

    private EditText priv_name, priv_email, priv_dogName, priv_gender;

    private Button btn_priv_check, btn_priv_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        user = FirebaseAuth.getInstance().getCurrentUser();
        userAuth = FirebaseAuth.getInstance();

        priv_name = findViewById(R.id.priv_name);
        priv_email = findViewById(R.id.priv_email);
        priv_dogName = findViewById(R.id.priv_dogName);
        priv_gender = findViewById(R.id.priv_gender);

        btn_priv_check = findViewById(R.id.btn_priv_check);
        btn_priv_cancel = findViewById(R.id.btn_priv_cancel);

        btn_priv_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                if (user != null) {
                    // Name, email address, and profile photo Url
                    String name = user.getDisplayName();
                    String email = user.getEmail();
//                    Uri photoUrl = user.getPhotoUrl();

                    // Check if user's email is verified
                    boolean emailVerified = user.isEmailVerified();

                    // The user's ID, unique to the Firebase project. Do NOT use this value to
                    // authenticate with your backend server, if you have one. Use
                    // FirebaseUser.getIdToken() instead.
                    String uid = user.getUid();
                }


            }
        });


    }
}