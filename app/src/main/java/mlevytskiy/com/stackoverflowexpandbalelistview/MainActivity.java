package mlevytskiy.com.stackoverflowexpandbalelistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {

    MyAdapter myAdapter;
    HashMap <String,List<String>> childItems;
    List<String> parentItems;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentListData();
        childListData();
        ExpandableListView expandableListView= (ExpandableListView) findViewById(R.id.expandable_list_view);

        myAdapter = new MyAdapter(this, parentItems, childItems);
        expandableListView.setAdapter(myAdapter);


    }

    public void parentListData() {
        parentItems =new ArrayList<>();
        parentItems.add("Action Movies");
        parentItems.add("Romantic Movies");
        parentItems.add("Comedy Movies");
    }

    public void childListData() {
        childItems =new HashMap<>();
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

        childItems.put(parentItems.get(0), action);
        childItems.put(parentItems.get(1), romantic);
        childItems.put(parentItems.get(2), comedy);

    }

}
