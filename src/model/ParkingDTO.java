package model;

import java.time.LocalDateTime;

public class ParkingDTO {
	
	private String car_number;
	private LocalDateTime in_time;
	private LocalDateTime out_time;
	
	public String getCar_number() {
		return car_number;
	}
	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}
	public LocalDateTime getIn_time() {
		return in_time;
	}
	public void setIn_time(LocalDateTime in_time) {
		this.in_time = in_time;
	}
	public LocalDateTime getOut_time() {
		return out_time;
	}
	public void setOut_time(LocalDateTime out_time) {
		this.out_time = out_time;
	}
	
}
