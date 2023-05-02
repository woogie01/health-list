package list.mylist.repository;

import list.mylist.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {
    Workout findBySubject(String subject);
    Workout findBySubjectAndContent(String subject, String content);

    // 응답 결과가 여러개인 경우, List<Workout>으로 설정.
    List<Workout> findBySubjectLike(String subject);
}
