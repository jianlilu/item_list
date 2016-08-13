package com.example.lu.me_lu;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MyHelloTo extends ListActivity {

    ListView listView;
    static int arrSize;
    static String[] arr;
    ArrayAdapter adapter;


    private static final int ITEM1 = Menu.FIRST;
    private static final int ITEM3 = Menu.FIRST + 1;

    List<String> data;



    static String str_delect;
    static StringBuilder delete_list;
    static String[] myDelete;
    static String str_dele;




    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(MyNodeList.this, "onStart() run...", Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(MyHelloTo.this, "onCreate() run...", Toast.LENGTH_SHORT).show();

        //        listView = (ListView) findViewById(R.id.list);
        //        listView = new ListView(this);
//        adapter.notifyDataSetChanged();

        listView = getListView();

        setContentView(listView);

        data = new ArrayList();
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, getData());
        listView.setAdapter(adapter);
        //        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, getData()));
        //        setContentView(listView);


        //为 ListView 的所有 item 注册 ContextMenu
        this.registerForContextMenu(listView);


    }



    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MyHelloTo.this, "onResume() run...", Toast.LENGTH_SHORT).show();

        listView.setAdapter(adapter);
//        listView.invalidate();
//        data.remove(adapter.getItem(i));


        adapter.notifyDataSetChanged();
        Log.e("myLog", "onResume Size ==== " + data.size());


    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);

//      data.remove(adapter.getItem(position));//点击删除
        Log.e("myLog", "onListItemClick  data.size() == " + data.size());
        adapter.notifyDataSetChanged();
        Toast.makeText(getApplicationContext(), "长按可以选择删除", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("提示信息");
        menu.setHeaderIcon(R.drawable.icon);
        menu.add(0, ITEM1, 0, "删除Item");
        menu.add(0, ITEM3, 0, "关于我");

    }


    int dataSize;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case ITEM1:
                                    //System.out.println("Item id="+item.getItemId());
                                    //System.out.println("position="+getListAdapter().getItemId(menuInfo.position));

                try {
                                    //       Toast.makeText(MyNodeList.this,"arrayList.remove() run...", Toast.LENGTH_SHORT).show();
                                    //        boolean b = data.remove(adapter.getItem(menuInfo.position)); //删除一个object类型数据，返回boolean
                    str_delect = data.remove(menuInfo.position); //删除一个int类型数据，返回删除的元素
                    Toast.makeText(MyHelloTo.this,"str_delect="+str_delect, Toast.LENGTH_SHORT).show();

                    delete_list = new StringBuilder();
//                    delete_list.append(str_delect);
//                    tem = null;

                    if (str_dele == null) {
                        str_dele = str_delect + "#";
                    }
                    else {
                        str_dele += str_delect + "#";
                    }


                    delete_list.append(str_dele);



                    Log.e("me", "delete_lis=="+delete_list);


                    adapter.remove(str_delect);

                    adapter.notifyDataSetChanged();

                    listView.setAdapter(adapter);
//                    listView.setAdapter(getListAdapter());

//
//                    data.clear();
//                   getData();
//                    i = Integer.parseInt(a);


//                    int pos = (int) getListAdapter().getItemId(menuInfo.position);


                    Log.e("myLog", "ITEM1 String a == " + str_delect);
//                    Log.e("myLog", "ITEM1 boolean b == " + b);

                    Log.e("myLog", "ITEM1 Size == " + data.size());

                    //                    Log.e("myLog", "ITEM1 arrSize == " + arrSize);

                    //                    data.remove(adapter.getItemId(menuInfo.position)); // NullPointerException

                } catch (Exception e) {
                    e.printStackTrace();
                }


//                Toast.makeText(getApplicationContext(), "此项已删除", Toast.LENGTH_SHORT).show();
                break;

            case ITEM3:
                Toast.makeText(getApplicationContext(), "我喜欢你哦!", Toast.LENGTH_SHORT).show();
                break;
        }
        dataSize = data.size();
        Log.e("(onItemSelect)dataSize", " == " + dataSize);
        return super.onContextItemSelected(item);
    }


    @Override
    public ListView getListView() {
        return super.getListView();
    }

    @Override
    public ListAdapter getListAdapter() {
        return super.getListAdapter();
    }


    private List<String> getData() {

//        data = new ArrayList();

        Toast.makeText(MyHelloTo.this, "getData() run...", Toast.LENGTH_SHORT).show();


//        mapAnnotationLayer = new MapAnnotationLayer(this, data, params);
        String text = new MyHello().getMyText();
        Log.e("myLog getData()", "s ===  " + text);

//        int mSize = data.size();


        arr = text.split("#");


        arrSize = arr.length;

        for (int i = 0; i < arrSize; i++) {

                Toast.makeText(MyHelloTo.this, "str_delect=="+str_delect, Toast.LENGTH_SHORT).show();
                data.add(arr[i]);

        }


        /**
        if (delete_list != null) {
            Toast.makeText(MyHelloTo.this, "delete_list != null", Toast.LENGTH_SHORT).show();
            myDelete = delete_list.toString().split("#");
//            myDelete = str_dele.toString().split("#");
            for (int i = 0; i < myDelete.length; i++) {
                Log.e("me", "myDelete.length == " + myDelete.length);
                Log.e("myLog", "myDelete[i] == " + myDelete[i]);
            }

            for (int i = 0; i < arrSize; i++) {
                for (int j = 0; j < myDelete.length; j++) {
//                    if (!arr[i].equals(myDelete[j])) {
                    if((Arrays.asList(arr).contains(myDelete[j]))) {
                        Toast.makeText(MyHelloTo.this, "str_delect=="+str_delect, Toast.LENGTH_SHORT).show();
//                          data.add(myDelete[j]);

                        HashSet hashSet = new HashSet();
                        hashSet.add(arr[i]);
                        Iterator it=hashSet.iterator();
                        while(it.hasNext())
                        {
                            Object o=it.next();
                            if(!o.equals(it)){
                                data.add(o.toString());

//                                  Toast.makeText(MyNodeList.this, "o="+o.toString(), Toast.LENGTH_SHORT).show();
                                Log.d("myTAG", "o="+o.toString());

                            }

                        }
                        if(arr[i].equals(myDelete[j])) {
//                                Toast.makeText(MyNodeList.this, "arr[i]="+arr[i], Toast.LENGTH_SHORT).show();
                            Log.d("myTAG",  "arr[i]="+arr[i]);
                            data.remove(arr[i]);
                        }
                        Log.d("myTAG", "myDelete[j]="+myDelete[j]);
//                          Toast.makeText(MyNodeList.this, "myDelete[j]="+myDelete[j], Toast.LENGTH_SHORT).show();
                        data.remove(myDelete[j]);

                    }


                }

            }
        }
        else {
            Toast.makeText(MyHelloTo.this, "delete_list == null", Toast.LENGTH_SHORT).show();

            for (int i = 0; i < arrSize; i++) {
                data.add(arr[i]);

            }



        }
         */



//        for (int i = 0; i < arrSize; i++) {
//            if(!arr[i].equals(str_delect)) {
//                Toast.makeText(MyNodeList.this, "str_delect=="+str_delect, Toast.LENGTH_SHORT).show();
//                data.add(arr[i]);
//            }
//        }

//        data.add(text);

//        getArrSize();

        return data;
    }

    public int getArrSize() {
        Log.e("myLog getArrSize", "arrSize == " + arrSize);
        return arrSize; //arrSize == 0;
    }

    public String[] getArr() {
        return arr;
    }

}


