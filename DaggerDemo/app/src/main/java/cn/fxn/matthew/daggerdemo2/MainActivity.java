package cn.fxn.matthew.daggerdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

/**
 * @author Matthew
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

//    @Sign("hasDriver")
//    @Inject
//    Bus mBus;

    Bus mBus;
    @Inject
    void injectBus(/*@Sign("hasDriver") */Bus bus) {
        this.mBus = bus;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParkingComponent component=DaggerParkingComponent.create();
        component.inject(this);
        Log.e(TAG, "onCreate: "+mBus );
        component.inject(this);
        Log.e(TAG, "onCreate: "+mBus );
//        DaggerParkingComponent.builder()
//                .parkingModule(new ParkingModule("楼下小李"))
//                .build()
//                .inject(this);
//        Log.e(TAG, "onCreate: " + mBus.toString());
    }
}
