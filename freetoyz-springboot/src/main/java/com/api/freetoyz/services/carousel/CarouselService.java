package com.api.freetoyz.services.carousel;

import com.api.freetoyz.repository.carousel.CarouselToyzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselService<Carouseltoyz> {
    private final CarouselToyzRepository carouseltoyzRepository;

    @Autowired
    public CarouselService(CarouselToyzRepository carouseltoyzRepository) {
        this.carouseltoyzRepository = carouseltoyzRepository;
    }

    public List<Carouseltoyz> getCarouseltoyzs() {
        return (List<Carouseltoyz>) carouseltoyzRepository.findAll();
    }
}