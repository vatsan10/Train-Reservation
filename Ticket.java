package TrainReservationSystem;
import java.util.*;

public class Ticket {
    static int pnr;

    static{
        pnr = 45000;
    }

    public String journeyDate;
    public String boardingStation;
    public String destinationStation;
    private Passenger passenger;
    public int pnrForTicket;
    public String tier;
    public Train train;
    public Ticket(String journeyDate, String boardingStation, String destinationStation, Passenger passenger,String tier,Train train) {
        this.journeyDate = journeyDate;
        this.boardingStation = boardingStation;
        this.destinationStation = destinationStation;
        this.passenger = passenger;
        this.tier = tier;
        this.train = train;
        pnr++;
        pnrForTicket = pnr;
    }

    public void displayPnrStatus(){
        System.out.println("Passenger Name : "+this.passenger.getName());
        System.out.println("Train Number : " + this.train.trainNumber);
        System.out.println("Train Name : " + this.train.trainName);
        System.out.println("Boarding Station : " + this.boardingStation);
        System.out.println("Destination Station : "+ this.destinationStation);
        System.out.println("Tier : " + this.tier);
    }

}
