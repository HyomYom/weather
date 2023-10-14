package open.weather.domain;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "memo")
@Builder
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // sql이 설정한 키값을 가져오는 설정
    private int id;
    private String text;

}
