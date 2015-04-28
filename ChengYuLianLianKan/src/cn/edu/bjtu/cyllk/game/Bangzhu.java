package cn.edu.bjtu.cyllk.game;

import cn.edu.bjtu.cyllk.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Bangzhu extends Activity implements OnTouchListener,
		android.view.GestureDetector.OnGestureListener {
	ImageView bangzhuImageView;
	/** Called when the activity is first created. */
	LinearLayout bgLayout = null;
	private GestureDetector mGesture = null;
	private int flag = 1;

	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 全屏设置
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 添加布局
		setContentView(R.layout.bangzhu);

		mGesture = new GestureDetector(this);

		bgLayout = (LinearLayout) findViewById(R.id.bangzhu_bg);
		bgLayout.setBackgroundResource(R.drawable.point1);
		bgLayout.setOnTouchListener(this);
		bgLayout.setLongClickable(true);
	}

	public boolean onDown(MotionEvent e) {
		return false;
	}

	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// 处理左右滑动
		if (e1.getX() - e2.getX() > 100) { // 向左滑动
			if (flag == 1) {
				bgLayout.setBackgroundResource(R.drawable.point2);
				flag = 2;
				return true;
			}
			if (flag == 2) {
				bgLayout.setBackgroundResource(R.drawable.point3);
				flag = 3;
				return true;
			}
		} else if (e1.getX() - e2.getX() < -100) { // 向右滑动
			if (flag == 3) {
				bgLayout.setBackgroundResource(R.drawable.point2);
				flag = 2;
				return true;
			}
			if (flag == 2) {
				bgLayout.setBackgroundResource(R.drawable.point1);
				flag = 1;
				return true;
			}
		}
		return false;
	}

	public void onLongPress(MotionEvent e) {

	}

	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		return false;
	}

	public void onShowPress(MotionEvent e) {

	}

	public boolean onSingleTapUp(MotionEvent e) {
		return false;
	}

	@SuppressLint("ClickableViewAccessibility")
	public boolean onTouch(View v, MotionEvent event) {
		return this.mGesture.onTouchEvent(event);
	}
}
