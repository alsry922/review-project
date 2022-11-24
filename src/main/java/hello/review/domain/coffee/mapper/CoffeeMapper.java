package hello.review.domain.coffee.mapper;

import hello.review.domain.coffee.dto.CoffeePatchDto;
import hello.review.domain.coffee.dto.CoffeePostDto;
import hello.review.domain.coffee.dto.CoffeeResponseDto;
import hello.review.domain.coffee.entity.Coffee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);
    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);
    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);
}
