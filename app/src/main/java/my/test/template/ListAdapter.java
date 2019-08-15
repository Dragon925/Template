package my.test.template;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Item> list;

    public ListAdapter() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_component, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Item item = list.get(i);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.cost.setText("$" + item.getCost());
        holder.about.setText(item.getAbout());
        holder.count.setText(String.valueOf(item.getCount()));
        holder.image.setImageDrawable(item.getImage());
        holder.dec.setOnClickListener(new CounterListener(item, holder.count, false));
        holder.inc.setOnClickListener(new CounterListener(item, holder.count, true));
        Log.d("M_ListAdapter", "onBindViewHolder()");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem(Item item) {
        list.add(item);
        notifyDataSetChanged();
        Log.d("M_ListAdapter", "addItem()");
    }

    public void removeItem(Item item) {
        list.remove(item);
        notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView description;
        private TextView cost;
        private TextView about;
        private ImageView image;
        private TextView count;
        private Button dec;
        private Button inc;
        private Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            description = itemView.findViewById(R.id.tv_description);
            cost = itemView.findViewById(R.id.tv_cost);
            about = itemView.findViewById(R.id.tv_about);
            image = itemView.findViewById(R.id.imageView);
            count = itemView.findViewById(R.id.tv_count);
            dec = itemView.findViewById(R.id.button_dec);
            inc = itemView.findViewById(R.id.button_inc);
            button = itemView.findViewById(R.id.button);
        }
    }

    private class CounterListener implements View.OnClickListener {

        private boolean isPlus;
        private Item item;
        private TextView view;

        public CounterListener(Item item, TextView view, boolean isPlus) {
            this.isPlus = isPlus;
            this.item = item;
            this.view = view;
        }

        @Override
        public void onClick(View view) {
            if (isPlus)
                inc();
            else
                dec();
        }

        private void inc() {
            int count = item.getCount();
            view.setText(String.valueOf(++count));
            item.setCount(count);
        }

        private void dec() {
            int count = item.getCount();
            if (count > 0) {
                view.setText(String.valueOf(--count));
                item.setCount(count);
            }
            else {
                view.setText("0");
                item.setCount(0);
            }
        }
    }
}
