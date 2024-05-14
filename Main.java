package TrainReservationSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Train> trains = new ArrayList<Train>();
        Train T1 = new Train(12601,"Vaigai Exp","Chennai","Madurai","13:50","21:00");
        Train T2 = new Train(12602,"Vaigai Exp","Madurai","Chennai","05:30","11:30");
        Train T3 = new Train(12603,"Brindavan Exp","Chennai","Bangalore","07:40","13:30");
        trains.add(T1);
        trains.add(T2);
        trains.add(T3);
        System.out.println("Enter passengerId : ");
        int passengerId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Password");
        String password = sc.nextLine();


        Passenger currentPassenger = null;
        Map<Integer,Ticket> tickets = new HashMap<Integer,Ticket>();        
        
        System.out.println("Enter your name : ");
        String passengerName = sc.nextLine();
        System.out.println("Enter phone number : ");
        long phoneNumber = sc.nextLong();
        currentPassenger = new Passenger(passengerId,password,passengerName,phoneNumber);

        int trainNumber;
        int choice  = 0;
        while(choice != 4){
        System.out.println("1.Book Tickets");
        System.out.println("2.Check Availibility");
        System.out.println("3.Check PNR Status");
        System.out.println("4.Exit");
        System.out.println("Enter your choice : ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter Train Number");
                trainNumber = sc.nextInt();
                Train currTrain = null;
                for(Train train:trains){
                    if(train.trainNumber == trainNumber){
                        currTrain = train;
                    }
                }
                Ticket ticket = currTrain.bookTicket(currentPassenger);
                tickets.put(Ticket.pnr,ticket);
                if(ticket != null){
                    System.out.println("Booked Successfully...");
                    System.out.println("Your PNR is : " + Ticket.pnr);
                }
                else{
                    System.out.println("Booking Unsuccessful ...");
                }
                break;
            case 2:
                System.out.println("Enter Train Number");
                display(trains);
                break;
            case 3:
                System.out.println("Enter PNR Number : ");
                int pnr = sc.nextInt();
                tickets.get(pnr).displayPnrStatus();
                break;

            default:
                break;
        }
        }
    }

    public static void display(ArrayList<Train> trains){
        for(Train train:trains){
            System.out.println(train.trainName + " " + train.trainNumber + " " + train.departureTime+" "+train.arrivalTime);
            train.displayAvailibity();
        }
    }
}
