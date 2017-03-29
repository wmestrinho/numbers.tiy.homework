package com.example.repository;

import com.example.data.Magic;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by WagnerMestrinho on 3/28/17.
 */


public interface MagicRepo extends CrudRepository<Magic, Long> {
    void save(double number);
}
