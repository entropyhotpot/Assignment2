package com.example.assignment2.ui


import com.example.assignment2.Network.ApiClient
import com.example.assignment2.data.authRequest
import com.example.assignment2.data.authResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment2.data.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

    private val _loginResponse = MutableStateFlow<authResponse?>(null)
    val loginResponse: StateFlow<authResponse?> = _loginResponse

    private val _error = MutableStateFlow<Int?>(null)
    val error: StateFlow<Int?> = _error

    var hasNavigatedToDashboard = false

    fun login(username: String, password: String) {
        // Reset the state
        _loginResponse.value = null
        _error.value = null

        val authRequest = authRequest(username, password)
        viewModelScope.launch {
            try {
                val response = repository.authAPI(authRequest)
                _loginResponse.value = response
            } catch (e: HttpException) {
                _error.value = e.code()
            } catch (e: Exception) {
                _error.value = -1 // Unknown error
            }

        }

    }

}