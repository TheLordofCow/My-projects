package edu.uncc.assessment03T1;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import edu.uncc.assessment03T1.databinding.AddProductListItemBinding;
import edu.uncc.assessment03T1.databinding.FragmentProductsBinding;
import edu.uncc.assessment03T1.databinding.ShoppingListItemBinding;
import edu.uncc.assessment03T1.models.Product;
import edu.uncc.assessment03T1.models.ShoppingList;

public class ProductsFragment extends Fragment {

    ArrayList<Product> mProducts = new ArrayList<>();

    public ProductsFragment() {
        // Required empty public constructor
    }

    FragmentProductsBinding binding;
    ProductsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProductsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Products");
        adapter = new ProductsAdapter(getContext(), R.layout.add_product_list_item, mProducts);
        binding.listView.setAdapter(adapter);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onSelectedProduct(mProducts.get(position));
            }
        });

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCancel();
            }
        });
    }

    class ProductsAdapter extends ArrayAdapter<Product> {
        public ProductsAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            AddProductListItemBinding mBinding;
            if(convertView == null){
                mBinding = AddProductListItemBinding.inflate(getLayoutInflater(), parent, false);
                convertView = mBinding.getRoot();
                convertView.setTag(mBinding);
            } else {
                mBinding = (AddProductListItemBinding) convertView.getTag();
            }

            mBinding.imageViewDelete.setVisibility(View.INVISIBLE);

            Product product = mProducts.get(position);

            //set the ui require to

            return convertView;
        }
    }

    ProductsFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (ProductsFragmentListener) context;
    }

    interface ProductsFragmentListener {
        void onSelectedProduct(Product product);
        void onCancel();
    }
}