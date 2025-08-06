package com.rmk.service;

import com.rmk.dao.CartDao;
import com.rmk.model.ShoppingCart;
import com.rmk.model.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service("cartservice")
public class CartServiceImpl implements CartService {

    @Autowired
    @Qualifier("cartdao")
    private CartDao dao;

    @Override
    public boolean addItemToCart(ShoppingCart cart, ShoppingItem item) {
        Set<ShoppingItem> items = Optional.ofNullable(cart.getItems())
                .map(allitems -> {
                    if (allitems.contains(item)) {
                        item.setQty(item.getQty() + 1);
                        allitems.add(item);
                    } else {
                        allitems.add(item);
                    }
                    return allitems;
                })
                .orElse(null);
        cart.setItems(items);
        return true;
    }

    @Override
    public boolean emptyCart(ShoppingCart cart) {
        cart.setItems(null);
        return true;
    }

    @Override
    public boolean removeItemToCart(ShoppingCart cart, ShoppingItem item) {
        Set<ShoppingItem> items = Optional.ofNullable(cart.getItems())
                .map(allitems -> {
                    if (allitems.contains(item)) {
                        if (item.getQty() > 1) {
                            item.setQty(item.getQty() - 1);
                        } else {
                            allitems.remove(item);
                        }
                    }
                    return allitems;
                })
                .orElse(null);
        cart.setItems(items);
        return true;
    }

    @Override
    public boolean removeItemFromCart(Integer cartId, ShoppingItem item) {
        ShoppingCart cart = dao.getCart(cartId);
        if (cart == null) {
            return false;
        }
        return removeItemToCart(cart, item);
    }

    @Override
    public ShoppingCart createCart(ShoppingCart cart) {
        // Implement your logic here or just return cart
        return cart;
    }

    @Override
    public ShoppingCart addItemToCart(Integer cartId, ShoppingItem item) {
        ShoppingCart cart = dao.getCart(cartId);
        if (cart == null) {
            return null;
        }
        addItemToCart(cart, item);
        return cart;
    }

    @Override
    public ShoppingItem createCartItem(ShoppingItem item) {
        // Implement logic if needed, else return item
        return item;
    }
}
