import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import tn.esprit.greenworld.models.User


@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM User WHERE _id = :userId")
    fun getUserById(userId: Long): User

    @Query("SELECT * FROM User WHERE email = :email")
    fun getUserByEmail(email: String): User

    @Query("SELECT * FROM User WHERE username = :username")
    fun getUserByUsername(username: String): User
}
