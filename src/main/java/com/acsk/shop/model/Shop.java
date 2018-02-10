package com.acsk.shop.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.acsk.shop.util.Epayment;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name="Shop")
public class Shop implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shop_id")
	@ApiModelProperty(notes = "The database generated recipe ID")
	private long shop_id;
	
	private String shop_name;
	private String shop_description;
	
	@ElementCollection
	@CollectionTable(name="shop_services")
	private List<String> shop_services;
	
	@ElementCollection
	@CollectionTable(name="shop_contacts")
	private List<String> shop_contact;
	private String shop_landmark;
	private String shop_address;
	private String shop_zip;
	private String shop_area;
	private String shop_city;
	private String shop_type;
	
	/*//private List<Map<String, String>> openingHours;
	
	@ElementCollection
    @MapKeyColumn(name="day")
    @Column(name="hrs")
    @CollectionTable(name="Shop_OpeningHours", joinColumns=@JoinColumn(name="shop_id"))
    Map<String, String> openingHours = new HashMap<String, String>(); // maps from attribute name to value
*/
	
	@Enumerated(EnumType.STRING)
	private Epayment epayments;
	//private List<Double> priceRange;
	
	@Column(name="aggregateRating", columnDefinition="Decimal(1,2) default '0.0'")
	private double aggregateRating;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_geo_id")
	private GeoLocation geoLocation;
	
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	 @JoinTable(
	            name="shop_opening_hours",
	            joinColumns = @JoinColumn( name="shop_id"),
	            inverseJoinColumns = @JoinColumn( name="openhrs_id")
	    )
	private Set<OpeningHours> openingHours = new HashSet<OpeningHours>();
	
/*	public List<Map<String, String>> getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(List<Map<String, String>> openingHours) {
		this.openingHours = openingHours;
	}
	public List<Double> getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(List<Double> priceRange) {
		this.priceRange = priceRange;
	}*/
	
	
	public Set<OpeningHours> getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(Set<OpeningHours> openingHours) {
		this.openingHours = openingHours;
	}
	public Epayment getEpayments() {
		return epayments;
	}
	public void setEpayments(Epayment epayments) {
		this.epayments = epayments;
	}
	
	public double getAggregateRating() {
		return aggregateRating;
	}

	public void setAggregateRating(double aggregateRating) {
		this.aggregateRating = aggregateRating;
	}
	public GeoLocation getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public long getShop_id() {
		return shop_id;
	}
	public void setShop_id(long shop_id) {
		this.shop_id = shop_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getShop_description() {
		return shop_description;
	}
	public void setShop_description(String shop_description) {
		this.shop_description = shop_description;
	}
	public List<String> getShop_services() {
		return shop_services;
	}
	public void setShop_services(List<String> shop_services) {
		this.shop_services = shop_services;
	}
	public List<String> getShop_contact() {
		return shop_contact;
	}
	public void setShop_contact(List<String> shop_contact) {
		this.shop_contact = shop_contact;
	}
	public String getShop_landmark() {
		return shop_landmark;
	}
	public void setShop_landmark(String shop_landmark) {
		this.shop_landmark = shop_landmark;
	}
	public String getShop_address() {
		return shop_address;
	}
	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}
	public String getShop_zip() {
		return shop_zip;
	}
	public void setShop_zip(String shop_zip) {
		this.shop_zip = shop_zip;
	}
	public String getShop_area() {
		return shop_area;
	}
	public void setShop_area(String shop_area) {
		this.shop_area = shop_area;
	}
	public String getShop_city() {
		return shop_city;
	}
	public void setShop_city(String shop_city) {
		this.shop_city = shop_city;
	}
	public String getShop_type() {
		return shop_type;
	}
	public void setShop_type(String shop_type) {
		this.shop_type = shop_type;
	}
	
	
}
