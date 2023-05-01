package list.mylist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
// 운동 파트.
public class Workout {

    @Id // 고유 속성 번호.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스값 자동 증가.
    private Integer id; // 운동 고유 번호.

    private LocalDateTime workDate; // 운동 날짜.

    @Column(length = 200)
    private String subject; // 운동 부위.

    @Column(columnDefinition = "TEXT")
    private String content; // 운동 종목들.

    // 운동 하나를 삭제할 시 그에 대한 식단들도 삭제.
    @OneToMany (mappedBy = "workout", cascade = CascadeType.REMOVE)
    private List<Diet> dietList;
}
