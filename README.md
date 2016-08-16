# DoubleClickListener
A simple double click listener written for views implementing OnItemClickListener, for example GridViews.
In contrast to https://gist.github.com/srix55/ec64d2f6a371c80bbbc4 this supports both single and double clicks for the same view.

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
