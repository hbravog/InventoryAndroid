package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thesis.inventory.inventoryandroid.R;

import java.util.List;

import dto.AlmacenDTO;

/**
 * Created by hernanbravo on 04-04-18.
 */

public class WareHouseAdapter extends RecyclerView.Adapter<WareHouseAdapter.ViewHolder>
{
    private List<AlmacenDTO> warehouseList;

    public WareHouseAdapter(List<AlmacenDTO> warehouseList)
    {
     this.warehouseList = warehouseList;
    }

    @Override
    public WareHouseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inventory_warehouse_list_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WareHouseAdapter.ViewHolder holder, int position) {
        String name = warehouseList.get(position).getAlmacen();
        holder.name.setText(name);
    }

    @Override
    public int getItemCount() {
        return warehouseList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.textWareHouse);
        }
    }
}
