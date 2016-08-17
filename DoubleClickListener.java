
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;

public abstract class DoubleClickListener implements AdapterView.OnItemClickListener {

    private static final long SINGLE_CLICK_DELAY = 200; // milliseconds

    private CountDownTimer timer;
    private State currentState = State.IDLE;
    private enum State {
        WAITING_FOR_DOUBLE_CLICK,
        CLICK_EXECUTED,
        IDLE
    }

    private void startSingleClickTimer(final AdapterView<?> parent, final View v, final int pos, final long id) {
        currentState = State.WAITING_FOR_DOUBLE_CLICK;
        timer = new CountDownTimer(SINGLE_CLICK_DELAY, SINGLE_CLICK_DELAY) {
            @Override
            public void onTick(long l) {}
            @Override
            public void onFinish() {
                startAfterClickTimer();
                onSingleClick(parent, v, pos, id);
            }
        };
        timer.start();
    }

    private void startAfterClickTimer() {
        currentState = State.CLICK_EXECUTED;
        timer = new CountDownTimer(SINGLE_CLICK_DELAY, SINGLE_CLICK_DELAY) {
            @Override
            public void onTick(long l) {}
            @Override
            public void onFinish() {
                currentState = State.IDLE;
            }
        };
        timer.start();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, final View v, final int pos, long id) {

        switch (currentState) {
            case IDLE:
                startSingleClickTimer(parent, v, pos, id);
                break;
            case WAITING_FOR_DOUBLE_CLICK:
                timer.cancel();
                startAfterClickTimer();
                onDoubleClick(parent, v, pos, id);
                break;
            case CLICK_EXECUTED:
                break; // ignore clicks when an action resulting from a recent click is currently executing
        }
    }

    protected abstract void onSingleClick(AdapterView<?> parent, View v, int position, long id);
    protected abstract void onDoubleClick(AdapterView<?> parent, View v, int position, long id);
}
