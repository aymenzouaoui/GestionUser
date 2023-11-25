package tn.esprit.greenworld.utils

import retrofit2.Call
import retrofit2.http.*
import tn.esprit.greenworld.models.User
interface UserInterface {
    // Créer un nouvel utilisateur
    @POST("user")
    fun createUser(@Body user: User): Call<User>

    // Obtenir un utilisateur par ID
    @GET("user/{id}")
    fun getUserById(@Path("id") userId: Long): Call<User>

    // Mettre à jour les informations d'un utilisateur
    @PUT("user/{id}")
    fun updateUser(@Path("id") userId: Long, @Body updatedUser: User): Call<User>

    // Supprimer un utilisateur
    @DELETE("user/{id}")
    fun deleteUser(@Path("id") userId: Long): Call<Void>

    // Obtenir la liste de tous les utilisateurs
    @GET("user")
    fun getAllUsers(): Call<List<User>>

    // Rechercher un utilisateur par nom
    @GET("user/search")
    fun searchUserByName(@Query("name") name: String): Call<List<User>>


}
