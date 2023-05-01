package list.mylist.service;

import list.mylist.DataNotFoundException;
import list.mylist.entity.Workout;
import list.mylist.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor //생성자 주입
@Service
public class WorkoutService {

    // 서비스는 엔티티 객체를 DTO 객체로 변환.

    private final WorkoutRepository workoutRepository;

    public List<Workout> getList() {
        return this.workoutRepository.findAll();
    }

    public Workout getWorkout(Integer id) {
        Optional<Workout> workout = this.workoutRepository.findById(id);

        if (workout.isPresent()) {
            return workout.get();
        } else {
            throw new DataNotFoundException("운동 기록을 찾지 못했습니다.");
        }
    }
}
