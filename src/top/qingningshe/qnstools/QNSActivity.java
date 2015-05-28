package top.qingningshe.qnstools;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public abstract class QNSActivity extends FragmentActivity implements OnClickListener{

	protected Context context;
	protected LayoutInflater inflater;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
		context = this;
		inflater = getLayoutInflater();
		init();
	}

	private void init() {
		findViews();
		setListener();
		initData();
	}
	
	protected void showMsgShort(String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

	protected void showMsgLong(String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}

	protected View getView(int resId) {
		return findViewById(resId);
	}
	
	protected int getColor(int resId){
		return getResources().getColor(resId);
	}
	
	
	protected void setClick(View view) {
		view.setOnClickListener(this);
	}
	
	protected void setVisible(View view) {
		view.setVisibility(View.VISIBLE);
	}
	
	protected void setInvisible(View view){
		view.setVisibility(View.INVISIBLE);
	}
	
	protected void setGone(View view) {
		view.setVisibility(View.GONE);
	}


	public abstract int getLayoutId();

	public abstract void findViews();

	public abstract void setListener();

	public abstract void initData();
	
}
