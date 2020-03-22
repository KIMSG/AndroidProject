package com.e.mygrid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SingerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView)findViewById(R.id.gridView);

        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("소녀시내", "010-1111-0000", R.drawable.ic_001));
        adapter.addItem(new SingerItem("원더걸스", "010-2222-0000", R.drawable.ic_002));
        adapter.addItem(new SingerItem("투애니원", "010-3333-0000", R.drawable.ic_003));
        adapter.addItem(new SingerItem("버즈", "010-4444-0000", R.drawable.ic_004));
        adapter.addItem(new SingerItem("티아라", "010-5555-0000", R.drawable.ic_005));

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item =(SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택: "+item.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }
    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SingerItemView view = null;
            if (convertView == null){
                view = new SingerItemView(getApplicationContext());
            }else {
                view = (SingerItemView) convertView;
            }
//            SingerItemView view = (SingerItemView) new SingerItemView(getApplicationContext());
            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());
            return view;
        }
    }
}
