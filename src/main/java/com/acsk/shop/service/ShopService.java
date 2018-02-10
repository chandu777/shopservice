package com.acsk.shop.service;

import java.util.List;

import com.acsk.shop.model.Shop;

public interface ShopService {
	public List<Shop> getAllShops();
	public Shop getShop(long id);
	public boolean addShop(Shop shop);
}
