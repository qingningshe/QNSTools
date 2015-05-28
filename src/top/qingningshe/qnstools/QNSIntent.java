package top.qingningshe.qnstools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class QNSIntent {
	private Intent intent;
	private Activity from;
	private Class<?> to;
	private Bundle data;
	private int requestCode = -1;

	public QNSIntent() {
		intent = new Intent();
	}

	public QNSIntent from(Activity from) {
		this.from = from;
		return this;
	}

	public QNSIntent to(Class<?> to) {
		this.to = to;
		return this;
	}

	public QNSIntent data(Bundle data) {
		this.data=data;
		return this;
	}

	public QNSIntent requestCode(int requestCode) {
		this.requestCode = requestCode;
		return this;
	}

	public QNSIntent anim(int enterAnim, int exitAnim) {
		from.overridePendingTransition(enterAnim, exitAnim);
		return this;
	}

	public void lauch() {
		if (intent != null && from != null && to != null) {
			intent.setClass(from, to);

			if (data != null) {
				intent.putExtras(data);
			}

			if (requestCode < 0) {
				from.startActivity(intent);
			} else {
				from.startActivityForResult(intent, requestCode);
			}
		}
	}
}
