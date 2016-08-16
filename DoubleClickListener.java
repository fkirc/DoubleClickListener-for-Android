
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;

public abstract class DoubleClickListener implements AdapterView.OnItemClickListener {
    private static final long DOUBLE_CLICK_MAX_TIME = 200; // milliseconds
    private CountDownTimer timer;
    private long lastClickTime = 0;

    private void startSingleClickTimer(final View view, final int position) {
        lastClickTime = System.currentTimeMillis();
        timer = new CountDownTimer(DOUBLE_CLICK_MAX_TIME, DOUBLE_CLICK_MAX_TIME) {
            @Override
            public void onTick(long l) {}

            @Override
            public void onFinish() {
                onSingleClick(view, position);
            }
        };
        timer.start();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {

        if (lastClickTime == 0) {
            startSingleClickTimer(view, position);
        } else {
            if (System.currentTimeMillis() - lastClickTime < DOUBLE_CLICK_MAX_TIME) {
                timer.cancel();
                lastClickTime = 0;
                onDoubleClick(view, position);
            } else {
                if (timer != null) {
                    timer.cancel();
                }
                startSingleClickTimer(view, position);
            }
        }
    }

    protected abstract void onSingleClick(View v, int position);
    protected abstract void onDoubleClick(View v, int position);
}
