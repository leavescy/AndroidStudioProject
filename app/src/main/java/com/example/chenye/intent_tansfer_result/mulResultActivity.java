package com.example.chenye.intent_tansfer_result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by chenye on 2018/2/7.
 */

public class mulResultActivity extends Activity {
   // private Button button;
    private TextView textView;
    private EditText editText, otherEditText;
    private static final int OTHERREQUESTCODE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mulresult);
        //button = findViewById(R.id.Button);
        textView = this.findViewById(R.id.mulmsg);
        editText = this.findViewById(R.id.mulResult);
        otherEditText = this.findViewById(R.id.otherEditText);
        Intent intent = getIntent();
        int a = intent.getIntExtra("a", 0);
        int b = intent.getIntExtra("b", 0);
        textView.setText(a + "*" + b + "=" + "?");
    }

    public void mulBtn(View view) {
        Intent intent = new Intent();
        int mulResultValue = Integer.parseInt(editText.getText().toString());
        intent.putExtra("mulResultValue", mulResultValue);
        // 通过Intent对象返回结果，setResult方法
        setResult(2, intent);
        finish();  // 表示结束当前Activity的生命周期

    }


    public void otherBtn(View view) {
        Intent intent = new Intent(mulResultActivity.this, otherActivity.class);
        String msg = otherEditText.getText().toString();
        intent.putExtra("sendMsg", msg);
        startActivityForResult(intent, OTHERREQUESTCODE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 2){
            if(requestCode == OTHERREQUESTCODE){
                String returnMsg = data.getStringExtra("returnMsg");
                otherEditText.setText(returnMsg);
            }
        }
    }
}
