package com.example.ad37_nguyenngocdung_day5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contact> contacts;
    Contact contact1, contact2, contact3, contact4, contact5, contact6;
    RecyclerView recyclerView;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvList);

        contacts = new ArrayList<>();
        contact1 = new Contact("0127889153","Viet Nam","17/11/2019","incomingCall","");
        contact2 = new Contact("0123456789","Viet Nam","17/11/2019","incomingCall","");
        contact3 = new Contact("0904149378","Viet Nam","17/11/2019","incomingCall","Mommy");
        contact4 = new Contact("0987654321","Viet Nam","17/11/2019","incomingCall","Sister");
        contact5 = new Contact("0789321456","Viet Nam","17/11/2019","incomingCall","");
        contact6 = new Contact("0912123768","Viet Nam","17/11/2019","incomingCall","Dad");
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);
        contacts.add(contact5);
        contacts.add(contact6);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.VERTICAL,false);

        contactAdapter = new ContactAdapter(contacts);



        contactAdapter.setIonClickContact(new IonClickContact() {
            @Override
            public void onClickPhone(String phone) {
                Toast.makeText(getBaseContext(), phone, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onClickInformation() {
                Intent intent = new Intent(getBaseContext(), InfoActivity.class);
                //intent.putExtra("oblist", contacts.get(i));
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
