package com.acsk.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acsk.shop.model.Shop;

@Transactional
@Repository
public class ShopDaoImpl implements ShopDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Shop> getAllShops() {
		String hql = "FROM Shop as s ORDER BY s.shop_id";
		return (List<Shop>) entityManager.createQuery(hql).getResultList();
	}

	public Shop getShop(long id) {
		
		return entityManager.find(Shop.class, id);
	}

	public void addShop(Shop shop) {
		entityManager.persist(shop);
	}

}
