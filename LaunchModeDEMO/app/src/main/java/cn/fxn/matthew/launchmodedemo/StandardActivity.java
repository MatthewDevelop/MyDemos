package cn.fxn.matthew.launchmodedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * @author:Matthew
 * @date:2018/6/30
 * @email:guocheng0816@163.com
 * @func:
 */
public class StandardActivity extends BaseActivity {


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.to_standard_activity:
                Intent intent=new Intent(this,StandardActivity.class);
                startActivity(intent);
                break;

            case R.id.to_single_top:
                Intent intent1=new Intent(this,SingleTopActivity.class);
                startActivity(intent1);
                break;
            case R.id.to_single_task:
                Intent intent2=new Intent(this,SingleTaskActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}
