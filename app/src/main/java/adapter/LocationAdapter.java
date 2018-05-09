package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.thesis.inventory.inventoryandroid.R;
import java.util.List;
import dto.LocationDTO;

/**
 * Created by hernanbravo on 04-04-18.
 */

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder>
{
    private List<LocationDTO> locationList;

    public LocationAdapter(List<LocationDTO> locationList)
    {
     this.locationList = locationList;
    }

    @Override
    public LocationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inventory_location_list_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LocationAdapter.ViewHolder holder, int position) {
        String name = locationList.get(position).getLocation();
        holder.name.setText(name);
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.textLocation);
        }
    }
}
