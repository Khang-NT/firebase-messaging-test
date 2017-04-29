package com.khangnt.fbmessing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText topicName = (EditText) findViewById(R.id.edTopicName);

        findViewById(R.id.bSubscribe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topic = topicName.getText().toString();
                if (!TextUtils.isEmpty(topic))
                    FirebaseMessaging.getInstance().subscribeToTopic(topic);
            }
        });

        findViewById(R.id.bUnSubscribe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topic = topicName.getText().toString();
                if (!TextUtils.isEmpty(topic))
                    FirebaseMessaging.getInstance().unsubscribeFromTopic(topic);
            }
        });
    }
}
