package com.acorn.overlaycardviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ViewPager vp;
    private String[] imgUrls = new String[]{"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556094759217&di=943686daea0415763a8364d3ac0d8233&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2Fe7abe6079c12527f838195f6b0de9c88bdb0b6cb.jpg"
            , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556094800005&di=ba8f6dbb833600fa76af7850265d1309&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0145b25cade37fa801214168567afc.jpg%401280w_1l_2o_100sh.jpg"
            , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556094815760&di=1abe539eb4691346c07dd44a6bba7383&imgtype=0&src=http%3A%2F%2Fpic.xoyo.com%2Fbbs%2F2010%2F11%2F30%2F10113010300bdf68f9f96b70e4.jpg"
            , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556094832094&di=ceb750ce77ad8699859603b80f6479f5&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F015fa95c67b3d7a801203d22e96898.jpg%401280w_1l_2o_100sh.jpg"
            , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556094846679&di=fb63907df03214def9e4576149ac1b8e&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2Fc9257b7638df71ad54d17de9cc92034741c86236.jpg"
            , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556094860210&di=56a4eba83e1fa1fee69787b35f5b2806&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2F5d3129cc0cc155f696a68eec5356d9387f4c517d.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.example_vp);
        OverlayPageAdapter adapter = new OverlayPageAdapter(this);
        adapter.setImgUrlsAndBindViewPager(vp, imgUrls, 3);
        vp.setAdapter(adapter);
        vp.setCurrentItem(100000); //伪无限循环
    }
}
