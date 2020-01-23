package com.yazan98.destiny.server.config

import com.yazan98.destiny.server.data.entity.main.Collection
import com.yazan98.destiny.server.data.entity.user.Profile
import com.yazan98.destiny.server.data.repository.CollectionRepository
import com.yazan98.destiny.server.data.repository.ProfileRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
open class DatabaseConfiguration @Autowired constructor(
        userRepository: ProfileRepository,
        collectionRepository: CollectionRepository
) {

    init {
        userRepository.save(Profile(
                "Yazan Tarifi",
                "123456789",
                "yazan@gmail.com",
                "ACTIVATED",
                true,
                "image-url",
                "123456789"
        ))

        collectionRepository.save(Collection(
                "https://firebasestorage.googleapis.com/v0/b/culttrip-7da07.appspot.com/o/images%2Flouvre-inside-big.jpg?alt=media&token=a6d00154-730d-4dc7-b359-7c5bc406c364",
                "Ancure History Guide",
                15,
                "NORMAL"
        ))

        collectionRepository.save(Collection(
                "https://firebasestorage.googleapis.com/v0/b/culttrip-7da07.appspot.com/o/images%2Fwp1921783.jpg?alt=media&token=d038fd0d-72ea-457e-975d-2a5b3e0195c3",
                "Wonders of the World",
                20,
                "POPULAR"
        ))

        collectionRepository.save(Collection(
                "https://firebasestorage.googleapis.com/v0/b/culttrip-7da07.appspot.com/o/images%2Fwp1921788.jpg?alt=media&token=e8e182da-0598-4aac-8363-b45b83adc0e9",
                "Eiffel Tower - Paris",
                10,
                "POPULAR"
        ))

        collectionRepository.save(Collection(
                "https://firebasestorage.googleapis.com/v0/b/culttrip-7da07.appspot.com/o/images%2F118ac950-6b72-492c-e8b4-9d30c5114361.jfif?alt=media&token=ba408362-a0ba-489a-bf98-bd090b720ea4",
                "The Ultimate History Guide",
                0,
                "POPULAR"
        ))

        collectionRepository.save(Collection(
                "https://firebasestorage.googleapis.com/v0/b/culttrip-7da07.appspot.com/o/images%2FTaj_Mahal_Wonders_of_the_World_in_Agra_India_HD_Wallpapers.jpg?alt=media&token=7cd4dbfc-e6b6-4c6c-8496-4dfeee144cec",
                "Taj Mahal - India",
                3,
                "NORMAL"
        ))

    }

}