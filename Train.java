package TrainReservationSystem;
import java.util.*;


public class Train {
    public int trainNumber;
    public String trainName;
    public Map<String,Integer> tiersAndAvailability = new HashMap<String,Integer>();
    public static Map<String,Map<String,Integer>> dateTierAvailability = new HashMap<String,Map<String,Integer>>();


    public String startingStation;
    public String endingStation;
    public String departureTime;
    public String arrivalTime;

    public Train(int trainNumber, String trainName, String startingStation,
            String endingStation, String departureTime, String arrivalTime) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;

        this.startingStation = startingStation;
        this.endingStation = endingStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        tiersAndAvailability.put("SL", 0);
        tiersAndAvailability.put("1AC",1);
        tiersAndAvailability.put("2AC",2);
        tiersAndAvailability.put("3AC",2);
        tiersAndAvailability.put("2S",1);
    }

    public void displayAvailibity(){
        for(Map.Entry<String,Integer> tier:tiersAndAvailability.entrySet()){
            System.out.println(tier.getKey() + " "+tier.getValue());
        }
    }

    public Ticket bookTicket(Passenger currentPassenger){
                Ticket ticket = null;
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter journey date (dd-mm-yyyy): ");
                String date = sc.nextLine();
                System.out.println("Enter Boarding Station : ");
                String boardingStation = sc.nextLine();
                System.out.println("Destination Station : ");
                String destinationStation = sc.nextLine();
                System.out.println("Enter Tier : ");
                String tier = sc.nextLine();
                int availability = tiersAndAvailability.get(tier);

                if(availability == 0)
                    System.out.println("No Seats Available...");
                else{
                    ticket = new Ticket(date,boardingStation,destinationStation,currentPassenger,tier,this);
                    tiersAndAvailability.put(tier, availability - 1);
                }
                return ticket;

    }
    
}
