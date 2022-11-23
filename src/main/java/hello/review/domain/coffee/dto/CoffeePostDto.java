package hello.review.domain.coffee.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
public class CoffeePostDto {
    @NotBlank
    private String korName;
    @NotNull
    @Pattern(regexp = "^[A-Za-z]+(\\s?[A-Za-z]+)*$")
    private String engName;
    @NotNull
    @Range(min = 100, max = 50000)
    private Integer price;
}
