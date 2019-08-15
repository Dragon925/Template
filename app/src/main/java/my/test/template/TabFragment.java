package my.test.template;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("M_TabFragment", "onCreateView");
        View layout = inflater.inflate(R.layout.first_tab, container, false);
        RecyclerView list = layout.findViewById(R.id.rv_list);
        ListAdapter adapter = new ListAdapter();
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.addItem(new Item("Test", "test", 48.6, "test"));
        return layout;
    }
}
