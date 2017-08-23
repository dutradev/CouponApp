package dutradev.com.coupon.MainScreen.CouponTab;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dutradev.com.coupon.Helper.FragmentFactory;
import dutradev.com.coupon.Model.Coupon;
import dutradev.com.coupon.Model.CouponResponse;
import dutradev.com.coupon.R;
import dutradev.com.coupon.Retrofit.CouponService;
import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CouponFragment extends Fragment {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    CircleIndicator indicator;

    CouponAdapter adapter;

    public static CouponFragment newInstance() {
        CouponFragment fragment = new CouponFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_coupon, container, false);
        ButterKnife.bind(this, v);
        setupView();
        getData();
        return v;
    }

    void setupView() {
        setupViewPager();
        setupIndicator();
    }

    void setupViewPager() {
        adapter = new CouponAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
    }

    void setupIndicator() {
        indicator.setViewPager(viewPager);
    }

    void getData() {
        adapter.coupons.clear();

        Call<CouponResponse> call = CouponService.sharedInstance.service.getCoupons();
        call.enqueue(new Callback<CouponResponse>() {
            @Override
            public void onResponse(Call<CouponResponse> call, Response<CouponResponse> response) {
                if (response != null && response.body() != null) {
                    final List<Coupon> coupons = response.body().coupons;
                    Handler hd = new Handler(Looper.getMainLooper());
                    hd.post(new Runnable() {
                        @Override
                        public void run() {
                            adapter.coupons.addAll(coupons);
                            adapter.notifyDataSetChanged();
                            indicator.setViewPager(null);
                            indicator.setViewPager(viewPager);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<CouponResponse> call, Throwable t) {

            }
        });
    }
}

class CouponAdapter extends FragmentStatePagerAdapter {

    List<Coupon> coupons = new ArrayList<>();
    public CouponAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return coupons == null ? 0 : coupons.size();
    }

    @Override
    public Fragment getItem(int position) {
        CouponSumaryFragment couponSumaryFragment = (CouponSumaryFragment) FragmentFactory.createFragment(FragmentFactory.FragmentType.CouponSumary);
        couponSumaryFragment.coupon = coupons.get(position);

        return couponSumaryFragment;
    }
}
