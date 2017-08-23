package dutradev.com.coupon.Retrofit;

import dutradev.com.coupon.Model.CouponResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dutradev on 8/23/17.
 */

public interface CouponInterface {
    @GET("getCoupons.json")
    Call<CouponResponse> getCoupons();
}