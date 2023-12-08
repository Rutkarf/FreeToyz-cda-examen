package com.api.freetoyz.services.carousel;

import com.api.freetoyz.repository.carousel.CarouselItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselService {
    private final CarouselItemRepository carouselItemRepository;

    @Autowired
    public CarouselService(CarouselItemRepository carouselItemRepository) {
        this.carouselItemRepository = carouselItemRepository;
    }

    public List<CarouselItem> getCarouselItems() {
        return carouselItemRepository.findAll();
    }
}