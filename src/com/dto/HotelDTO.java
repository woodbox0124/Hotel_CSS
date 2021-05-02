package com.dto;

public class HotelDTO {
	private String seq;
	private String name;
	private String place;
	private String addr;
	private double use_count;
	private double rating;
	private String hotel_img;
	private String hotel_img_real;
	
	public HotelDTO() {
		super();
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public double getUse_count() {
		return use_count;
	}

	public void setUse_count(double use_count) {
		this.use_count = use_count;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getHotel_img() {
		return hotel_img;
	}

	public void setHotel_img(String hotel_img) {
		this.hotel_img = hotel_img;
	}

	public String getHotel_img_real() {
		return hotel_img_real;
	}

	public void setHotel_img_real(String hotel_img_real) {
		this.hotel_img_real = hotel_img_real;
	}

	public HotelDTO(String seq, String name, String place, String addr, double use_count, double rating,
			String hotel_img, String hotel_img_real) {
		super();
		this.seq = seq;
		this.name = name;
		this.place = place;
		this.addr = addr;
		this.use_count = use_count;
		this.rating = rating;
		this.hotel_img = hotel_img;
		this.hotel_img_real = hotel_img_real;
	}

	@Override
	public String toString() {
		return "HotelDTO [seq=" + seq + ", name=" + name + ", place=" + place + ", addr=" + addr + ", use_count="
				+ use_count + ", rating=" + rating + ", hotel_img=" + hotel_img + ", hotel_img_real=" + hotel_img_real
				+ "]";
	}

	
	
	

}
