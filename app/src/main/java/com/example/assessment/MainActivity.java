package com.example.assessment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.assessment.Fragment.FirstFragment;
import com.example.assessment.Fragment.SecondFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FirebaseAuth mAuth;
    ImageView imageView;
    TextView textName, textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.actionbar);


        mAuth = FirebaseAuth.getInstance();

        imageView = findViewById(R.id.profileImage);
        textName = findViewById(R.id.name);
//        textEmail = findViewById(R.id.textViewEmail);


        FirebaseUser user = mAuth.getCurrentUser();

//        Glide.with(this)
//                .load(user.getPhotoUrl())
//                .into(imageView);


//        setTitle("Well Come "+user.getDisplayName());
//        textName.setText(user.getDisplayName());
//        textEmail.setText(user.getEmail());

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
//I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,
                    new FirstFragment()).commit();

        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.home:
                            selectedFragment = new FirstFragment();
                            break;
                        case R.id.saved:
                            selectedFragment = new SecondFragment();
                            break;
//                        case R.id.nav_profile:
//                            selectedFragment = new ProfileFragment();
//                            break;
//                        case R.id.nav_saved:
//                            selectedFragment = new SavedFragment();
//                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,
                            selectedFragment).commit();
                    return true;
                }
            };


//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        //if the user is not logged in
//        //opening the login activity
////        if (mAuth.getCurrentUser() == null) {
////            finish();
////            startActivity(new Intent(this, MainActivity.class));
////        }
//    }
}


