package com.hotelSearch.HotelSearch.dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hotelSearch.HotelSearch.entity.Hotel;

@Repository
@Transactional
public class HotelSearchDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public List<Hotel> findAll()
	{
		return em.createQuery("From Hotel",Hotel.class).getResultList();
	}
	public List<Hotel> findByCity(String city) {
		
		return em.createQuery("FROM Hotel WHERE city = :city", Hotel.class)
				.setParameter("city", city)
				.getResultList();
	}
	public Set<String> findAllDistinctCity() {
		// This query returns a list of Strings, so I give it String.class
		List<String> cityList = em.createQuery("SELECT DISTINCT city FROM Hotel", String.class)
				.getResultList();
		// Convert the List to a Set.
		return new TreeSet<>(cityList);
	}
	
}
