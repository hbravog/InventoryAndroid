package layout.Products;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.thesis.inventory.inventoryandroid.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dto.ProductoDTO;

/**
 * Created by Hernan on 27-09-16.
 */
public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<ProductoDTO> worldpopulationlist = null;
    private ArrayList<ProductoDTO> arraylist;

    public ListViewAdapter(Context context, List<ProductoDTO> worldpopulationlist) {
        mContext = context;
        this.worldpopulationlist = worldpopulationlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<ProductoDTO>();
        this.arraylist.addAll(worldpopulationlist);
    }

    public class ViewHolder {
        TextView rank;
        TextView country;
        TextView population;
    }

    @Override
    public int getCount() {
        return worldpopulationlist.size();
    }

    @Override
    public ProductoDTO getItem(int position) {
        return worldpopulationlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.rank = (TextView) view.findViewById(R.id.rank);
            holder.country = (TextView) view.findViewById(R.id.country);
            holder.population = (TextView) view.findViewById(R.id.population);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.rank.setText(worldpopulationlist.get(position).getCod_produto());
        holder.country.setText(worldpopulationlist.get(position).getNombre());
        holder.population.setText(worldpopulationlist.get(position).getStock());

        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(mContext.getApplicationContext(), SingleItemView.class);
                // Pass all data rank
                intent.putExtra("rank",(worldpopulationlist.get(position).getCod_produto()));
                // Pass all data country
                intent.putExtra("country",(worldpopulationlist.get(position).getNombre()));
                // Pass all data population
                intent.putExtra("population",(worldpopulationlist.get(position).getEstado()));
                // Pass all data flag
                // Start SingleItemView Class
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        worldpopulationlist.clear();
        if (charText.length() == 0) {
            worldpopulationlist.addAll(arraylist);
        }
        else
        {
            for (ProductoDTO wp : arraylist)
            {
                if (wp.getNombre().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    worldpopulationlist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
