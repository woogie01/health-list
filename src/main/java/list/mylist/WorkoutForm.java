package list.mylist;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutForm {

    @NotEmpty(message = "운동 파트를 입력하세요.")  // 해당 값이 NULL 불가.
    @Size(max = 200)   // 최대 길이 200 바이트
    private String subject;

    @NotEmpty(message = "운동 종목을 입력하세요.")
    private String content;
}
