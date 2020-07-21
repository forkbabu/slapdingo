package com.applex.snaplingo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    private static final long Splash_time_out = 1000;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash);
        IntroPref introPref = new IntroPref(this);
        ((ImageView) findViewById(R.id.img)).startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
        if (introPref.isFirstTimeLaunch()) {
            new Handler().postDelayed(new Runnable(introPref) {
                /* class com.applex.snaplingo.$$Lambda$Splash$JWGTV92NvgX8DneDCeRcqOLwepw */
                public final /* synthetic */ IntroPref f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    Splash.this.lambda$onCreate$0$Splash(this.f$1);
                }
            }, Splash_time_out);
        } else {
            new Handler().postDelayed(new Runnable() {
                /* class com.applex.snaplingo.Splash.AnonymousClass1 */

                public void run() {
                    Splash.this.startActivity(new Intent(Splash.this, MainActivity2.class));
                    Splash.this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    Splash.this.finish();
                }
            }, Splash_time_out);
        }
    }

    public /* synthetic */ void lambda$onCreate$0$Splash(IntroPref introPref) {
        introPref.setIsFirstTimeLaunch(false);
        startActivity(new Intent(this, Walkthrough.class));
        finish();
    }
}
