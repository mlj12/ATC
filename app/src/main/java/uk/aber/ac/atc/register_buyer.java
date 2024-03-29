package uk.aber.ac.atc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import uk.aber.ac.atc.R;

public class register_buyer extends AppCompatActivity {

    private EditText txtEmailAddress;
    private EditText txtPassword;
    private FirebaseAuth firebaseAuth;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_buyer);
        txtEmailAddress = (EditText) findViewById(R.id.email);
        txtPassword = (EditText) findViewById(R.id.password);
        registerBtn = (Button) findViewById(R.id.register_button);
        firebaseAuth = FirebaseAuth.getInstance();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                createAccount();
            }
        });
    }
    public void createAccount() {

        final ProgressDialog progressDialog = ProgressDialog.show(register_buyer.this, "Please wait...", "Processing...", true);
        (firebaseAuth.createUserWithEmailAndPassword(txtEmailAddress.getText().toString(), txtPassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(register_buyer.this, "Registration successful", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(register_buyer.this, Log_In_buyer.class);
                            startActivity(i);
                        }
                        else
                        {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(register_buyer.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}