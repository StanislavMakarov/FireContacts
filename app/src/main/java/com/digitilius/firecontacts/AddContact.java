package com.digitilius.firecontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddContact extends AppCompatActivity {

    private DatabaseReference contactsDBref;
    private TextView contactName;
    private TextView contactPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        contactName = findViewById(R.id.contact_name);
        contactPhone = findViewById(R.id.contact_phone);
        Button saveButton = findViewById(R.id.button_save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(contactName.getText() != null && contactPhone.getText() != null) {
                    ContactRecord contactRecord = new ContactRecord(
                            contactName.getText().toString(),
                            contactPhone.getText().toString()
                    );
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("contacts");
                    myRef.push().setValue(contactRecord);

                    contactName.setText(null);
                    contactPhone.setText(null);
                }
            }
        });
    }
}