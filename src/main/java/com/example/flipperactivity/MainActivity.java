package com.example.flipperactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private ViewFlipper vf;
    private int viewIds[] = {R.layout.layoutred, R.layout.layout2, R.layout.layout3, R.layout.layout4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        vf.startFlipping();
    }
    private void initData() {
//        for (int i = 0; i <10 ; i++) {
//            TextView textView = new TextView(MainActivity.this);
//            textView.setText("喜欢饭饭"+i);
//            vf.addView(textView);
//        }
        View itemView;
        for (int viewId : viewIds) {
            itemView = View.inflate(this,viewId,null);
            vf.addView(itemView);
        }


    }

    private void initView() {
        vf = (ViewFlipper) findViewById(R.id.vf);
        vf.setFlipInterval(2000);
        //设置viewFlipper的入场动画和离场动画
        //组合动画  透明度  位移
        //离场动画
        AlphaAnimation alphaOutAnimation = new AlphaAnimation(1, 0);
        TranslateAnimation translateOutAnimation = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, -1);
        AnimationSet animationOutSet = new AnimationSet(false);
        animationOutSet.addAnimation(alphaOutAnimation);
        animationOutSet.addAnimation(translateOutAnimation);
        animationOutSet.setDuration(500);
        //入场动画
        AlphaAnimation alphaInAnimation = new AlphaAnimation(0, 1);
        TranslateAnimation translateInAnimation = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, 1,
                TranslateAnimation.RELATIVE_TO_SELF, 0);

        AnimationSet animationInSet = new AnimationSet(false);
        animationInSet.addAnimation(alphaInAnimation);
        animationInSet.addAnimation(translateInAnimation);
        animationInSet.setDuration(500);

        //将这两个动画设置给viewFlipper
        vf.setInAnimation(animationInSet);
        vf.setOutAnimation(animationOutSet);
    }
}
