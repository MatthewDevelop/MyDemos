package cn.fxn.matthew.daggerdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Inject
    Child mChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FatherComponent fatherComponent = DaggerFatherComponent.create();
        ChildComponent childComponent = DaggerChildComponent.builder()
                .fatherComponent(fatherComponent)
                .build();
        childComponent.inject(this);
        Log.e(TAG, "onCreate: " + (mChild == null));
    }
}
