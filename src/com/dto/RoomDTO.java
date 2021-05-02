package com.dto;

public class RoomDTO {
	private String seq;
	private String name;
	private String hotelseq;
	private int price;
	private int max_guest;
	private String room_img;
	private String room_img_real;
	public RoomDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoomDTO(String seq, String name, String hotelseq, int price, int max_guest, String room_img,
			String room_img_real) {
		super();
		this.seq = seq;
		this.name = name;
		this.hotelseq = hotelseq;
		this.price = price;
		this.max_guest = max_guest;
		this.room_img = room_img;
		this.room_img_real = room_img_real;
	}
	@Override
	public String toString() {
		return "RoomDTO [seq=" + seq + ", name=" + name + ", hotelseq=" + hotelseq + ", price=" + price + ", max_guest="
				+ max_guest + ", room_img=" + room_img + ", room_img_real=" + room_img_real + "]";
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
	public String getHotelseq() {
		return hotelseq;
	}
	public void setHotelseq(String hotelseq) {
		this.hotelseq = hotelseq;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMax_guest() {
		return max_guest;
	}
	public void setMax_guest(int max_guest) {
		this.max_guest = max_guest;
	}
	public String getRoom_img() {
		return room_img;
	}
	public void setRoom_img(String room_img) {
		this.room_img = room_img;
	}
	public String getRoom_img_real() {
		return room_img_real;
	}
	public void setRoom_img_real(String room_img_real) {
		this.room_img_real = room_img_real;
	}
	
	
	
	
	

}
