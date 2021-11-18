package ua.com.alevel.fishing_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.alevel.fishing_shop.entity.Brand;
import ua.com.alevel.fishing_shop.repository.BrandRepository;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> findAll(){
       return brandRepository.findAll();
    }
}
