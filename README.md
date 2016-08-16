# DoubleClickListener
A simple double click listener for written for views implementing OnItemClickListener.


Usage example:

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
