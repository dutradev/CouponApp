package dutradev.com.coupon.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dutradev on 8/23/17.
 */

public class CouponResponse {
    @SerializedName("err_code")
    public String errCode;
    @SerializedName("err_msg")
    public String errMsg;
    @SerializedName("data")
    public List<Coupon> coupons;

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }


}
