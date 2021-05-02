package com.dto;

public class RoomInfoDTO {
String r_seq;
String bath;
String eat;
String internet;
String etc;
public RoomInfoDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public RoomInfoDTO(String r_seq, String bath, String eat, String internet, String etc) {
	super();
	this.r_seq = r_seq;
	this.bath = bath;
	this.eat = eat;
	this.internet = internet;
	this.etc = etc;
}
@Override
public String toString() {
	return "RoomInfoDTO [r_seq=" + r_seq + ", bath=" + bath + ", eat=" + eat + ", internet=" + internet + ", etc=" + etc
			+ "]";
}
public String getR_seq() {
	return r_seq;
}
public void setR_seq(String r_seq) {
	this.r_seq = r_seq;
}
public String getBath() {
	return bath;
}
public void setBath(String bath) {
	this.bath = bath;
}
public String getEat() {
	return eat;
}
public void setEat(String eat) {
	this.eat = eat;
}
public String getInternet() {
	return internet;
}
public void setInternet(String internet) {
	this.internet = internet;
}
public String getEtc() {
	return etc;
}
public void setEtc(String etc) {
	this.etc = etc;
}


}
