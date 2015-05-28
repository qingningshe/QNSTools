package top.qingningshe.qnstools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class QNSAdapter<T> extends BaseAdapter{
	
	protected List<T> data = new ArrayList<T>();
	private OnItemTagClick<T> tagListener;
	protected Context context;

	public QNSAdapter(Context context) {
		this.context = context;
	}

	public QNSAdapter(Context context, OnItemTagClick<T> tagListener) {
		this(context);
		this.tagListener = tagListener;
	}

	public QNSAdapter(Context context, List<T> data) {
		this.context = context;
		this.data.clear();
		this.data.addAll(data);
		notifyDataSetChanged();
	}
	
	public void setData(List<T> data) {
		if (data != null) {
			this.data.clear();
			this.data.addAll(data);
		}else {
			this.data.clear();
		}
		notifyDataSetChanged();
	}
	
	public void setData(T[] data) {
		if (data != null && data.length > 0) {
			setData(Arrays.asList(data));
		}
	}
	
	public void addData(List<T> data) {
		if (data != null && data.size() > 0) {
			if (this.data == null) {
				this.data = new ArrayList<T>();
			}
			this.data.addAll(data);
			notifyDataSetChanged();
		}
	}
	
	public void addData(T[] data) {
		addData(Arrays.asList(data));
	}
	
	public void removeElement(T element) {
		if (data.contains(element)) {
			data.remove(element);
			notifyDataSetChanged();
		}
	}
	
	public void removeElement(int position) {
		if (data != null && data.size() > position) {
			data.remove(position);
			notifyDataSetChanged();
		}
	}
	
	public void removeElements(List<T> elements) {
		if (data != null && elements != null && elements.size() > 0
				&& data.size() >= elements.size()) {

			for (T element : elements) {
				if (data.contains(element)) {
					data.remove(element);
				}
			}

			notifyDataSetChanged();
		}
	}
	
	public void removeElements(T[] elements) {
		if (elements != null && elements.length > 0) {
			removeElements(Arrays.asList(elements));
		}
	}
	
	public void updateElement(T element, int position) {
		if (position >= 0 && data.size() > position) {
			data.remove(position);
			data.add(position, element);
			notifyDataSetChanged();
		}
	}
	
	public void addElement(T element) {
		if (element != null) {
			if (this.data == null) {
				this.data = new ArrayList<T>();
			}
			data.add(element);
			notifyDataSetChanged();
		}
	}
	
	public void clearData() {
		if (this.data != null) {
			this.data.clear();
			notifyDataSetChanged();
		}
	}
	
	protected void setVisible(View view) {
		view.setVisibility(View.VISIBLE);
	}
	
	protected void setGone(View view) {
		view.setVisibility(View.GONE);
	}
	
	protected void setInvisible(View view) {
		view.setVisibility(view.INVISIBLE);
	}
	
	protected Drawable getDrawable(int resId) {
		return context.getResources().getDrawable(resId);
	}
	
	public List<T> getDataSource() {
		return data;
	}
	
	public void setTagListener(OnItemTagClick<T> tagListener) {
		this.tagListener = tagListener;
	}
	
	public OnItemTagClick<T> getTagListener() {
		return tagListener;
	}

	
	public int getSize() {
		return data.size();
	}

	@Override
	public int getCount() {
		return data == null ? 0 : data.size();
	}

	@Override
	public Object getItem(int position) {
		return data != null ? data.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView==null) {
			convertView=View.inflate(context, getLayoutId(), null);
		}
		ViewHolder holder=ViewHolder.get(convertView);
		fillValues(position, holder);
		return convertView;
	}
	
	public abstract int getLayoutId();
	public abstract void fillValues(int position,ViewHolder holder);
	
}
