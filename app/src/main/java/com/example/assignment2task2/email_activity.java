package com.example.assignment2task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class email_activity extends AppCompatActivity {

    private EditText to;
    private EditText subject;
    private EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_layout);

        to = findViewById(R.id.ed1);
        subject = findViewById(R.id.ed2);
        message = findViewById(R.id.ed3);

        Button b = findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mail();
            }
        });
    }

    private void mail()
    {
        String recipientlist = to.getText().toString();
        String [] recipient = recipientlist.split(",");
        String sub = subject.getText().toString();
        String msg = message.getText().toString();

        Intent i = new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL, recipient);
        i.putExtra(Intent.EXTRA_SUBJECT, sub);
        i.putExtra(Intent.EXTRA_TEXT, msg);
        i.setType("message/rfc822");

        startActivity(Intent.createChooser(i, "Chose an email client"));
        Toast.makeText(this, "Email sent successfully", Toast.LENGTH_SHORT).show();
    }
}