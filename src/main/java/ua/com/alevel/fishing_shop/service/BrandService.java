package ua.com.alevel.fishing_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.alevel.fishing_shop.entity.Brand;
import ua.com.alevel.fishing_shop.exception.BrandNotFoundException;
import ua.com.alevel.fishing_shop.repository.BrandRepository;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand findBrandByName(String name) {
        return brandRepository.findByName(name).orElseThrow(()
                -> new BrandNotFoundException(name));
    }

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }
}
