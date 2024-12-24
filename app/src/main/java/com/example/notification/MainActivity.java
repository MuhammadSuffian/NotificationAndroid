package com.example.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.notification.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initlization();
    }
    void initlization(){
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        createChannel();
        binding.btnNotify.setOnClickListener(v->{
            if(binding.etInputMsg.getText().toString().trim().isEmpty()){
                binding.etInputMsg.setError("Please enter message");
                binding.etInputMsg.requestFocus();
                Snackbar.make(binding.getRoot(),"Please enter message",Snackbar.LENGTH_SHORT).show();
                return;
            }
            else{
                Intent i=new Intent(this,MainActivity2.class);
                PendingIntent p1=PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_IMMUTABLE);
                NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"MyChannel")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Lumber 1 Notification")
                        .setContentText(binding.etInputMsg.getText().toString())
                        .setContentIntent(p1).setAutoCancel(true);
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(1,builder.build());
            }
        });
    }

    public void createChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            String channelId="MyChannel";
            String channelName="Lumber 1 app ka notifcations";
            String channelDes="LAB9 Class";
            int importance= NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel=new NotificationChannel(channelId,channelName,importance);
            channel.setDescription(channelDes);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}