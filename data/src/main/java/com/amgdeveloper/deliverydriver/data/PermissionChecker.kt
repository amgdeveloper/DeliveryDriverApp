package com.amgdeveloper.deliverydriver.data

/**
 * Created by amgdeveloper
 */
interface PermissionChecker {

    enum class Permission { FINE_LOCATION }

    suspend fun check(permission: Permission): Boolean
}
