package com.example.zhoukaomoni3.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.example.zhoukaomoni3.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {
    @BindView(R.id.iv)
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {
        //创建一个属性动画
        DisplayMetrics dm = new DisplayMetrics();
        int widthPixels = dm.widthPixels;
        //平移
        ObjectAnimator translationY = new ObjectAnimator().ofFloat(iv,"translationY",0,500);
        //旋转
        ObjectAnimator ra = ObjectAnimator.ofFloat(iv,"rotation", 0f, 360f);
        //缩放
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(iv, "scaleY", 2, 1);
        //渐变
        ObjectAnimator anim = ObjectAnimator.ofFloat(iv, "alpha",0,1);
        AnimatorSet set = new AnimatorSet();
        set.play(translationY).with(ra).with(scaleY).with(anim);
        set.clone();
        set.setDuration(3000);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void initView() {

    }
}
