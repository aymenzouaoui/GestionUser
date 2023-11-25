

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import tn.esprit.greenworld.utils.RetrofitImp
import tn.esprit.greenworld.utils.UserInterface
import tn.esprit.greenworld.models.User


private val <T> Call<T>.isSuccessful: Boolean
    get() = try {
        execute().isSuccessful
    } catch (e: Exception) {
        false
    }

class UserViewModel : ViewModel() {

    private val userService = RetrofitImp.buildRetrofit().create(UserInterface::class.java)

    private val _userList = MutableLiveData<List<User>>()
    val userList: LiveData<List<User>> get() = _userList

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response = userService.getAllUsers()

                if (response.isSuccessful) {
                    _userList.value = response.body()
                } else {
                    //_errorMessage.value = "Failed to fetch users. Code: ${response.code()}, Message: ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Error fetching users: ${e.message}"
                Log.e("UserViewModel", "Error fetching users", e)
            }
        }
    }
}

private fun <T> Call<T>.body(): T? {
    return try {
        execute().body()
    } catch (e: Exception) {
        null
    } }
