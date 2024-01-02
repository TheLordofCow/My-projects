package edu.uncc.assessment03T1;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import edu.uncc.assessment03T1.databinding.FragmentShoppingListsBinding;
import edu.uncc.assessment03T1.databinding.ShoppingListItemBinding;
import edu.uncc.assessment03T1.models.ShoppingList;

public class ShoppingListsFragment extends Fragment {
    ArrayList<ShoppingList> mShoppingLists = new ArrayList<>();
    public ShoppingListsFragment() {
        // Required empty public constructor
    }
    ShoppingListAdapter adapter;
    FragmentShoppingListsBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    class ShoppingListAdapter extends ArrayAdapter<ShoppingList> {
        public ShoppingListAdapter(@NonNull Context context, int resource, @NonNull List<ShoppingList> objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ShoppingListItemBinding shoppingListItemBinding;
            if(convertView == null){
                shoppingListItemBinding = ShoppingListItemBinding.inflate(getLayoutInflater(), parent, false);
                convertView = shoppingListItemBinding.getRoot();
                convertView.setTag(shoppingListItemBinding);
            } else {
                shoppingListItemBinding = (ShoppingListItemBinding) convertView.getTag();
            }

            ShoppingList shoppingList = mShoppingLists.get(position);

            //set the ui require to

            return convertView;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentShoppingListsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Shopping Lists");
        adapter = new ShoppingListAdapter(getContext(), R.layout.shopping_list_item, mShoppingLists);
        binding.listView.setAdapter(adapter);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.gotoShoppingItem(mShoppingLists.get(position));
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add_new_item) {
            mListener.gotoAddNewItem();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    ShoppingListFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (ShoppingListFragmentListener) context;
    }

    interface ShoppingListFragmentListener {
        void gotoAddNewItem();
        void gotoShoppingItem(ShoppingList shoppingList);
    }
}