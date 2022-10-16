package com.example.lifecyclev3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class LoggedinFragment extends Fragment {

    View view;
    Button formBtn, contactBtn, aboutBtn, logOutBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_loggedin, container, false);

        AboutFragment aboutFragment = new AboutFragment();
        ContactFragment contactFragment = new ContactFragment();
        FormFragment formFragment = new FormFragment();

        replaceFragment(new FormFragment());

        formBtn = view.findViewById(R.id.formBtn);
        contactBtn = view.findViewById(R.id.contactBtn);
        aboutBtn = view.findViewById(R.id.aboutBtn);
        logOutBtn = view.findViewById(R.id.logOutBtn);

        formBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(formFragment);
            }
        });

        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(contactFragment);
            }
        });

        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(aboutFragment);
            }
        });

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new LoginFragment());
            }
        });

        return view;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.loggedInframeLayout, fragment);
        fragmentTransaction.commit();
    }
}