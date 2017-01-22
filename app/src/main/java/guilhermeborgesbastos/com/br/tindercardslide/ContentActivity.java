package guilhermeborgesbastos.com.br.tindercardslide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.BaseAnimationInterface;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class ContentActivity extends AppCompatActivity {

    private SliderLayout mDemoSlider;
    private FrameLayout fl_nope;
    private FrameLayout fl_star;
    private FrameLayout fl_like;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        fl_nope = (FrameLayout) findViewById(R.id.fl_nope);
        fl_star = (FrameLayout) findViewById(R.id.fl_star);
        fl_like = (FrameLayout) findViewById(R.id.fl_like);

        mDemoSlider = (SliderLayout)findViewById(R.id.slider);
        mDemoSlider.setDuration(40000000);


        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal",R.drawable.jihyeon);
        file_maps.put("Big Bang Theory",R.drawable.jihyeon2);
        file_maps.put("House of Cards",R.drawable.jihyeon1);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(null)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);
                  //  .setOnSliderClickListener(this);

            //add your extra information
            /*textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
*/
            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        //mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
        //mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setCustomAnimation(new ChildAnimationExample());

       // mDemoSlider.addOnPageChangeListener(this);

        fl_nope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: 카드뷰 선택하는것으로 이동
            }
        });

        fl_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fl_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public class ChildAnimationExample implements BaseAnimationInterface {

        private final static String TAG = "ChildAnimationExample";

        @Override
        public void onPrepareCurrentItemLeaveScreen(View current) {
            View descriptionLayout = current.findViewById(com.daimajia.slider.library.R.id.description_layout);
            if(descriptionLayout!=null){
                current.findViewById(com.daimajia.slider.library.R.id.description_layout).setVisibility(View.INVISIBLE);
            }
            Log.e(TAG,"onPrepareCurrentItemLeaveScreen called");
        }

        @Override
        public void onPrepareNextItemShowInScreen(View next) {
            View descriptionLayout = next.findViewById(com.daimajia.slider.library.R.id.description_layout);
            if(descriptionLayout!=null){
                next.findViewById(com.daimajia.slider.library.R.id.description_layout).setVisibility(View.INVISIBLE);
            }
            Log.e(TAG,"onPrepareNextItemShowInScreen called");
        }

        @Override
        public void onCurrentItemDisappear(View view) {
            Log.e(TAG,"onCurrentItemDisappear called");
        }

        @Override
        public void onNextItemAppear(View view) {

            View descriptionLayout = view.findViewById(com.daimajia.slider.library.R.id.description_layout);
            if(descriptionLayout!=null){
                view.findViewById(com.daimajia.slider.library.R.id.description_layout).setVisibility(View.INVISIBLE);
//            ValueAnimator animator = ObjectAnimator.ofFloat(
//                    descriptionLayout, "y", -descriptionLayout.getHeight(),
//                    0).setDuration(500);
//            animator.start();
//            new BounceInAnimator().animate(descriptionLayout);
            }
            Log.e(TAG,"onCurrentItemDisappear called");
        }
    }


}
