package guilhermeborgesbastos.com.br.tindercardslide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by 이서현 on 2016-12-18.
 */

public class Confirm2Activity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        editText = (EditText) findViewById(R.id.inputConfirm);
        button = (Button) findViewById(R.id.confirmNextButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), TestActivity.class);
                startActivity(i);
                finish();
            }
        });

        editText.addTextChangedListener(textWatcherInput);
    }

    TextWatcher textWatcherInput = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (editText.getText().length() > 0) {
                button.setVisibility(View.VISIBLE);
            } else {
                button.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}
