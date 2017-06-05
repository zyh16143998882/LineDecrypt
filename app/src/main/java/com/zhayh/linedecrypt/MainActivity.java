package com.zhayh.linedecrypt;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_androidID = null;
    private EditText et_cipherText = null;
    private TextView tv_content = null;
    private Button btn_getContent = null;
    private Long longValue = 15485863L;
    private String content = null;
    private CharSequence cs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_androidID = (TextView) findViewById(R.id.tv_androidID);
        et_cipherText = (EditText) findViewById(R.id.et_cipherText);
        tv_content = (TextView) findViewById(R.id.tv_content);
        btn_getContent = (Button) findViewById(R.id.btn_getContent);


        cs = Settings.Secure.getString(this.getContentResolver(),"android_id");
        tv_androidID.append(cs.toString());

        btn_getContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content = AESDecryotUtil.decrypt(Long.valueOf(longValue),et_cipherText.getText().toString().trim(),cs.toString());
                tv_content.setText(content);
            }
        });
    }
}
