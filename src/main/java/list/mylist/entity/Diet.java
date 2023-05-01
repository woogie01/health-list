package list.mylist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
// 식단 파트.
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 식단 고유 번호.

    private LocalDateTime dietDate; // 먹은 시간.

    @Column(columnDefinition = "TEXT")
    private  String content; // 먹은 음식.

    @ManyToOne // Workout 엔티티의 workout 속성과 Diet 엔티티를 서로 연결.
    private Workout workout; // 식단 엔티티에서 운동 엔티티 탐조를 위해 workout 속성 추가.
}
