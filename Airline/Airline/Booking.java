/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package Airline;

// line 48 "../main.ump"
public class Booking
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Booking Attributes
  private String seatNumber;

  //Booking Associations
  private SpecificFlight specificFlight;
  private PassengerRole passengerRole;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Booking(String aSeatNumber, SpecificFlight aSpecificFlight, PassengerRole aPassengerRole)
  {
    seatNumber = aSeatNumber;
    boolean didAddSpecificFlight = setSpecificFlight(aSpecificFlight);
    if (!didAddSpecificFlight)
    {
      throw new RuntimeException("Unable to create booking due to specificFlight");
    }
    boolean didAddPassengerRole = setPassengerRole(aPassengerRole);
    if (!didAddPassengerRole)
    {
      throw new RuntimeException("Unable to create booking due to passengerRole");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSeatNumber(String aSeatNumber)
  {
    boolean wasSet = false;
    seatNumber = aSeatNumber;
    wasSet = true;
    return wasSet;
  }

  public String getSeatNumber()
  {
    return seatNumber;
  }

  public SpecificFlight getSpecificFlight()
  {
    return specificFlight;
  }

  public PassengerRole getPassengerRole()
  {
    return passengerRole;
  }

  public boolean setSpecificFlight(SpecificFlight aSpecificFlight)
  {
    boolean wasSet = false;
    if (aSpecificFlight == null)
    {
      return wasSet;
    }

    SpecificFlight existingSpecificFlight = specificFlight;
    specificFlight = aSpecificFlight;
    if (existingSpecificFlight != null && !existingSpecificFlight.equals(aSpecificFlight))
    {
      existingSpecificFlight.removeBooking(this);
    }
    specificFlight.addBooking(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setPassengerRole(PassengerRole aPassengerRole)
  {
    boolean wasSet = false;
    if (aPassengerRole == null)
    {
      return wasSet;
    }

    PassengerRole existingPassengerRole = passengerRole;
    passengerRole = aPassengerRole;
    if (existingPassengerRole != null && !existingPassengerRole.equals(aPassengerRole))
    {
      existingPassengerRole.removeBooking(this);
    }
    passengerRole.addBooking(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    SpecificFlight placeholderSpecificFlight = specificFlight;
    this.specificFlight = null;
    placeholderSpecificFlight.removeBooking(this);
    PassengerRole placeholderPassengerRole = passengerRole;
    this.passengerRole = null;
    placeholderPassengerRole.removeBooking(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "seatNumber" + ":" + getSeatNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "specificFlight = "+(getSpecificFlight()!=null?Integer.toHexString(System.identityHashCode(getSpecificFlight())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "passengerRole = "+(getPassengerRole()!=null?Integer.toHexString(System.identityHashCode(getPassengerRole())):"null");
  }
}