package TrainReservationSystem;

public class Passenger {
    private int passengerId;
    private String password;
    private String name;
    private long phoneNumber;
    

    public Passenger(int passengerId, String password, String name, long phoneNumber) {
        this.passengerId = passengerId;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public int getPassengerId() {
        return passengerId;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    
    public long getPhoneNumber() {
        return phoneNumber;
    }
    
   
}
