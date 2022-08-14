package utils;
import com.github.javafaker.Faker;

public class RandomUtils {
    static Faker faker = new Faker();
    public static String getRandomMonth(){
        String month = "";
        int min = 0;
        int max = 11;
        int num = faker.number().numberBetween(min,max);
        switch (num){

            case 0: month = "January";break;
            case 1: month = "February";break;
            case 2: month = "March";break;
            case 3: month = "April";break;
            case 4: month = "May";break;
            case 5: month = "June";break;
            case 6: month = "July";break;
            case 7: month = "August";break;
            case 8: month = "September";break;
            case 9: month = "October";break;
            case 10: month = "November";break;
            case 11: month = "December";break;
        }
        return month;

    }
    public static String getRandomHobby(){
        String hobby = "";
        int num = faker.number().numberBetween(0,2);
        switch (num){
            case 0: hobby = "Reading";break;
            case 1: hobby = "Music";break;
            case 2: hobby = "Sports";break;
        }
        return hobby;
    }
    public static String getRandomGender(){
        String gender = "";
        int num = faker.number().numberBetween(0,2);
        switch (num){
            case 0: gender = "Male";break;
            case 1: gender = "Female";break;
            case 2: gender = "Other";break;
        }
        return gender;
    }

}
