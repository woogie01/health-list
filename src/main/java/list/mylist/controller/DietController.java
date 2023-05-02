package list.mylist.controller;

import list.mylist.entity.Workout;
import list.mylist.service.DietService;
import list.mylist.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/diet")
@RequiredArgsConstructor
@Controller
public class DietController {

    private final WorkoutService workoutService;
    private final DietService dietService;

    @PostMapping("/create/{id}") // url 요청시 createDiet 메소드 호출.
    public String createDiet(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
        Workout workout = this.workoutService.getWorkout(id);
        this.dietService.create(workout, content);

        return String.format("redirect:/workout/detail/%s", id);
    }
}