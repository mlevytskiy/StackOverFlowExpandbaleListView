package mlevytskiy.com.stackoverflowexpandbalelistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {

    MyAdapter myAdapter;
    HashMap <String,List<String>> child_items;
    List<String> parent_items;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentListData();
        childListData();
        ExpandableListView expandableListView= (ExpandableListView) findViewById(R.id.expandable_list_view);

        myAdapter =new MyAdapter(this,parent_items,child_items);
        expandableListView.setAdapter(myAdapter);


    }

    public void parentListData() {
        parent_items=new ArrayList<>();
        parent_items.add("Action Movies");
        parent_items.add("Romantic Movies");
        parent_items.add("Comedy Movies");
    }

    public void childListData() {
        child_items=new HashMap<>();
        List<String> action=new ArrayList<>();
        action.add("aa");
        action.add("aa");
        action.add("aa");

        List<String> romantic=new ArrayList<>();
        romantic.add("aa");
        romantic.add("aa");
        romantic.add("aa");

        List<String> comedy=new ArrayList<>();
        comedy.add("aa");
        comedy.add("aa");
        comedy.add("aa");

        child_items.put(parent_items.get(0),action);
        child_items.put(parent_items.get(1),romantic);
        child_items.put(parent_items.get(2),comedy);

    }

}
