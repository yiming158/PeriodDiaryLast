package com.example.perioddiary2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.example.perioddiary2.AboutUser.currAge;
import static com.example.perioddiary2.AboutUser.currCycleLength;
import static com.example.perioddiary2.AboutUser.currStartDate;
import static com.example.perioddiary2.AboutUser.currUsualCycle;

public class NewAccount extends AppCompatActivity {

    ImageButton back;
    EditText emailText, passwordText;
    Button signUp;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fStore;
    public static final String TAG = "TAG";
    String userID;


    public static String currName, currUsername, currEmail, currPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_account);
        back = findViewById(R.id.back_arrow_NA);

        emailText = findViewById(R.id.email_NA);
        passwordText = findViewById(R.id.password_NA);
        signUp = findViewById(R.id.signUp_NA);
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        setListeners();

    }

    private void setListeners() {
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = emailText.getText().toString().trim();
                String password = passwordText.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    emailText.setError("Email is Required.");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    passwordText.setError("Password is Required.");
                    return;
                }

                if (password.length() < 6) {
                    passwordText.setError("Password Must be >= 6 Characters");
                    return;
                }


                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // send verification link

                            FirebaseUser fuser = mAuth.getCurrentUser();
                            assert fuser != null;
                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(NewAccount.this, "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: Email not sent " + e.getMessage());
                                }
                            });

                            Toast.makeText(NewAccount.this, "User Created.", Toast.LENGTH_SHORT).show();
                            userID = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String, Object> user = new HashMap<>();
                            user.put("email", email);
                            user.put("lastPeriodDate", currStartDate);
                            user.put("currCycleLength", currCycleLength);
                            user.put("currUsualCycle", currUsualCycle);
                            user.put("currAge", currAge);

                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSuccess: user Profile is created for " + userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: " + e.toString());
                                }
                            });
                            startActivity(new Intent(getApplicationContext(), AboutUser.class));

                        } else {
                            Toast.makeText(NewAccount.this, "Error ! " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}



