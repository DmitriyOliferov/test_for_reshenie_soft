package com.oliferov.test_for_reshenie_soft.data.mapper

import com.oliferov.test_for_reshenie_soft.data.database.DbModel.UserDbModel
import com.oliferov.test_for_reshenie_soft.data.network.dto.UserDto
import com.oliferov.test_for_reshenie_soft.domain.model.User

class UserMapper {
    fun mapUserDtoToUserDbModel(userDto: UserDto): UserDbModel {
        with(userDto) {
            return UserDbModel(
                id,
                name,
                username,
                email,
                address.street,
                address.suite,
                address.city,
                address.zipcode,
                address.geo.lat,
                address.geo.lng,
                phone,
                website,
                company.name,
                company.catchPhrase,
                company.bs
            )
        }
    }

    fun mapUserDbModelToUserModel(userDbModel: UserDbModel): User {
        with(userDbModel) {
            return User(
                id,
                name,
                username,
                email,
                street,
                suite,
                city,
                zipcode,
                geoLat,
                geoLng,
                phone,
                website,
                companyName,
                companyCatchPhrase,
                companyBs
            )
        }
    }
}