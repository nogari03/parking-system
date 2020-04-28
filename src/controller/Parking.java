package controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;

import model.ParkingDAO;
import model.ParkingDTO;

public class Parking {

	static ParkingDAO dao = new ParkingDAO();
	static ParkingDTO dto = new ParkingDTO();
	
	public static void checkInCar(String car_number, LocalDateTime in_time, int is_registerd) throws SQLException, ClassNotFoundException {
		
		dto.setCar_number(car_number);
		dto.setIn_time(in_time);
		
		if(is_registerd == 1){
			if(dao.checkInUser(dto) == 0) {
			}
		}
		else {
			if(dao.checkInGuest(dto) == 0) {
			}
		}
	}
	
	public static void checkOutCar(String car_number, int is_registerd) throws SQLException, ClassNotFoundException {
		
		dto.setCar_number(car_number);
		
		if(is_registerd == 1) {
			if(dao.checkOutUserCar(dto) == 0) {
			}
		}
		else {
			if(dao.checkOutGuestCar(dto) == 0) {
			}
		}
	}
	
	public static int calculateCharge(String car_number, int is_registerd) throws SQLException, ClassNotFoundException, ParseException {
		
		dto.setCar_number(car_number);
		
		if(is_registerd == 1) {
		}
		else {
			if(dao.calculateTime(dto) != 0) {
				int minute = dao.calculateTime(dto);
				int charge = (minute/10) * 1000;	//총 요금
				return charge;
			}
		}
		return 0;
		}

	public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
		
		String cn = "11가1111";
		LocalDateTime inTime = LocalDateTime.now();
		
		checkInCar(cn, inTime, 0);
		Customer.checkValid(cn);
	}
}
