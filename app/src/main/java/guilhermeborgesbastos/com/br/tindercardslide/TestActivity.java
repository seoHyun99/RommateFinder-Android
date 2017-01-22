package guilhermeborgesbastos.com.br.tindercardslide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
;

/**
 * Created by 이서현 on 2016-12-18.
 */

public class TestActivity extends AppCompatActivity {
    private int[] arr_image;
    private String[] arr_blueButton = new String[5];
    private String[] arr_redButton = new String[5];
    private boolean[] result = new boolean[6];
    private int arr_index = 0;

    private Button blueButton, redButton;
    private ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        blueButton = (Button) findViewById(R.id.blueBtn);
        redButton = (Button) findViewById(R.id.redBtn);
        image = (ImageView) findViewById(R.id.test_explainImage);

        initArr();

        image.setImageResource(R.drawable.test_clean);
        blueButton.setText("청소는 바로바로 해야한다");
        redButton.setText("청소는 몰아서 해야한다");

        blueButton.setOnClickListener(onClickListener);
        redButton.setOnClickListener(onClickListener);
    }

    private void initArr() {
        arr_image = new int[]{R.drawable.test_friend, R.drawable.test_buy, R.drawable.test_cook, R.drawable.test_nocturnal, R.drawable.test_earphone}; // 집에 손님 초대, 생활용품 공동구매, 직접 요리/배달, 주행성/야행성, 이어폰

        arr_blueButton[0] = "집에 손님 초대하는 것을 좋아한다";
        arr_blueButton[1] = "생활용품은 공동구매를 한다";
        arr_blueButton[2] = "배달의 민족형";
        arr_blueButton[3] = "주행성";
        arr_blueButton[4] = "룸메와 함께 있을 때 이어폰을 껴야한다";

        arr_redButton[0] = "집에 손님 초대하는 것을 싫어한다";
        arr_redButton[1] = "생활용품은 각자가 알아서 한다";
        arr_redButton[2] = "냉장고를 부탁해";
        arr_redButton[3] = "야행성";
        arr_redButton[4] = "룸메와 함께 있을 때 이어폰을 끼지 않는다";
    }


    Button.OnClickListener onClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("index", arr_index + "");

            //blueBtn이 클릭될 경우 true, redBtn이 클릭될 경우 false -> result 배열에 결과값이 저장됨.
            switch (view.getId()) {
                case R.id.blueBtn:
                    result[arr_index] = true;
                    break;
                case R.id.redBtn:
                    result[arr_index] = false;
                    break;
            }

            Log.d("result arr", result.toString() + "  " +arr_index);

            //다음 테스트로 넘어가기
            image.setImageResource(arr_image[arr_index]);
            blueButton.setText(arr_blueButton[arr_index]);
            redButton.setText(arr_redButton[arr_index]);

            arr_index++;

            if (arr_index == 5) {
                Intent i = new Intent(getBaseContext(), ShowMyCharacterActivity.class);
                startActivity(i);
                finish();
            }
        }
    };

}
