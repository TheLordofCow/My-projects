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

import edu.uncc.assessment03T1.databinding.AddProductListItemBinding;
import edu.uncc.assessment03T1.databinding.FragmentGiftListBinding;
import edu.uncc.assessment03T1.models.Product;
import edu.uncc.assessment03T1.models.ShoppingList;

public class GiftListFragment extends Fragment {
    private static final String ARG_PARAM = "ARG_PARAM";
    private ShoppingList mShopingList;

    public GiftListFragment() {
        // Required empty public constructor
    }

    public void addProduct(Product product){

    }

    public static GiftListFragment newInstance(ShoppingList shoppingList) {
        GiftListFragment fragment = new GiftListFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM, shoppingList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mShopingList = (ShoppingList) getArguments().getSerializable(ARG_PARAM);
        }
    }

    FragmentGiftListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGiftListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Gift List");
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
        public ProductsAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            AddProductListItemBinding addProductListItemBinding = AddProductListItemBinding.inflate(getLayoutInflater(), parent, false);
            return new ProductsAdapter.ProductViewHolder(addProductListItemBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductsAdapter.ProductViewHolder holder, int position) {
            holder.setupUI(mShopingList.getProducts().get(position));
        }

        @Override
        public int getItemCount() {
            return mShopingList.getProducts().size();
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


    GiftListFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (GiftListFragmentListener) context;
    }

    interface GiftListFragmentListener{
        void onCancel();
        void gotoAddProduct();
    }

}