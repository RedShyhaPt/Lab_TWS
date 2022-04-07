package server.database.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    int custId;
    String custName;
    String contact;
    String city;
    String country;
    String sex;

    public Customer(String custName, String contact, String city, String country, String sex, int custId) {
        this.custName = custName;
        this.contact = contact;
        this.city=city;
        this.country = country;
        this.sex = sex;
    }
}
