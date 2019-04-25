# OverlayCardViewPager 层叠卡片效果的ViewPage

![github](https://github.com/oneAcorn/OverlayCardViewPager/blob/master/20190424_141920.gif)

<p>使用PageTransformer实现的层叠卡片效果ViewPager</p>

<h4>使用方法</h4>
<p>
1.在root build.gradle中加入
  
```Gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

2.在项目的 build.gradle中加入

```Gradle
dependencies {
	        implementation 'com.github.oneAcorn:OverlayCardViewPager:v1.0'
	}
```
本项目minSdkVersion为15,如出现
ERROR: Manifest merger failed : uses-sdk:minSdkVersion xx cannot be smaller than version 15
请修改引用项目的minSdkVersion

最后
```Java
SimpleOverlayAdapter adapter = new SimpleOverlayAdapter(this);
adapter.setImgUrlsAndBindViewPager(vp, imgUrls, 3);
vp.setAdapter(adapter);
vp.setCurrentItem(100000); //伪无限循环
```
也可以自己继承BaseOverlayPageAdapter,并把ViewPager item相关布局中的ImageView的Id设置为card_iv.
  </p>
