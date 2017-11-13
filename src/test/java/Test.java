import java.nio.IntBuffer;
import java.security.SecureRandom;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

public class Test {


    public static void main(String[] args) {


        LocalDate date = LocalDate.of(1999, 10, 26);
        System.out.println(date);

        LocalDate date1 = date.plusYears(18);
        System.out.println(date1);

        LocalDate now = LocalDate.now();

        System.out.println(now);
        System.out.println(now.isBefore(date1));

        System.out.println(new Date(1509206477548l));;

    }

}
