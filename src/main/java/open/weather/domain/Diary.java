package open.weather.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String weather;
    private String icon;
    private double temperature;
    private String text;
    private LocalDate date;

    public static Diary setDateWeather(DateWeather dateWeather){
        return Diary.builder()
                .date(dateWeather.getDate())
                .weather(dateWeather.getWeather())
                .icon(dateWeather.getIcon())
                .build();
    }
}
