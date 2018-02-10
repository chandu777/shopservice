package com.acsk.shop.dao;

import java.util.List;

import com.acsk.shop.model.Shop;

public interface ShopDao {
	public List<Shop> getAllShops();

	public Shop getShop(long id);

	public void addShop(Shop shop);
}
