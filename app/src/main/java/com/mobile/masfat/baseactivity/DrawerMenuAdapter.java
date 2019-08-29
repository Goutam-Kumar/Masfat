package com.mobile.masfat.baseactivity;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;
import com.mobile.masfat.customwidget.RegularTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrawerMenuAdapter extends RecyclerView.Adapter<DrawerMenuAdapter.DrawerItemHolder> {
    Context context;
    int[] menuItems;
    int[] menuIcons;
    int selectedPosition = 0;

    public DrawerMenuAdapter(Context context, int[] menuItems, int[] menuIcons) {
        this.context = context;
        this.menuItems = menuItems;
        this.menuIcons = menuIcons;
    }

    @NonNull
    @Override
    public DrawerItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DrawerItemHolder(LayoutInflater.from(context).inflate(R.layout.item_drawer_menu, null));
    }

    @Override
    public void onBindViewHolder(@NonNull DrawerItemHolder holder, int position) {
        holder.imgIcon.setImageDrawable(ContextCompat.getDrawable(context,menuIcons[position]));
        holder.txtMenu.setText(context.getText(menuItems[position]));
        if(selectedPosition==position)
            holder.itemView.setBackgroundColor(Color.parseColor("#0C0C24"));
        else
            holder.itemView.setBackgroundColor(Color.parseColor("#00ffffff"));
        holder.linMenuContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition = position;
                notifyDataSetChanged();
                BaseActivity baseActivity = (BaseActivity) context;
                ((BaseActivity) context).onDrawerMenuSelected(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.length;
    }

    public class DrawerItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_icon)
        ImageView imgIcon;
        @BindView(R.id.txt_menu)
        RegularTextView txtMenu;
        @BindView(R.id.lin_menu_container)
        LinearLayout linMenuContainer;

        public DrawerItemHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
