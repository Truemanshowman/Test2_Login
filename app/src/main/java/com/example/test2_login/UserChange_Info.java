package com.example.test2_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserChange_Info extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseReference;
    private EditText check_email, check_pwd;
    private Button btn_find_check, btn_find_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_change_info);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        check_email = findViewById(R.id.check_email);
        check_pwd = findViewById(R.id.check_pwd);

        btn_find_check = findViewById(R.id.btn_find_check);
        btn_find_check = findViewById(R.id.btn_find_cancel);

        btn_find_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String strEmail = check_email.getText().toString();
                String strPwd = check_pwd.getText().toString();

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                AuthCredential credential = EmailAuthProvider.getCredential(strEmail, strPwd);

                user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>()
                        {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(UserChange_Info.this, "비밀번호가 수정되었습니다.", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(UserChange_Info.this, "아이디, 비밀번호를 다시 확인해 주세요", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}

