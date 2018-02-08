package com.example.chenye.intent_tansfer_result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
   // private Button addBtn, mulBtn;
    private final static int ADDREQUESTCODE = 1; // 返回的结果码
    private final static int MULREQUESTCODE = 2; // 返回的结果码

    private EditText addNum1, addNum2, addResult, mulNum1, mulNum2, mulResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // addBtn  = this.findViewById(R.id.addBtn);
        addNum1 = this.findViewById(R.id.addNum1);
        addNum2 = this.findViewById(R.id.addNum2);
        addResult = this.findViewById(R.id.addResult);

        mulNum1 = this.findViewById(R.id.mulNum1);
        mulNum2 = this.findViewById(R.id.mulNum2);
        mulResult = this.findViewById(R.id.mulResult);
       // mulBtn  = this.findViewById(R.id.mulBtn);




    }

    public void addBtn(View view) {
        int a = Integer.parseInt(addNum1.getText().toString());
        int b = Integer.parseInt(addNum2.getText().toString());
        Intent intent = new Intent(this, addResultActivity.class);
        intent.putExtra("a", a);
        intent.putExtra("b", b);
        //启动Intent
        startActivityForResult(intent, ADDREQUESTCODE);  // 表示可以获取结果
    }


    public void mulBtn(View view) {
        int a = Integer.parseInt(mulNum1.getText().toString());
        int b = Integer.parseInt(mulNum2.getText().toString());
        Intent intent = new Intent(this, mulResultActivity.class);
        intent.putExtra("a", a);
        intent.putExtra("b", b);
        //启动Intent
        startActivityForResult(intent, MULREQUESTCODE);  // 表示可以获取结果
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 2){
            if(requestCode == ADDREQUESTCODE){
                int addResultValue = data.getIntExtra("addResultValue", 0);
                addResult.setText(String.valueOf(addResultValue));
            }
            if(requestCode == MULREQUESTCODE){
                int addResultValue = data.getIntExtra("mulResultValue", 0);
                mulResult.setText(String.valueOf(addResultValue));

            }

        }
        /*
        if(resultCode == 2){
            if(requestCode == REQUESTCODE){
                int addResultValue = data.getIntExtra("mulResultValue", 0);
                mulResult.setText(String.valueOf(addResultValue));
            }
        }
        */
    }


}
