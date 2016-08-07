package com.kong.pressure;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class MyView extends View {
	Paint paint;
	int pressure = 0;

	public MyView(Context context) {
		super(context);
		paint = new Paint();
	}

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint = new Paint();
	}

	public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		paint = new Paint();
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (pressure<30) {
			paint.setColor(Color.GREEN);
		}else if (pressure<70) {
			paint.setColor(Color.YELLOW);
		}else {
			paint.setColor(Color.RED);
		}
		canvas.drawRect(50, 200-pressure, 100, 200, paint);
		
		paint.setTextSize(20);
		canvas.drawText("压力值"+pressure, 50, 50, paint);
		
	}
	public void setPressure(int pressure){
		this.pressure = pressure;
		postInvalidate();
	}

}
