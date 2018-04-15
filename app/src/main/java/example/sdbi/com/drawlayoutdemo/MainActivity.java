package example.sdbi.com.drawlayoutdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private List<DrawLayoutLeftMenu> lists=new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawlayout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        initActionBarDrawerToggle();
        drawerLayout.addDrawerListener(listener);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        listView = (ListView) findViewById(R.id.lv_leftMenu);
        initData();
        DrawLayoutLeftMenuAdapter adapter = new DrawLayoutLeftMenuAdapter(this,lists);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        drawerLayout.closeDrawers();
                        toolbar.setTitle("路况查询");
                        toolbar.setTitleTextColor(Color.WHITE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment,new LuKuangChaXunFragment());
                        break;
                    case 1:
                        drawerLayout.closeDrawers();
                        toolbar.setTitleTextColor(Color.WHITE);
                        toolbar.setTitle("车辆违章");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment,new CheLiangWeiZhangFragment());
                        break;
                    case 2:
                        drawerLayout.closeDrawers();
                        toolbar.setTitleTextColor(Color.WHITE);
                        toolbar.setTitle("公交查询");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment,new GongJiaoChaXunFragment());
                        break;
                    case 3:
                        drawerLayout.closeDrawers();
                        toolbar.setTitleTextColor(Color.WHITE);
                        toolbar.setTitle("账户管理");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment,new ZhangHuGuanLiFragment());
                        break;
                    case 4:
                        drawerLayout.closeDrawers();
                        toolbar.setTitleTextColor(Color.WHITE);
                        toolbar.setTitle("红绿灯管理");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment,new HongLvDengGuanLiFragment());
                        break;
                    case 5:
                        toolbar.setTitleTextColor(Color.WHITE);
                        drawerLayout.closeDrawers();
                        toolbar.setTitle("个人中心");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment,new GeRenZhongXinFragment());
                        break;
                    case 6:
                        toolbar.setTitleTextColor(Color.WHITE);
                        drawerLayout.closeDrawers();
                        toolbar.setTitle("生活助手");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment,new ShengHuoZhuShouFragment());
                        break;
                    case 7:
                        toolbar.setTitleTextColor(Color.WHITE);
                        drawerLayout.closeDrawers();
                        toolbar.setTitle("数据分析");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment,new ShuJuFenXiFragment());
                        break;
                    case 8:
                        toolbar.setTitleTextColor(Color.WHITE);
                        drawerLayout.closeDrawers();
                        toolbar.setTitle("创意题");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment,new ChuangYiTiFragment());
                        break;
                    case 9:
                        toolbar.setTitleTextColor(Color.WHITE);
                        drawerLayout.closeDrawers();
                        toolbar.setTitle("环境指标");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment,new HuanJingZhiBiaoFragment());
                        break;
                }
            }
        });


    }

    /**
     * menu 开关图片切换效果
     */
    private void initActionBarDrawerToggle() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, R.string.open, R.string.close);
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    /**
     * 侧滑移动效果
     */
    private DrawerLayout.DrawerListener listener = new DrawerLayout.SimpleDrawerListener() {
        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            super.onDrawerSlide(drawerView, slideOffset);
            View content = drawerLayout.getChildAt(0);
            int offect = (int) (drawerView.getWidth() * slideOffset);
            content.setTranslationX(offect);
        }
    };

    /**
     * 初始化左边menu 数据
     */
    private void initData(){
        lists.add(new DrawLayoutLeftMenu(R.mipmap.ic_launcher,"路况查询"));
        lists.add(new DrawLayoutLeftMenu(R.mipmap.ic_launcher,"车辆违章"));
        lists.add(new DrawLayoutLeftMenu(R.mipmap.ic_launcher,"公交查询"));
        lists.add(new DrawLayoutLeftMenu(R.mipmap.ic_launcher,"账户管理"));
        lists.add(new DrawLayoutLeftMenu(R.mipmap.ic_launcher,"红绿灯管理"));
        lists.add(new DrawLayoutLeftMenu(R.mipmap.ic_launcher,"个人中心"));
        lists.add(new DrawLayoutLeftMenu(R.mipmap.ic_launcher,"生活助手"));
        lists.add(new DrawLayoutLeftMenu(R.mipmap.ic_launcher,"数据分析"));
        lists.add(new DrawLayoutLeftMenu(R.mipmap.ic_launcher,"环境指标"));
        lists.add(new DrawLayoutLeftMenu(R.mipmap.ic_launcher,"路况查询"));

    }
}
