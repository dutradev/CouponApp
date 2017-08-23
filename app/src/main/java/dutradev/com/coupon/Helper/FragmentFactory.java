package dutradev.com.coupon.Helper;

import android.support.v4.app.Fragment;

import dutradev.com.coupon.MainScreen.CameraTab.CameraFragment;
import dutradev.com.coupon.MainScreen.ChatTab.ChatFragment;
import dutradev.com.coupon.MainScreen.CouponTab.CouponFragment;
import dutradev.com.coupon.MainScreen.CouponTab.CouponSumaryFragment;
import dutradev.com.coupon.MainScreen.HomeTab.HomeFragment;
import dutradev.com.coupon.MainScreen.ShopTab.ShopFragment;

/**
 * Created by dutradev on 8/23/17.
 */

public class FragmentFactory {
    public enum FragmentType {
        Home,
        Shop,
        Camera,
        Coupon,
        Chat,
        CouponSumary
    }

    public static Fragment createFragment(FragmentType fragmentType) {
        switch (fragmentType) {
            case Home:
                return HomeFragment.newInstance();
            case Shop:
                return ShopFragment.newInstance();
            case Camera:
                return CameraFragment.newInstance();
            case Coupon:
                return CouponFragment.newInstance();
            case Chat:
                return ChatFragment.newInstance();
            case CouponSumary:
                return CouponSumaryFragment.newInstance();
        }

        return null;
    }
}
