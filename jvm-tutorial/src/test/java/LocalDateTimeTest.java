import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class LocalDateTimeTest {

    public static void main(String[] args) {


        LocalDate firstMon = LocalDate.of(LocalDate.now().getYear(), 1, 1);
        LocalDateTime ldt = LocalDateTime.of(firstMon, LocalTime.MIN);
        System.out.println(ldt.toEpochSecond(ZoneOffset.of("+8")));

    }
}
