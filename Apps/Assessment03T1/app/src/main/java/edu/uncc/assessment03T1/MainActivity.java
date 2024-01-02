package edu.uncc.assessment03T1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.uncc.assessment03T1.models.Product;
import edu.uncc.assessment03T1.models.ShoppingList;

public class MainActivity extends AppCompatActivity implements ShoppingListsFragment.ShoppingListFragmentListener , ProductsFragment.ProductsFragmentListener,
        CreateGiftListFragment.CreateGiftListFragmentListener, GiftListFragment.GiftListFragmentListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.rootView, new ShoppingListsFragment())
                .commit();

    }

    @Override
    public void gotoAddNewItem() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new CreateGiftListFragment(), "add-gift-list")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoShoppingItem(ShoppingList shoppingList) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, GiftListFragment.newInstance(shoppingList), "gift-list-item")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onSelectedProduct(Product product) {
        CreateGiftListFragment createGiftListFragment = (CreateGiftListFragment) getSupportFragmentManager().findFragmentByTag("add-gift-list");
        if(createGiftListFragment != null){
            createGiftListFragment.addProduct(product);
        }

        GiftListFragment giftListFragment = (GiftListFragment) getSupportFragmentManager().findFragmentByTag("gift-list-item");

        if(giftListFragment != null){
            createGiftListFragment.addProduct(product);
        }

        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onListAddCompleted() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onCancel() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void gotoAddProduct() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new ProductsFragment(), "add-product")
                .addToBackStack(null)
                .commit();
    }
}