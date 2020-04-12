package com.e.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "mike");

                setResult(Activity.RESULT_OK, intent);  //extra데이터를 전달을 하겠다.

                finish();  //메뉴화면을 없앤다는 의미, 그러면 메인 화면을 보는겁니다.
                //화면을 전환한다는 의미는 이전 화면을 뒤로 깔고 간다는 의미입니다. 이것은 액티비티 스택에서 알아서 저장을 하는 겁니다.

            }
        });
    }
}
