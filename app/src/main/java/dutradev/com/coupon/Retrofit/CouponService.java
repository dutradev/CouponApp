package dutradev.com.coupon.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dutradev on 8/23/17.
 */

public class CouponService {
    public static CouponService sharedInstance = new CouponService();
    public Retrofit retrofit;
    public CouponInterface service;
    private CouponService() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://test-server-1336.firebaseapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(CouponInterface.class);
    }
}
