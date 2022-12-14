package hello.review.domain.coffee.entity;

import hello.review.values.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {
    private long coffeeId;

    private String korName;

    private String engName;

    private Money price;
}
