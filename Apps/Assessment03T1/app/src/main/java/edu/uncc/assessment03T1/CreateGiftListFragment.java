package edu.uncc.assessment03T1;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.uncc.assessment03T1.databinding.AddProductListItemBinding;
import edu.uncc.assessment03T1.databinding.FragmentCreateGiftListBinding;
import edu.uncc.assessment03T1.models.Product;

public class CreateGiftListFragment extends Fragment {
    public CreateGiftListFragment() {
        // Required empty public constructor
    }

    FragmentCreateGiftListBinding binding;
    ArrayList<Product> mProducts = new ArrayList<>();

    public void addProduct(Product product){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        binding = FragmentCreateGiftListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Create Gift List");

        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        adapter = new ProductsAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCancel();
            }
        });

        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoAddProduct();
            }
        });
    }

    ProductsAdapter adapter;

    class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>{
        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            AddProductListItemBinding addProductListItemBinding = AddProductListItemBinding.inflate(getLayoutInflater(), parent, false);
            return new ProductViewHolder(addProductListItemBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            holder.setupUI(mProducts.get(position));
        }

        @Override
        public int getItemCount() {
            return mProducts.size();
        }

        class ProductViewHolder extends RecyclerView.ViewHolder{
            AddProductListItemBinding mBinding;
            Product mProduct;
            public ProductViewHolder(AddProductListItemBinding addProductListItemBinding) {
                super(addProductListItemBinding.getRoot());
                mBinding = addProductListItemBinding;
            }

            void setupUI(Product product){
                mProduct = product;

                mBinding.imageViewDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });

            }
        }
    }

    CreateGiftListFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (CreateGiftListFragmentListener) context;
    }

    interface CreateGiftListFragmentListener{
        void onListAddCompleted();
        void onCancel();
        void gotoAddProduct();
    }
}