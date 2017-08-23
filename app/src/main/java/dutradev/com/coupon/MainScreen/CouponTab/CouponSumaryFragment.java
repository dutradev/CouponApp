package dutradev.com.coupon.MainScreen.CouponTab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import dutradev.com.coupon.Model.Coupon;
import dutradev.com.coupon.R;
public class CouponSumaryFragment extends Fragment {
    @BindView(R.id.tvContent)
    TextView tvContent;
    @BindView(R.id.imvCover)
    ImageView imvCover;
    @BindView(R.id.tvDeal)
    TextView tvDeal;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvDescription)
    TextView tvDescription;
    @BindView(R.id.tvCategory)
    TextView tvCategory;
    @BindView(R.id.btnShowDetail)
    TextView btnShowDetail;

    public Coupon coupon;

    public static CouponSumaryFragment newInstance() {
        CouponSumaryFragment fragment = new CouponSumaryFragment();
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
        View v = inflater.inflate(R.layout.fragment_coupon_sumary, container, false);
        ButterKnife.bind(this, v);
        setData();
        return v;
    }

    void setData() {
        if (coupon == null) {
            return;
        }

        tvContent.setText(coupon.content);
        tvDeal.setText("-" + coupon.deal + "%");
        tvName.setText(coupon.name);
        tvDescription.setText(coupon.detail);
        tvCategory.setText(coupon.category);

        Glide.with(this.getContext())
                .load(coupon.cover)
                .asBitmap()
                .centerCrop()
                .into(imvCover);
    }
}
