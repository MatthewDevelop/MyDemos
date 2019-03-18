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
public class SingleTaskActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.to_standard:
                Intent intent=new Intent(this,StandardActivity.class);
                startActivity(intent);
                break;
            case R.id.to_single_task:
                Intent intent1=new Intent(this,SingleTaskActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }

}
