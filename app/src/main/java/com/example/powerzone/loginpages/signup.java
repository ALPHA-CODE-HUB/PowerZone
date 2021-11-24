package com.example.powerzone.loginpages;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.powerzone.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class signup extends Fragment {
    View view;
    Button sign, login;
    private EditText email,password,scpassword,phone;
    private FirebaseAuth mAuth;
    private String userId;
    private RadioButton male, female;
    public signup() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_signup, container, false);

        login=view.findViewById(R.id.sb);

        email=view.findViewById(R.id.smails);
        password=view.findViewById(R.id.spassword);
        phone=view.findViewById(R.id.snumber);
        scpassword=view.findViewById(R.id.scpassword);

        mAuth = FirebaseAuth.getInstance();

        male = view.findViewById(R.id.malerb);
        female = view.findViewById(R.id.Femalerb);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registeruser();
            }
        });





        return view;




    }

    private void registeruser() {
        String phonenumber = phone.getText().toString().trim();
        String e_mail = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String gender = "";
        if (male.isChecked()) {
            gender = "male";
        } else if (female.isChecked()) {
            gender = "female";
        }
        String gender1 = gender;

        if (phonenumber.isEmpty()) {
            phone.setError("Phone number required!");
            phone.requestFocus();
            return;
        }

        if (e_mail.isEmpty()) {
            email.setError("Email required!");
            email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(e_mail).matches()) {
            email.setError("Please provide valid email!");
            email.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            password.setError("Password required!");
            password.requestFocus();
            return;
        }
        if (pass.length() < 6) {
            password.setError("Min password length should be 6 characters!");
        }


        mAuth.createUserWithEmailAndPassword(e_mail, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            user User = new user( mAuth.getUid(),e_mail,phonenumber,gender1);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child("user")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(User).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getActivity().getApplication(), "Account Created Successfully!", Toast.LENGTH_LONG).show();

                                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                        user.sendEmailVerification();
                                    } else {
                                        Toast.makeText(getActivity().getApplication(), "Failed to create account, Try again", Toast.LENGTH_LONG).show();

                                    }
                                }
                            });
                        } else {
                            Toast.makeText(getActivity().getApplication(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }}
