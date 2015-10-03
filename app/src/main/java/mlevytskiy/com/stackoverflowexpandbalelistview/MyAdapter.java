package mlevytskiy.com.stackoverflowexpandbalelistview;

import android.content.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.HashMap;
import java.util.List;

/**
 * Created by max on 04.10.15.
 */
public class MyAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String> parent_items;
    HashMap<String,List<String>> child_items;
    public MyAdapter(Context context, List<String> parent_items, HashMap<String, List<String>> child_items)  {
        this.context=context;
        this.parent_items=parent_items;
        this.child_items=child_items;
    }

    @Override
    public int getGroupCount() {
        return parent_items.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child_items.get(parent_items.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parent_items.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child_items.get(parent_items.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String text= (String) getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.parent_view,parent,false);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String text= (String) getChild(groupPosition,childPosition);
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.child_view,parent,false);
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
