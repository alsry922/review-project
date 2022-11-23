package hello.review.domain.coffee.controller;

import hello.review.domain.coffee.dto.CoffeePatchDto;
import hello.review.domain.coffee.dto.CoffeePostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/coffees")
@Validated
public class CoffeeController {
    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDto coffeePostDto) {

        return new ResponseEntity(coffeePostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@Valid @RequestBody CoffeePatchDto coffeePatchDto,
                                      @PathVariable("coffee-id") @Positive long coffeeId) {
        coffeePatchDto.setCoffeeId(coffeeId);
        return new ResponseEntity(coffeePatchDto, HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
