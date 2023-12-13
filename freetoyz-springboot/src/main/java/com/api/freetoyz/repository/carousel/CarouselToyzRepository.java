package com.api.freetoyz.repository.carousel;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarouselToyzRepository<CarouselToyz> extends JpaRepository<CarouselToyz, Long> {
    List<CarouselToyz> findAll();


    // Ajoute des méthodes personnalisées si nécessaire
}



