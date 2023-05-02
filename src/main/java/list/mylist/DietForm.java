package list.mylist;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DietForm {

    @NotEmpty(message = "식단을 입력하세요.")
    private String content;
}
