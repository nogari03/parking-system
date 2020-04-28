package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class ParkingDAO {
	
	static DBHandler db = new DBHandler();
	
	public int checkInUser(ParkingDTO dto) throws ClassNotFoundException, SQLException{
		Connection c = db.connect();
		
		PreparedStatement preparedStatement = c.prepareStatement(
				"insert into records(car_number,in_time,out_time) value(?,?,?)");
		
		preparedStatement.setString(1, dto.getCar_number());
		preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()+32400000));
		preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()+32400000));
		preparedStatement.executeUpdate();
		preparedStatement.close();
		
		db.disconnect();
		return 0;
	}

	public int checkInGuest(ParkingDTO dto) throws ClassNotFoundException, SQLException{
		Connection c = db.connect();
		
		PreparedStatement preparedStatement = c.prepareStatement(
				"insert into guest_records(car_number,in_time,out_time) value(?,?,?)");
		
		preparedStatement.setString(1,  dto.getCar_number());
		preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()+32400000));
		preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()+32400000));
		preparedStatement.executeUpdate();
		preparedStatement.close();
		
		db.disconnect();
		return 0;
	}
	
	public int checkOutUserCar(ParkingDTO dto) throws ClassNotFoundException, SQLException{
		Connection c = db.connect();
		
		PreparedStatement preparedStatement = c.prepareStatement(
				"delete from records where car_number = ?");
		
		preparedStatement.setString(1, dto.getCar_number());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		
		db.disconnect();
		return 0;
				
	}
	
	public int checkOutGuestCar(ParkingDTO dto) throws ClassNotFoundException, SQLException{
		Connection c = db.connect();
		
		PreparedStatement preparedStatement = c.prepareStatement(
				"delete from guest_records where car_number = ?");
		
		preparedStatement.setString(1, dto.getCar_number());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		
		db.disconnect();
		return 0;
	}
	
	public int calculateTime(ParkingDTO dto) throws ClassNotFoundException, SQLException{
		Connection c = db.connect();
		Statement stat = c.createStatement();
		
		PreparedStatement preparedStatement = c.prepareStatement(
				"SELECT timestampdiff(MINUTE, in_time, now()) AS pay FROM guest_records WHERE car_number=?;");
		
		preparedStatement.setString(1, dto.getCar_number());
		
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		
		preparedStatement.close();
		stat.close();
		db.disconnect();
		
		return 0;
	}
}
	