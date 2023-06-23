package pojos;

public class HerokuApRequestBodyPojo {

  /*  Request body
{
        "firstname" : "Ahmet",
        "lastname" : “Bulut",
        "totalprice" : ,
        "depositpaid" : false,
        "bookingdates" : {
        "checkin" : "2021-06-01",
        "checkout" : "2021-06-10"
        },
        "additionalneeds" : "wi-fi"
        }
*/

    // 1 - Obje icerisindeki tum key degerlerini class levelda private variable olarak hazirla
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingdatesPOJO bookingdates;
    private String additionalneeds;


    // 2 - Getter - Setter lari hazirla

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingdatesPOJO getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingdatesPOJO bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    // 3 - Tum parametreleri iceren Constructor olustur

    public HerokuApRequestBodyPojo(String firstname, String lastname,
                                   int totalprice, boolean depositpaid,
                                   BookingdatesPOJO bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }


    // 4 - Parametresiz Constructor olustur


    // 5 - toString() methodu olustur


    @Override
    public String toString() {
        return "HerokuApRequestBodyPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}