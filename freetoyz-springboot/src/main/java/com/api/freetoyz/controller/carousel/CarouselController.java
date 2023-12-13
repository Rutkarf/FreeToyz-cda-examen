package com.api.freetoyz.controller.carousel;

import com.api.freetoyz.services.carousel.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/carousel")
public class CarouselController {
    private final CarouselService carouselService;

    @Autowired
    public CarouselController(CarouselService carouselService) {
        this.carouselService = carouselService;
    }

//    @GetMapping("/toyz")
//    public <CarouselToyz> List<CarouselToyz> getCarouselToyzs() {
//        return carouselService.getCarouselToyzs();
//    }
}
