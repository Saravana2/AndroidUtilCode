package com.blankj.androidutilcode.core.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.androidutilcode.Config;
import com.blankj.androidutilcode.R;
import com.blankj.androidutilcode.base.BaseBackActivity;
import com.blankj.androidutilcode.core.image.ImageActivity;
import com.blankj.utilcode.util.ActivityUtils;

import java.util.Random;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/10/13
 *     desc  : Activity工具类Demo
 * </pre>
 */
public class ActivityActivity extends BaseBackActivity {

    ImageView viewSharedElement;
    Random random = new Random();
    private Bitmap bitmap;
    private Intent intent;
    private Intent[] intents = new Intent[2];

    public static void start(Context context) {
        Intent starter = new Intent(context, ActivityActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        return R.layout.activity_activity;
    }


    @Override
    public void initView(Bundle savedInstanceState, View view) {
        getToolBar().setTitle(getString(R.string.demo_activity));
        viewSharedElement = (ImageView) findViewById(R.id.view_shared_element);
        findViewById(R.id.btn_clz).setOnClickListener(this);
        findViewById(R.id.btn_clz_opt).setOnClickListener(this);
        findViewById(R.id.btn_clz_anim).setOnClickListener(this);
        findViewById(R.id.btn_act_clz).setOnClickListener(this);
        findViewById(R.id.btn_act_clz_opt).setOnClickListener(this);
        findViewById(R.id.btn_act_clz_shared_element).setOnClickListener(this);
        findViewById(R.id.btn_act_clz_anim).setOnClickListener(this);
        findViewById(R.id.btn_pkg_cls).setOnClickListener(this);
        findViewById(R.id.btn_pkg_cls_opt).setOnClickListener(this);
        findViewById(R.id.btn_pkg_cls_anim).setOnClickListener(this);
        findViewById(R.id.btn_act_pkg_cls).setOnClickListener(this);
        findViewById(R.id.btn_act_pkg_cls_opt).setOnClickListener(this);
        findViewById(R.id.btn_act_pkg_cls_shared_element).setOnClickListener(this);
        findViewById(R.id.btn_act_pkg_cls_anim).setOnClickListener(this);
        findViewById(R.id.btn_intent).setOnClickListener(this);
        findViewById(R.id.btn_intent_opt).setOnClickListener(this);
        findViewById(R.id.btn_intent_shared_element).setOnClickListener(this);
        findViewById(R.id.btn_intent_anim).setOnClickListener(this);
        findViewById(R.id.btn_intents).setOnClickListener(this);
        findViewById(R.id.btn_intents_opt).setOnClickListener(this);
        findViewById(R.id.btn_intents_anim).setOnClickListener(this);
        findViewById(R.id.btn_act_intents).setOnClickListener(this);
        findViewById(R.id.btn_act_intents_opt).setOnClickListener(this);
        findViewById(R.id.btn_act_intents_anim).setOnClickListener(this);
        findViewById(R.id.btn_act_clz_shared_element).setOnClickListener(this);
        findViewById(R.id.btn_start_home_activity).setOnClickListener(this);
        findViewById(R.id.btn_finish_all_activities).setOnClickListener(this);
        TextView tvAboutActivity = (TextView) findViewById(R.id.tv_about_activity);
        tvAboutActivity.setText("Is ImageActivity Exists: " + ActivityUtils.isActivityExists(Config.PKG, SharedElementActivityActivity.class.getName())
                + "\ngetLauncherActivity: " + ActivityUtils.getLauncherActivity(Config.PKG)
                + "\ngetTopActivity: " + ActivityUtils.getTopActivity()
        );
        bitmap = ((BitmapDrawable) viewSharedElement.getDrawable()).getBitmap();

        intent = new Intent(this, SharedElementActivityActivity.class);
        intents[0] = intent;
        intents[1] = new Intent(this, SharedElementActivityActivity.class);
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()) {
            case R.id.btn_clz:
                ActivityUtils.startActivity(SharedElementActivityActivity.class);
                break;
            case R.id.btn_clz_opt:
                ActivityUtils.startActivity(SharedElementActivityActivity.class,
                        getOption(random.nextInt(5)));
                break;
            case R.id.btn_clz_anim:
                ActivityUtils.startActivity(SharedElementActivityActivity.class,
                        R.anim.fade_in_1000, R.anim.fade_out_1000);
                break;
            case R.id.btn_act_clz:
                ActivityUtils.startActivity(this,
                        SharedElementActivityActivity.class);
                break;
            case R.id.btn_act_clz_opt:
                ActivityUtils.startActivity(this,
                        SharedElementActivityActivity.class,
                        getOption(random.nextInt(5)));
                break;

            case R.id.btn_act_clz_shared_element:
                ActivityUtils.startActivity(this,
                        SharedElementActivityActivity.class,
                        viewSharedElement);
                break;
            case R.id.btn_act_clz_anim:
                ActivityUtils.startActivity(this,
                        SharedElementActivityActivity.class,
                        R.anim.fade_in_1000, R.anim.fade_out_1000);
                break;
            case R.id.btn_pkg_cls:
                ActivityUtils.startActivity(this.getPackageName(),
                        SharedElementActivityActivity.class.getName());
                break;
            case R.id.btn_pkg_cls_opt:
                ActivityUtils.startActivity(this.getPackageName(),
                        SharedElementActivityActivity.class.getName(),
                        getOption(random.nextInt(5)));
                break;
            case R.id.btn_pkg_cls_anim:
                ActivityUtils.startActivity(this.getPackageName(),
                        SharedElementActivityActivity.class.getName(),
                        R.anim.fade_in_1000, R.anim.fade_out_1000);
                break;
            case R.id.btn_act_pkg_cls:
                ActivityUtils.startActivity(this,
                        this.getPackageName(),
                        SharedElementActivityActivity.class.getName());
                break;
            case R.id.btn_act_pkg_cls_opt:
                ActivityUtils.startActivity(this,
                        this.getPackageName(),
                        SharedElementActivityActivity.class.getName(),
                        getOption(random.nextInt(5)));
                break;
            case R.id.btn_act_pkg_cls_shared_element:
                ActivityUtils.startActivity(this,
                        this.getPackageName(),
                        SharedElementActivityActivity.class.getName(),
                        viewSharedElement);
                break;
            case R.id.btn_act_pkg_cls_anim:
                ActivityUtils.startActivity(this,
                        this.getPackageName(),
                        SharedElementActivityActivity.class.getName(),
                        R.anim.fade_in_1000, R.anim.fade_out_1000);
                break;
            case R.id.btn_intent:
                ActivityUtils.startActivity(this,
                        intent);
                break;
            case R.id.btn_intent_opt:
                ActivityUtils.startActivity(this,
                        intent,
                        getOption(random.nextInt(5)));
                break;
            case R.id.btn_intent_shared_element:
                ActivityUtils.startActivity(this,
                        intent,
                        viewSharedElement);
                break;
            case R.id.btn_intent_anim:
                ActivityUtils.startActivity(this,
                        intent,
                        R.anim.fade_in_1000, R.anim.fade_out_1000);
                break;
            case R.id.btn_intents:
                ActivityUtils.startActivities(intents);
                break;
            case R.id.btn_intents_opt:
                ActivityUtils.startActivities(intents,
                        getOption(random.nextInt(5)));
                break;
            case R.id.btn_intents_anim:
                ActivityUtils.startActivities(intents,
                        R.anim.fade_in_1000, R.anim.fade_out_1000);
                break;
            case R.id.btn_act_intents:
                ActivityUtils.startActivities(this,
                        intents,
                        R.anim.fade_in_1000, R.anim.fade_out_1000);
                break;
            case R.id.btn_act_intents_opt:
                ActivityUtils.startActivities(this,
                        intents,
                        getOption(random.nextInt(3)));
                break;
            case R.id.btn_act_intents_anim:
                ActivityUtils.startActivities(this,
                        intents,
                        R.anim.fade_in_1000, R.anim.fade_out_1000);
                break;
            case R.id.btn_start_home_activity:
                ActivityUtils.startHomeActivity();
                break;
            case R.id.btn_finish_all_activities:
                ActivityUtils.finishAllActivities();
                break;
        }
    }

    private Bundle getOption(int type) {
        switch (type) {
            default:
            case 0:
                return ActivityOptionsCompat.makeCustomAnimation(this,
                        R.anim.slide_in_right_1000,
                        R.anim.slide_out_left_1000)
                        .toBundle();
            case 1:
                return ActivityOptionsCompat.makeScaleUpAnimation(viewSharedElement,
                        viewSharedElement.getWidth() / 2,
                        viewSharedElement.getHeight() / 2,
                        0, 0)
                        .toBundle();
            case 2:
                return ActivityOptionsCompat.makeThumbnailScaleUpAnimation(viewSharedElement,
                        bitmap,
                        0, 0)
                        .toBundle();
            case 3:
                return ActivityOptionsCompat.makeClipRevealAnimation(viewSharedElement,
                        viewSharedElement.getWidth() / 2,
                        viewSharedElement.getHeight() / 2,
                        0, 0)
                        .toBundle();
            case 4:
                return ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        viewSharedElement,
                        getString(R.string.activity_shared_element))
                        .toBundle();
        }
    }
}