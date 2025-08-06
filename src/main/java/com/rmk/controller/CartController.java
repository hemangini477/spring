package com.rmk.controller;

import com.rmk.model.ShoppingCart;
import com.rmk.model.ShoppingItem;
import com.rmk.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    @Qualifier("cartservice")
    private CartService service;

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ShoppingCart addItemToCart(@RequestParam("cartId") Integer cartId, @RequestBody ShoppingItem item) {
        return service.addItemToCart(cartId, item);
    }

    @DeleteMapping(path = "/remove", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean removeItemFromCart(@RequestParam("cartId") Integer cartId, @RequestBody ShoppingItem item) {
        return service.removeItemFromCart(cartId, item);
    }
}
