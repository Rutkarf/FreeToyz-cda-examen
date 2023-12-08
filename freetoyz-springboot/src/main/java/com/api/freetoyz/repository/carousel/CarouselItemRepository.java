package com.api.freetoyz.repository.carousel;

import java.util.List;i

public interface CarouselItemRepository extends JpaRepository<CarouselItem, Long> {
    List<CarouselItem> findAll();
    // Ajoute des méthodes personnalisées si nécessaire
}

