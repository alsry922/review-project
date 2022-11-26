package hello.review.domain.coffee.mapper;

import hello.review.domain.coffee.dto.CoffeePatchDto;
import hello.review.domain.coffee.dto.CoffeePostDto;
import hello.review.domain.coffee.dto.CoffeeResponseDto;
import hello.review.domain.coffee.entity.Coffee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    @Mapping(source = "price", target = "price.value")
    Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);

    @Mapping(source = "price", target = "price.value")
    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);

    @Mapping(source = "price.value", target = "price")
    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);

    List<CoffeeResponseDto> coffeesToCoffeeResponseDtos(List<Coffee> coffees);
}
