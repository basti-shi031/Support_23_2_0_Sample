package basti.com.support_232_sample;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bt_show;
    private CoordinatorLayout coordinatorLayout;
    private View bottomSheet;
    private BottomSheetBehavior behavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initBottomSheet();
    }

    private void initBottomSheet() {
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //这里是bottomSheet 状态的改变，根据slideOffset可以做一些动画
                Log.i("onStateChanged", "" + newState);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //这里是拖拽中的回调，根据slideOffset可以做一些动画
                Log.i("onSlide", "" + slideOffset);
            }
        });
    }

    private void initView() {

        //bt_show = (Button) findViewById(R.id.bt_show);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cl);
        bottomSheet = coordinatorLayout.findViewById(R.id.bottom_sheet);
    }


}
