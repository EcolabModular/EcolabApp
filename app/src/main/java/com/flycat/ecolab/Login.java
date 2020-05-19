package com.flycat.ecolab;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.richpath.RichPath;
import com.richpath.RichPathView;
import com.richpathanimator.RichPathAnimator;

import pub.devrel.easypermissions.EasyPermissions;

public class Login extends AppCompatActivity {

    private RichPathView commandRichPathView;
    private Button btLogin;
    private TextView tvRegistrar;
    private TextView tvForgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO};
        if (!EasyPermissions.hasPermissions(this, perms)) {
            Log.d("Permisos: ", perms.toString());
            EasyPermissions.requestPermissions(this, "¡Permisos necesarios para el correcto uso de la aplicación!",
                    123, perms);
        }

        commandRichPathView = findViewById(R.id.ic_command);
        btLogin = findViewById(R.id.btLogin);
        tvRegistrar = findViewById(R.id.tvRegistro);
        tvForgotPass = findViewById(R.id.tvForgotPassword);



        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, ScanQR.class));
            }
        });

        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

        new Thread ( new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        animateCommand();
                    }
                });
            }

        }).start();
    }

    public void animateCommand() {

        final RichPath part1 = commandRichPathView.findRichPathByName("part1");
        final RichPath part2 = commandRichPathView.findRichPathByName("part2");
        final RichPath part3 = commandRichPathView.findRichPathByName("part3");
        final RichPath part4 = commandRichPathView.findRichPathByName("part4");
        final RichPath part5 = commandRichPathView.findRichPathByName("part5");
        final RichPath part6 = commandRichPathView.findRichPathByName("part6");
        final RichPath part7 = commandRichPathView.findRichPathByName("part7");
        final RichPath part8 = commandRichPathView.findRichPathByName("part8");

        RichPathAnimator
                .animate(part1)
                .trimPathOffset(0, 1.0f)

                .andAnimate(part2)
                .trimPathOffset(0.125f, 1.125f)

                .andAnimate(part3)
                .trimPathOffset(0.250f, 1.250f)

                .andAnimate(part4)
                .trimPathOffset(0.375f, 1.375f)

                .andAnimate(part5)
                .trimPathOffset(0.500f, 1.500f)

                .andAnimate(part6)
                .trimPathOffset(0.625f, 1.625f)

                .andAnimate(part7)
                .trimPathOffset(0.750f, 1.750f)

                .andAnimate(part8)
                .trimPathOffset(0.875f, 1.875f)

                .durationSet(2000)
                .repeatModeSet(RichPathAnimator.RESTART)
                .repeatCountSet(RichPathAnimator.REVERSE)
                .interpolatorSet(new LinearInterpolator())
                .start();
    }

}
