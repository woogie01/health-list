package list.mylist;

import list.mylist.entity.Diet;
import list.mylist.entity.Workout;
import list.mylist.repository.DietRepository;
import list.mylist.repository.WorkoutRepository;
import org.hibernate.jdbc.Work;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MyListApplicationTests {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private DietRepository dietRepository;

    @Test
    void saveWorkout() {

        Workout work1 = new Workout();
        work1.setSubject("가슴+삼두");
        work1.setContent("벤치+덤벨+케이블");
        work1.setWorkDate(LocalDateTime.now());
        this.workoutRepository.save(work1); // 첫번째 운동 저장.

        Workout work2 = new Workout();
        work2.setSubject("등+이두");
        work2.setContent("데드+바벨+케이블");
        work2.setWorkDate(LocalDateTime.now());
        this.workoutRepository.save(work2); // 두번째 운동 저장.
    }

    @Test
    void findAll() {
        List<Workout> all = this.workoutRepository.findAll();
        assertEquals(2, all.size());

        Workout workout = all.get(0);
        assertEquals("가슴+삼두", workout.getSubject());
    }

    @Test
    void findWorkoutById() {
        Optional<Workout> workout = this.workoutRepository.findById(1);
        if (workout.isPresent()) {
            Workout workout1 = workout.get();
            assertEquals("가슴+삼두", workout1.getSubject());
        }
    }

    @Test
    void findWorkoutBySubject() {
        Workout workout = this.workoutRepository.findBySubject("가슴+삼두");
        assertEquals(1, workout.getId());
    }

    @Test
    void findWorkoutBySubjectAndContent() {
        Workout workout = this.workoutRepository.findBySubjectAndContent("가슴+삼두", "벤치+덤벨+케이블");
        assertEquals(1, workout.getId());
    }

    @Test
    void findWorkoutBySubjectLike() {
        List<Workout> workouts = this.workoutRepository.findBySubjectLike("가슴%");
        Workout workout = workouts.get(0);
        assertEquals("가슴+삼두", workout.getSubject());
    }

    @Test
    void editWorkout() {
        Optional<Workout> workout = this.workoutRepository.findById(1);
        assertTrue(workout.isPresent());
        Workout workout1 = workout.get();
        workout1.setSubject("어깨+하체");
        this.workoutRepository.save(workout1);
    }

    @Test
    void deleteWorkout() {
        assertEquals(2, this.workoutRepository.count());
        Optional<Workout> workout = this.workoutRepository.findById(1);
        assertTrue(workout.isPresent());
        Workout workout1 = workout.get();
        this.workoutRepository.delete(workout1);
    }

    @Test
    void saveDiet() {
        Optional<Workout> workout = this.workoutRepository.findById(2);
        assertTrue(workout.isPresent());
        Workout workout1 = workout.get();

        Diet diet = new Diet();
        diet.setContent("프로틴");
        diet.setWorkout(workout1); // 어느 날 운동의 답변인지 알기 위해 Workout 객체가 필요.
        diet.setDietDate(LocalDateTime.now());
        this.dietRepository.save(diet);
    }

    @Test
    void findDiet() {
        Optional<Diet> diet = this.dietRepository.findById(1);
        assertTrue(diet.isPresent());
        Diet diet1 = diet.get();
        assertEquals(2, diet1.getWorkout().getId());
    }

    @Test
    @Transactional
    void findDietList() {
        Optional<Workout> workout = this.workoutRepository.findById(2);
        assertTrue(workout.isPresent());
        Workout workout1 = workout.get();

        List<Diet> dietList = workout1.getDietList();

        assertEquals(1, dietList.size());
        assertEquals("프로틴", dietList.get(0).getContent());
    }

    @Test
    void contextLoads() {

    }
}
