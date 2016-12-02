package com.example.christian.listapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.christian.listapp.model.ListItem;
import com.example.christian.listapp.R;

import java.util.List;


/**
 * Created by Christian on 12/1/2016.
 */
public class OrgAdapter extends RecyclerView.Adapter<OrgAdapter.OrgHolder> {

    private List<ListItem> listData;
    private LayoutInflater inflater;

    private ItemClickCallback itemClickCallback;

    public interface ItemClickCallback{
        void onItemClick(int p);
    }

    public void setItemClickCallback (final ItemClickCallback itemClickCallback){
        this.itemClickCallback = itemClickCallback;
    }

    public OrgAdapter (List<ListItem> listData, Context c){
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    @Override
    public OrgHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_item, parent, false);
        return new OrgHolder(view);
    }

    @Override
    public void onBindViewHolder(OrgHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.icon.setImageResource(item.getImageResId());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class OrgHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            private TextView title;
            private ImageView icon;
            private View container;
            private Button load;

            public OrgHolder(View itemView) {
                super(itemView);

                title = (TextView)itemView.findViewById(R.id.lbl_item_text);
                icon = (ImageView)itemView.findViewById(R.id.im_item_icon);
                container = itemView.findViewById(R.id.cont_item_root);
                container.setOnClickListener(this);
                load = (Button)itemView.findViewById(R.id.btn_card_load);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() ==R.id.btn_card_load){
                itemClickCallback.onItemClick(getAdapterPosition());

            }

        }
    }
}
