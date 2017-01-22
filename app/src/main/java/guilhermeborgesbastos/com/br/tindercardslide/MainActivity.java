package guilhermeborgesbastos.com.br.tindercardslide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import guilhermeborgesbastos.com.br.tindercardslide.fragment.SlideCardFragment;

/**
 * Created by 이서현 on 2016-12-17.
 */

public class MainActivity extends AppCompatActivity {

    Fragment[] arrFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        arrFragments = new Fragment[3];
        arrFragments[0] = new MyPageFragment();
        arrFragments[1] = new SlideCardFragment();
        arrFragments[2] = new ChatFragment();

        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), arrFragments);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }



    class MainPagerAdapter extends FragmentPagerAdapter {

        Fragment[] arrFragments;

        public MainPagerAdapter(FragmentManager fm, Fragment[] arrFragments) {
            super(fm);
            this.arrFragments = arrFragments;
        }




        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "설정";
                case 1:
                    return "매칭";
                case 2:
                    return "채팅";

                default:
                    return "";
            }
        }

        @Override
        public Fragment getItem(int position) {
            return arrFragments[position];
        }

        @Override
        public int getCount() {
            return arrFragments.length;
        }
    }
}
