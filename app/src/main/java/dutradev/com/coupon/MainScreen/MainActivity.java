package dutradev.com.coupon.MainScreen;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import devlight.io.library.ntb.NavigationTabBar;
import dutradev.com.coupon.Adapter.BaseFragmentStatePagerAdapter;
import dutradev.com.coupon.Helper.DeprecatedHelper;
import dutradev.com.coupon.Helper.FragmentFactory;
import dutradev.com.coupon.R;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabbar)
    NavigationTabBar tabbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        mDrawerToggle = setupDrawerToggle();

        mDrawer.addDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();
        setupView();
    }

    void setupView() {
        setupViewPagerCoupon();
        setupTabbar();
    }

    void setupViewPagerCoupon() {
        viewPager.setAdapter(new ViewPagerFragmentAdapter(getSupportFragmentManager()));
    }

    void setupTabbar() {
        List<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(makeModel(R.drawable.ic_home, "Home"));
        models.add(makeModel(R.drawable.ic_shop, "Shop"));
        models.add(makeModel(R.drawable.ic_camera, "Camera"));
        models.add(makeModel(R.drawable.ic_coupon, "Coupon"));
        models.add(makeModel(R.drawable.ic_chat, "Chat"));
//        models.add(
//                new NavigationTabBar.Model.Builder(
//                        getResources().getDrawable(R.drawable.ic_chat),
//                        Color.TRANSPARENT
//                ).title("Chat")
//                        .badgeTitle("5")
//                        .build()
//        );
        tabbar.setModels(models);
        tabbar.setViewPager(viewPager, 3);
        tabbar.setTypeface("fonts/Roboto-Bold.ttf");

    }

    NavigationTabBar.Model makeModel(int icon, String title) {
        return new NavigationTabBar.Model.Builder(DeprecatedHelper.getResourceDrawable(icon, this), Color.TRANSPARENT).title(title).build();
    }
    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}

class ViewPagerFragmentAdapter extends BaseFragmentStatePagerAdapter {

    public ViewPagerFragmentAdapter(FragmentManager fm) {
        super(fm, Arrays.asList(FragmentFactory.FragmentType.Home,
                FragmentFactory.FragmentType.Shop,
                FragmentFactory.FragmentType.Camera,
                FragmentFactory.FragmentType.Coupon,
                FragmentFactory.FragmentType.Chat), null);
    }
}


