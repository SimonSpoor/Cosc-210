package ui;

public class Date {
    int year;
    int month;
    int day;

    boolean valid = false;

    //Constructors
    public Date(int year, int month, int day){
        //Horrible
        if (((month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12) && day <= 31) ||((month == 4 | month == 6 | month == 9 | month == 11) && day <= 30) || ((month == 2) && (day <= 28 || (year % 4 == 0 && day <= 29)))){
            this.year = year;
            this.month = month;
            this.day = day;
            this.valid = true;
        }
    }

    //Getters
    public int getYear() {return year;}
    public int getMonth() {return month;}
    public int getDay() {return day;}
    public boolean isValid() {return valid;}


    //ToString Method
    public String toString(){
        String dateString = switch (day) {
            case (1) -> "1st of";
            case (2) -> "2nd of";
            case (3) -> "3rd of";
            default -> day + "th of";
        } + switch (month) {
            case (1) -> " January ";
            case (2) -> " February ";
            case (3) -> " March ";
            case (4) -> " April ";
            case (5) -> " May ";
            case (6) -> " June ";
            case (7) -> " July ";
            case (8) -> " August ";
            case (9) -> " September ";
            case (10) -> " October ";
            case (11) -> " November ";
            case (12) -> " December ";
            default -> throw new IllegalStateException("Unexpected value: " + month);
        };
        dateString += year;
        return dateString;
    }
}