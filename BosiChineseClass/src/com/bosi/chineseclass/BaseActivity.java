package com.bosi.chineseclass;



import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.http.HttpHandler;

public class BaseActivity extends FragmentActivity {
	
	protected BitmapUtils mBitmapUtils;

	protected Activity mContext;
	
	

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		this.mContext = this;
		ViewUtils.inject(this);
		BSApplication.getInstance().mActivityStack.push(this);
	}

	public String getResourceFromId(int id) {
		return getResources().getString(id);
	}

	public String getStringFormat(String format, String... args) {
		return format.format(format, args);
	}

	@Override
	protected void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
		
	}
	@Override
	protected void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
	
	}

	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		BSApplication.getInstance().mActivityStack.remove(this);
		}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	HttpHandler<String> mHttpHandler;

	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		
	}
	
    public void showToastLong(String text){
    	Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
    
    public void showToastShort(String text){
    	Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
	public void playYoYo(View mView) {
		YoYo.with(Techniques.Shake).duration(700).playOn(mView);
	}
	
	
}
