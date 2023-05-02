package list.mylist.service;

import list.mylist.entity.Diet;
import list.mylist.entity.Workout;
import list.mylist.repository.DietRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class DietService {

    private final DietRepository dietRepository;

    public void create(Workout workout, String content) {
        Diet diet = new Diet();
        diet.setContent(content);
        diet.setDietDate(LocalDateTime.now());
        diet.setWorkout(workout);
        this.dietRepository.save(diet);
    }
}