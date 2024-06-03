Day_20;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZoneConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter date and time (yyyy-MM-dd HH:mm): ");
        String dateTimeString = scanner.nextLine();
        
        
        System.out.println("Enter source timezone (e.g., America/New_York): ");
        String sourceTimezone = scanner.nextLine();
        
        
        System.out.println("Enter target timezone (e.g., Asia/Tokyo): ");
        String targetTimezone = scanner.nextLine();

        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
        
       
        ZonedDateTime sourceZonedDateTime = localDateTime.atZone(ZoneId.of(sourceTimezone));
        
       
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(ZoneId.of(targetTimezone));
        
        
        String formattedTargetDateTime = targetZonedDateTime.format(formatter);
        System.out.println("Converted date and time in target timezone: " + formattedTargetDateTime);
    }
}

