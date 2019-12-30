package com.yazan98.destiny.server.data.repository;

import com.yazan98.destiny.server.data.entity.user.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 3:29 AM
 */

@Repository
public interface ProfileRepository extends MongoRepository<Profile , String> {

    Optional<Profile> findByEmailAndPassword(String email , String password);

}
