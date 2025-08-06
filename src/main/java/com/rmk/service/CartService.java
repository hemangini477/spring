package com.rmk.service;

import com.rmk.model.ShoppingCart;
import com.rmk.model.ShoppingItem;

public interface CartService {

    boolean addItemToCart(ShoppingCart cart, ShoppingItem item);

    boolean emptyCart(ShoppingCart cart);

    boolean removeItemToCart(ShoppingCart cart, ShoppingItem item);

    boolean removeItemFromCart(Integer cartId, ShoppingItem item);

    ShoppingCart createCart(ShoppingCart cart);

    ShoppingCart addItemToCart(Integer cartId, ShoppingItem item);

    ShoppingItem createCartItem(ShoppingItem item);

}
