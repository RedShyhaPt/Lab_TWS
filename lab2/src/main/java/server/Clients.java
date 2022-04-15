package server;

public class Clients {
    private int id;
    private String name;
    private String city;
    private String country;
    private String contact;
    private String sex;

    public Clients() {}

    public Clients(int id, String name,String city,String country,String contact,String sex) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.contact = contact;
        this.sex = sex;
    }

    public  int getId() {return id;}
    public String getName() {return name;}
    public String getCity() {return city;}
    public String getCountry() {return country;}
    public String getContact() {return contact;}
    public String getSex() {return sex;}

    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setCity(String city) {this.city = city;}
    public void setCountry(String country) {this.country = country;}
    public void setContact(String contact) {this.contact = contact;}
    public void setSex(String sex) {this.sex = sex;}

    public String toString() {
        return "Client{name=" + name + ", city=" + city +
                ", country=" + country + ", contact=" + contact +
                ", sex=" + sex + '}';
    }
}