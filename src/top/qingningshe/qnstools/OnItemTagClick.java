package top.qingningshe.qnstools;

public abstract class OnItemTagClick<T> {
	public void onItemClick(int position,T model,int code){}
	public void onItemLongClick(int position,T model,int code){}
}