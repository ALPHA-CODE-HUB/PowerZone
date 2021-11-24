package com.example.powerzone.loginpages;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.powerzone.R;
import com.example.powerzone.homepage.homepage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class loginFragment extends Fragment {
    Button sign,login;
Fragment fragment;
View view;

    EditText uname, pass;
    Button b1;

    FirebaseAuth auth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_login, container, false);
        sign= view.findViewById(R.id.sb);



        auth = FirebaseAuth.getInstance();

        uname = view.findViewById(R.id.uname);
        pass = view.findViewById(R.id.pass);
        b1 = view.findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = uname.getText().toString();
                String password = pass.getText().toString();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getActivity().getApplication(), "All the filds must be filled", Toast.LENGTH_SHORT).show();

                } else {
                    auth.signInWithEmailAndPassword(name, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(getActivity().getApplication(), homepage.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);

                                    } else {
                                        Toast.makeText(getActivity().getApplication(), "Autheication failed", Toast.LENGTH_SHORT).show();
                                    }


                                }
                            });
                }
            }
        });




        return view;

    }



}