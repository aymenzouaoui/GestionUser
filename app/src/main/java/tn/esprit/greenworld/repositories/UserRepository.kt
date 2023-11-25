package tn.esprit.greenworld.repositories

import retrofit2.await
import tn.esprit.greenworld.utils.UserInterface
import tn.esprit.greenworld.models.User

class UserRepository(private val userInterface: UserInterface) {

    // Créer un nouvel utilisateur
    suspend fun createUser(user: User): User {
        return userInterface.createUser(user).await()
    }

    // Obtenir un utilisateur par ID
    suspend fun getUserById(userId: Long): User? {
        return userInterface.getUserById(userId).await()
    }

    // Mettre à jour les informations d'un utilisateur
    suspend fun updateUser(userId: Long, updatedUser: User): User? {
        return userInterface.updateUser(userId, updatedUser).await()
    }

    // Supprimer un utilisateur
    suspend fun deleteUser(userId: Long): Void {
        return userInterface.deleteUser(userId).await()
    }

    // Obtenir la liste de tous les utilisateurs
    suspend fun getAllUsers(): List<User> {
        return userInterface.getAllUsers().await()
    }

    // Rechercher un utilisateur par nom
    suspend fun searchUserByName(name: String): List<User> {
        return userInterface.searchUserByName(name).await()
    }
}