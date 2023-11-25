package tn.esprit.greenworld.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val _id: String,
    val nom: String,
    val prenom : String,
    val dateNaissance :Date,
    val adress:String,
    val cin:Int,
    val userName:String,
    val email:String,
    val password:String,
    val lastPaswword:String,
    val isValid:Boolean,
    val imageRes: String,
    val role:Roles

) {
    override fun toString(): String {
        return "User(idUser=$_id, nom='$nom', prenom='$prenom', dateNaissance=$dateNaissance, adress='$adress', cin=$cin, userName='$userName', email='$email', paswword='$password', lastPaswword='$lastPaswword', isValid=$isValid, imageRes=$imageRes, role=$role)"
    }

}
data class User1(
    val email: String,
    val password: String
)
data class User2(
    val email: String,
    val password: String,
    val userName:String
)