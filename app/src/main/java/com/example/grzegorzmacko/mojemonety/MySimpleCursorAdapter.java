package com.example.grzegorzmacko.mojemonety;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Grzesiek on 2017-07-31.
 */

public class MySimpleCursorAdapter extends SimpleCursorAdapter {
    public MySimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }


    public View newView(Context _context, Cursor _cursor, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) _context.getSystemService(_context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_item, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context Context, Cursor cursor) {
        String idd = cursor.getString(cursor.getColumnIndex("_id"));
        String waluta = cursor.getString(cursor.getColumnIndex("waluta"));

        TextView passedView = (TextView) view.findViewById(R.id.textViewIdd);
        TextView tv = (TextView) view.findViewById(R.id.textViewWalutaa);

        passedView.setText(idd);
        tv.setText(waluta);
        // dodanie przycisku do listView

       // Button yourButton = (Button) view.findViewById(R.id.button9);
       /* yourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view != null) {
                    Object obj = view.getTag();
                    //if(obj != null && obj instanceof Integer) {
                    bazadanych form = new bazadanych(context);
                    form.open();
                    String st = obj.toString();
                    form.deleteForm(Long.valueOf(st).longValue());
                    Toast.makeText(context, "Delete row with id = " + st, Toast.LENGTH_LONG).show();

                }
            }
        });
        Object obj = cursor.getString(cursor.getColumnIndex("_id"));
        yourButton.setTag(obj); */
    }
}
