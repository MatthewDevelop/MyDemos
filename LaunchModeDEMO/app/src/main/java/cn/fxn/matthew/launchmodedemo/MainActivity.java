package cn.fxn.matthew.launchmodedemo;

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
            case R.id.toStandardActivity:
                Intent intent=new Intent(this,StandardActivity.class);
                startActivity(intent);
                break;
            case R.id.toSingleTopActivity:
                Intent intent1=new Intent(this,SingleTopActivity.class);
                startActivity(intent1);
                break;
            case R.id.toSingleTaskActivity:
                Intent intent2=new Intent(this,SingleTaskActivity.class);
                startActivity(intent2);
                break;
            case R.id.toSingleInstanceActivity:
                Intent intent3=new Intent(this,SingleInstanceActivity.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }
}
