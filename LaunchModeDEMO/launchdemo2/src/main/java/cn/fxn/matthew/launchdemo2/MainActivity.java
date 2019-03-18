package cn.fxn.matthew.launchdemo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.to_single_task:
                Intent intent2 = new Intent(this, SingleTaskActivity2.class);
                startActivity(intent2);
                break;
            case R.id.to_single_instance:
                Intent intent=new Intent();
                intent.setAction("cn.fxn.matthew.launchmodedemo.singleinstance");
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
