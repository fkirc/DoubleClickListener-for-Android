# DoubleClickListener for Android

_______________________________________________________________
# Note: I recommend to use `android.view.GestureDetector` instead of this class. GestureDetector provides a smoother user experience.

A simple double click listener to implement instagram-like double tap behaviour.

It works for all views implementing OnItemClickListener, for example ListViews or GridViews.
It supports both single and double clicks for the same view, the time delay is adjustable.

Usage example:

```java
GridView myGridView = (GridView)findViewById(R.id.some_id);
myGridView.setOnItemClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick(AdapterView<?> parent, View v, int position, long id) {
               // do something when double clicked
            }

            @Override
            public void onSingleClick(AdapterView<?> parent, View v, int position, long id) {
                // do something when single clicked
            }
        });
```
