package com.yazan98.destiny.server.data.repository;

import com.yazan98.destiny.server.data.entity.phone.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 3:34 PM
 */

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber , Long> {

    PhoneNumber findByUserId(Long userId);

}
