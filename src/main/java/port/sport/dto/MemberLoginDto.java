package port.sport.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@Validated
public class MemberLoginDto {

    @Range(min= 4, max= 16)
    String longinId;

    @Range(min= 4, max= 16)
    String password;

    public void sss() {

    }
}
