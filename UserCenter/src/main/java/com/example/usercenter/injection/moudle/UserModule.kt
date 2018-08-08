package com.example.usercenter.injection.moudle

import com.example.usercenter.service.UserService
import com.example.usercenter.service.impl.UserServiceImp
import dagger.Module
import dagger.Provides

/**
 * Created by lc on 2018/8/8.
 */
@Module
class UserModule {
    @Provides
    fun providesUserService(serviceImp: UserServiceImp): UserService {

        return serviceImp
    }
}