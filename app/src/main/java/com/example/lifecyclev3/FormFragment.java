package com.example.lifecyclev3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class FormFragment extends Fragment {

    View view;
    EditText editTextEmailAddress, editTextPhone, editTextDate;
    CheckBox checkBoxLicense, checkBoxAge;
    Button submitBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_form, container, false);

        submitBtn = view.findViewById(R.id.submitBtn);
        editTextEmailAddress = view.findViewById(R.id.editTextEmailAddress);
        editTextPhone = view.findViewById(R.id.editTextPhone);
        editTextDate = view.findViewById(R.id.editTextDate);
        checkBoxLicense = view.findViewById(R.id.checkBoxLicense);
        checkBoxAge = view.findViewById(R.id.checkBoxAge);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();

                bundle.putString("email", editTextEmailAddress.getText().toString());
                bundle.putString("phone", editTextPhone.getText().toString());
                bundle.putString("date", editTextDate.getText().toString());
                bundle.putString("license", String.valueOf(checkBoxLicense.isChecked()));
                bundle.putString("age", String.valueOf(checkBoxAge.isChecked()));

                ContactFragment contactFragment = new ContactFragment();
                contactFragment.setArguments(bundle);

                editTextEmailAddress.setText("");
                editTextPhone.setText("");
                editTextDate.setText("");
                checkBoxLicense.setChecked(false);
                checkBoxAge.setChecked(false);

                replaceFragment(contactFragment);
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