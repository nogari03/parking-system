package controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;

import model.CustomerDAO;
import model.CustomerDTO;

public class Customer {

    static CustomerDAO dao = new CustomerDAO();
    static CustomerDTO dto = new CustomerDTO();

    public static int registerCustomer(HashMap<String, String> userData, LocalDateTime serviceDate) throws SQLException, ClassNotFoundException {

        dto.setName(userData.get("name"));
        dto.setPhone(userData.get("phone"));
        dto.setCarNumber(userData.get("car_number"));
        dto.setServiceEnd(serviceDate);

        if(dao.newCustomer(dto) == 0) {
        	return 0;
        }
        	return -1;
    }
    
    public static void deleteCustomer(String name) throws SQLException, ClassNotFoundException {
    	
    	dto.setName(name);
    	
    	if(dao.deleteCustomer(dto) == 0) {
    	}
    }
    
    public static void updateCustomer(HashMap<String, String> userData) throws SQLException, ClassNotFoundException {
    	
    	dto.setName(userData.get("name"));
        dto.setPhone(userData.get("phone"));
        dto.setCarNumber(userData.get("car_number"));

        if(dao.updateCustomer(dto) == 0) {
        }

    }
    
    public static int checkCustomer(String car_number) throws SQLException {
    	
    	dto.setCarNumber(car_number);
    	
    	if(dao.checkCustomer(dto) > 0 ) {
    		return 0;
    	};
    	
    	return -1;
    }
    public static int checkValid(String car_number) throws SQLException, ClassNotFoundException {
    	
    	dto.setCarNumber(car_number);
    	
    	if(dao.checkValid(dto) == 0) {
    	} else {
    		return -1;
    	}
    		return 0;
    } 
}