package list.mylist.controller;

import jakarta.validation.Valid;
import list.mylist.DietForm;
import list.mylist.entity.Workout;
import list.mylist.service.DietService;
import list.mylist.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String createDiet(Model model, @PathVariable("id") Integer id, @Valid DietForm dietForm, BindingResult bindingResult) {
        Workout workout = this.workoutService.getWorkout(id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("workout", workout);
            return "workout_detail";
        }
        this.dietService.create(workout, dietForm.getContent());

        return String.format("redirect:/workout/detail/%s", id);
    }
}