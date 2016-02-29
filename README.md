# Support 23.2.0 新特性

## Bottom Sheet

### 基本使用方法

1. 在CoordinatorLayout中绘制Bottom Sheet的布局
```java
<android.support.v4.widget.NestedScrollView
        android:id="@+id/bottom_sheet"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:behavior_hideable="true"
        app:behavior_peekHeight="50dp"
        app:layout_behavior="@string/bottom_sheet_behavior">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:orientation="vertical">

            <!-- 这里是BottomSheet的布局-->

        </LinearLayout>
    </android.support.v4.widget.NestedScrollView>
</android.support.design.widget.CoordinatorLayout>
```

一些属性值：

|属性|含义|
|--|--:|
|behavior_hideable|当bottom sheet下拉时，是否可以全部隐藏|
|behavior_peekHeight|当bottom sheet关闭时，我们可以看到的高度|


2. 设置回调函数

```java
behavior = BottomSheetBehavior.from(bottomSheet);
    behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            //这里是bottomSheet 状态的改变\
            Log.i("onStateChanged", "" + newState);
        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            //这里是拖拽中的回调
            Log.i("onSlide", "" + slideOffset);
        }
    });
```

两个回调函数
    * onStateChanged

  当bottom sheet状态发生改变时回调，可以根据newState判定不同的状态

  |newState|说明|
  |--|--:|
  |STATE_COLLAPSED|bottom sheet关闭时的状态，此时显示peekHeight的高度|
  |STATE_DRAGGING|bottom sheet拖动时的状态|
  |STATE_SETTLING|bottom sheet释放|
  |STATE_EXPANDED|bottom sheet展开|
  |STATE_HIDDEN|bottom sheet完全隐藏|

    * onSlide

当bottom sheet拖动时回调,slideOffset的范围是[-1,1]

|newState|slideOffset|
|--|--:|
|STATE_COLLAPSED|0|
|STATE_DRAGGING|[-1,1]|
|STATE_EXPANDED|1|
|STATE_HIDDEN|-1|
