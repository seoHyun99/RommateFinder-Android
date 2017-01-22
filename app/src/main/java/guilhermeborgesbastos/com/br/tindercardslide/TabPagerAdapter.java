package guilhermeborgesbastos.com.br.tindercardslide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import guilhermeborgesbastos.com.br.tindercardslide.fragment.SlideCardFragment;

/**
 * Created by 이서현 on 2016-12-17.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;

    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                MyPageFragment f1 = new MyPageFragment();
                return f1;
            case 1:
                SlideCardFragment f2 = new SlideCardFragment();
                return f2;
            case 2:
                ChatFragment f3 = new ChatFragment();
                return f3;
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return tabCount;
    }
}
