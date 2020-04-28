package model;

import java.time.LocalDateTime;

public class CustomerDTO {

    private String name;
    private String phone;
    private String car_number;
    private LocalDateTime service_end;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarNumber() {
        return car_number;
    }

    public void setCarNumber(String car_number) {
        this.car_number = car_number;
    }

    public LocalDateTime getServiceEnd() {
        return service_end;
    }

	public void setServiceEnd(LocalDateTime service_end) {
		this.service_end = service_end;
	}
}
