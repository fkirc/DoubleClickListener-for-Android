# DoubleClickListener for Android
A simple double click listener for views implementing OnItemClickListener, for example ListViews or GridViews.
In supports both single and double clicks for the same view, the time delay is adjustable.

Usage example:

```java
GridView myGridView = (GridView)findViewById(R.id.some_id);
myGridView.setOnItemClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick(View v, int position) {
               // do something when double clicked
            }

            @Override
            public void onSingleClick(View v, int position) {
                // do something when single clicked
            }
        });
```
