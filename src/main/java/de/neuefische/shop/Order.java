package de.neuefische.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
@Data
@AllArgsConstructor
public class Order {

    @Id
    private String id;
    private String product;
    private String name;
    private String street;
    private String zip;
    private String city;
    private String loggedInUser;

}
