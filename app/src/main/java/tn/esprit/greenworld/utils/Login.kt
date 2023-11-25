package tn.esprit.greenworld.utils

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import tn.esprit.greenworld.models.User
import tn.esprit.greenworld.models.User1
import tn.esprit.greenworld.models.User2

interface Login {


    @POST("auth/login") // Assurez-vous d'utiliser le bon endpoint sur votre serveur

    fun login(@Body user: User1): Call<User>

    @POST("/user") // Assurez-vous d'utiliser le bon endpoint sur votre serveur
    fun register(@Body user: User2): Call<User>
}