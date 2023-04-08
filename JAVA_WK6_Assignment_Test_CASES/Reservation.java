/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omora
 *
 */
import java.util.*;
import java.text.SimpleDateFormat;

public class Reservation {
    
    private String datePattern = "MMM dd, yyyy";
    private UUID reservationID;
    private Date reservationDate;
    private int guestID;
    private String roomType;
    private String reservationStartDate;
    private String reservationEndDate;
    private long reservationNumberOfDays;

   
    public Reservation(
        int guestID,
        String roomType, 
        String reservationStartDate,
        String reservationEndDate ) {

        this.reservationID = UUID.randomUUID(); // gen a unique ID
        this.reservationDate = new Date();      // get current date
        this.guestID = guestID;
        this.roomType = roomType;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
    }
    
    // getters
    public UUID getReservationID() {
    return this.reservationID;
    }
    
    public Date getReservationDate() {
        return this.reservationDate;
    }
    
    public int getGuestID() {
        return this.guestID;
    }
    
    public String getRoomType() {
        return this.roomType;
    }
    
    public String getReservationStartDate() {
        return this.reservationStartDate;
    }
    
    public String getReservationEndDate() {
        return this.reservationEndDate;
    }
     
    
    // setters
    public void setGuestID(int newValue) {
        this.guestID = newValue;
    }
    
    public void setRoom(String newValue) {
        this.roomType = newValue;
    }
    
    public void setReservationStartDate(String newValue) {
        this.reservationEndDate = newValue;
    }
    
    public void setReservationEndDate(String newValue) {
        this.reservationEndDate = newValue;
    }

     
    
    public long calculateReversationNumberOfDays() throws Exception {
        long startTime = new SimpleDateFormat(datePattern).parse(reservationStartDate).getTime();
        long endTime = new SimpleDateFormat(datePattern).parse(reservationEndDate).getTime();
        this.reservationNumberOfDays = (endTime - startTime) / (100 * 60 * 60 * 24);
        return ( (endTime - startTime) / (1000 * 60 * 60 * 24) );
    }
    
    
    
    public double calculateReservationBillAmount() throws Exception{
        if ( roomType.equals("RoomWBath"))
            return (200 * this.reservationNumberOfDays);
        if ( roomType.equals("RoomWView"))
            return (175 * calculateReversationNumberOfDays());
        if ( roomType.equals("NormalRoom"))
            return (120 * calculateReversationNumberOfDays());
        return (0);
    }
    
    
    
    public void updateReservation() {
        //ToDO TBD
    }
        
    
        
    public void dropReservation() {
        //ToDO TBD
    }
}
    
