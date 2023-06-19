package com.example.test2_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.test2_login.databinding.ActivityMyPageBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyPage extends AppCompatActivity {

    private FirebaseUser user;
    private FirebaseAuth userAuth;
    private ActivityMyPageBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = FirebaseAuth.getInstance().getCurrentUser();
        userAuth = FirebaseAuth.getInstance();

        mBinding = ActivityMyPageBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);




        mBinding.btnPrivCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                if (user != null) {
                    // Name, email address, and profile photo Url
                    String email = user.getDisplayName();
                    String passwd = user.getEmail();
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


        return ;
    }
}