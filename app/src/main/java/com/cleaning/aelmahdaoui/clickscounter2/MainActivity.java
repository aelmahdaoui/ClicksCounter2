package com.cleaning.aelmahdaoui.clickscounter2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void display (int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.CountLog);
        quantityTextView.setText("" + number);
    }

    //Some comment

    public void submitCount (View view) {
        count = count + 1;
        display(count);
    }

    public void sendEmail ( View view) {
        Intent chooser;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] to = {"info@olympiaschoonmaak.nl","aelmahdaoui@icloud.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Sent from app");
        intent.putExtra(Intent.EXTRA_TEXT, "The app has counted until " + count);
        intent.setType("message/rfc822");
        chooser = Intent.createChooser(intent, "Send Email");
        startActivity(chooser);
    }
}

