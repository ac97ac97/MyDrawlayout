package example.sdbi.com.drawlayoutdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/4/2.
 */

public class DrawLayoutLeftMenuAdapter extends BaseAdapter {
    private Context context;
    private List<DrawLayoutLeftMenu> lists;

    public DrawLayoutLeftMenuAdapter(Context context, List<DrawLayoutLeftMenu> lists) {
        this.context = context;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DrawLayoutLeftMenu layoutLeftMenu = (DrawLayoutLeftMenu) getItem(position);
        View view;
        ViewHolder holder;
        if (convertView==null){
            view  =LayoutInflater.from(context).inflate(R.layout.lv_left_menu_item,null);
            holder=new ViewHolder();
            holder.img=view.findViewById(R.id.iv_img);
            holder.text=view.findViewById(R.id.tv_text);
            view.setTag(holder);
        }else {
            view=convertView;
            holder= (ViewHolder) view.getTag();
        }
        holder.img.setImageResource(layoutLeftMenu.getImg());
        holder.text.setText(layoutLeftMenu.getText());
        return view;
    }
    class ViewHolder{
        ImageView img;
        TextView text;
    }
}
