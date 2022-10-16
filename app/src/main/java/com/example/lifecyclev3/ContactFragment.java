package com.example.lifecyclev3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContactFragment extends Fragment {


    public ContactFragment(){

    }

    View view;
    TextView textViewEmail, textViewDate, textViewPhone, textViewLicense, textViewAge;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact, container, false);
        Bundle bundle = this.getArguments();

        if(bundle != null) {
            textViewEmail = view.findViewById(R.id.textViewEmail);
            textViewDate = view.findViewById(R.id.textViewDate);
            textViewPhone = view.findViewById(R.id.textViewPhone);
            textViewLicense = view.findViewById(R.id.textViewLicense);
            textViewAge = view.findViewById(R.id.textViewAge);


            String email = bundle.getString("email");
            String date = bundle.getString("date");
            String phone = bundle.getString("phone");
            String license = bundle.getString("license");
            String age = bundle.getString("age");

            textViewEmail.setText(email);
            textViewDate.setText(date);
            textViewPhone.setText(phone);
            textViewLicense.setText(license);
            textViewAge.setText(age);
        }

        return view;
    }
}