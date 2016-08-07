package com.kong.pressure;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	static{
		System.loadLibrary("pressure");
	}

	public MyView mv_yl;
	private TextView tv_pressure;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mv_yl = (MyView) findViewById(R.id.mv_yl);
	}

	public void start(View v) {
		new Thread() {
			public void run() {
				startMoniter();
			};
		}.start();
		
	}

	public void stop(View v) {
		stopMoniter();

	}

	public native void startMoniter();

	public native void stopMoniter();

	public void setPressure(int pressure) {
		mv_yl.setPressure(pressure);
		
	}

}
