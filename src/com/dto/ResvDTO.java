package com.dto;

public class ResvDTO 
{
	private String seq;
    private String hotelseq;
    private String u_id;
    private String roomseq;
    private String checkin;
    private String checkout;
    private String resvdate;
    private int price;
    private String guest;
    private String cancel;
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getHotelseq() {
		return hotelseq;
	}
	public void setHotelseq(String hotelseq) {
		this.hotelseq = hotelseq;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getRoomseq() {
		return roomseq;
	}
	public void setRoomseq(String roomseq) {
		this.roomseq = roomseq;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public String getResvdate() {
		return resvdate;
	}
	public void setResvdate(String resvdate) {
		this.resvdate = resvdate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
	public String getCancel() {
		return cancel;
	}
	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	public ResvDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResvDTO(String seq, String hotelseq, String u_id, String roomseq, String checkin, String checkout,
			String resvdate, int price, String guest, String cancel) {
		super();
		this.seq = seq;
		this.hotelseq = hotelseq;
		this.u_id = u_id;
		this.roomseq = roomseq;
		this.checkin = checkin;
		this.checkout = checkout;
		this.resvdate = resvdate;
		this.price = price;
		this.guest = guest;
		this.cancel = cancel;
	}
	@Override
	public String toString() {
		return "ResvDTO [seq=" + seq + ", hotelseq=" + hotelseq + ", u_id=" + u_id + ", roomseq=" + roomseq
				+ ", checkin=" + checkin + ", checkout=" + checkout + ", resvdate=" + resvdate + ", price=" + price
				+ ", guest=" + guest + ", cancel=" + cancel + "]";
	}
    
	
    
}
