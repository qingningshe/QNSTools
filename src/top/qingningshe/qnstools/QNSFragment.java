package top.qingningshe.qnstools;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

public abstract class QNSFragment extends Fragment implements OnClickListener{

	protected View rootView;
	protected Activity context;
	protected LayoutInflater inflater;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		context = getActivity();
		inflater = getActivity().getLayoutInflater();
		rootView = inflater.inflate(getLayoutId(), null);
		return rootView;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		init(view);
		super.onViewCreated(view, savedInstanceState);
	}

	private void init(View rootView) {
		findViews(rootView);
		setListener();
		initData();
	}
	
	protected void showMsgShort(String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

	protected void showMsgLong(String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}

	protected View parseView(int resId) {
		return getView().findViewById(resId);
	}
	
	protected void setClick(View view) {
		view.setOnClickListener(this);
	}

	protected View getRootView() {
		return rootView;
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
	
	protected Drawable getDrawable(int resId) {
		return context.getResources().getDrawable(resId);
	}

	protected int getColor(int resId) {
		return context.getResources().getColor(resId);
	}
	
	public abstract int getLayoutId();

	public abstract void findViews(View rootView);

	public abstract void setListener();

	public abstract void initData();
	
}
