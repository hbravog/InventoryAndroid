package dal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.thesis.inventory.inventoryandroid.R;

import java.util.ArrayList;

import dto.ProductoDTO;

/**
 * Created by Hernan on 10-06-16.
 */
public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<ProductoDTO> empList;
    private static LayoutInflater inflater = null;

    public MyAdapter(Context context, ArrayList<ProductoDTO> empList) {
        this.context = context;
        this.empList = empList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return empList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if (convertView == null)
            convertView = inflater.inflate(R.layout.product_list_product, null);

        /*TextView codeTextView = (TextView) convertView.findViewById(R.id.tv_emp_id);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.tv_emp_name);
        TextView emailTextView = (TextView) convertView.findViewById(R.id.tv_emp_email);
        TextView addressTextView = (TextView) convertView.findViewById(R.id.tv_emp_address);*/
/*

        ProductoDTO e = new ProductoDTO();

        e = empList.get(position);
       String cod =String.valueOf(e.getCod_produto());
        String prod =String.valueOf(e.getNombre());

        codeTextView.setText("Code: " + String.valueOf(e.getCode()));
        nameTextView.setText("Name: " + e.getName());
        emailTextView.setText("Email: " + e.getEmail());
        addressTextView.setText("Address: " + e.getAddress());*/
        return convertView;
    }

}