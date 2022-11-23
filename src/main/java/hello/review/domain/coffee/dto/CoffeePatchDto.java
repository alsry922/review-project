package hello.review.domain.coffee.dto;

import hello.review.validator.NotSpace;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CoffeePatchDto {
    private Long coffeeId;

    @NotSpace
    private String korName;

    @NotSpace
    @Pattern(regexp = "^[A-Za-z]+(\\s?[A-Za-z]+)*$")
    private String engName;

    @Range(min = 100, max = 50000)
    private Integer price;
}
