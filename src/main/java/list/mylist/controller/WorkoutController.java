package list.mylist.controller;

import list.mylist.entity.Workout;
import list.mylist.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/workout")
@RequiredArgsConstructor // workoutRepository 속성을 포함하는 생성자 생성.
@Controller
public class WorkoutController {

    // controller -> service -> repository
    // 컨트롤러는 리포지토리 없이 서비스를 통해서만 데이터베이스에 접근하도록 하는 것이 보안상 안전.
    // private final WorkoutRepository workoutRepository;
    private final WorkoutService workoutService;

    @GetMapping("/list")
    public String list(Model model) { // Model 객체에 값을 담아두면 템플릿에서 그 값을 사용 가능.
        // List<Workout> workoutList = this.workoutRepository.findAll();
        List<Workout> workoutList = this.workoutService.getList();
        model.addAttribute("workoutList", workoutList);
        return "workout_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Workout workout = this.workoutService.getWorkout(id);
        model.addAttribute("workout", workout);
        return "workout_detail";
    }
}
