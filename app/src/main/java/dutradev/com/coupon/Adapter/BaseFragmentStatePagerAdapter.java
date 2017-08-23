package dutradev.com.coupon.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import dutradev.com.coupon.Helper.FragmentFactory;

/**
 * Created by dutradev on 8/23/17.
 */

public class BaseFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    protected List<FragmentFactory.FragmentType> fragmentTypes;
    protected List<String> titles;

    public BaseFragmentStatePagerAdapter(FragmentManager fm, List<FragmentFactory.FragmentType> fragmentTypes, List<String> titles) {
        super(fm);
        this.fragmentTypes = fragmentTypes;
        this.titles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles == null ? "" : titles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment targetFragment = FragmentFactory.createFragment(fragmentTypes.get(position));
        return targetFragment;
    }

    @Override
    public int getCount() {
        int result = fragmentTypes != null ? fragmentTypes.size() : 0;
        return result;
    }
}
