package com.example.googlelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class HomeActivity extends AppCompatActivity {

    private GoogleSignInClient mGoogleSignInClient;
    private Button signOutButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle bundle = getIntent().getExtras();

        textView = findViewById(R.id.textView);

        String name = bundle.getString("name");
        Log.d("name", name);
        if (name != null) {
            textView.setText(name);
        }

        signOutButton = findViewById(R.id.out);

        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build();

                GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(HomeActivity.this, gso);
                googleSignInClient.signOut();
                finish();
            }
        });

        Button mapViewButton = findViewById(R.id.button4);
//        mapViewButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomeActivity.this, MapActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
