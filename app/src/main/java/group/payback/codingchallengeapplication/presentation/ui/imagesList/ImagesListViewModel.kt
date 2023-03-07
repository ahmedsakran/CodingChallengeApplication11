package group.payback.codingchallengeapplication.presentation.ui.imagesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import group.payback.codingchallengeapplication.domain.models.ImagesResponse
import group.payback.codingchallengeapplication.domain.usecases.GetImagesUseCase
import group.payback.codingchallengeapplication.util.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImagesListViewModel @Inject constructor(
    private val getImagesUseCase: GetImagesUseCase,
) : ViewModel() {

    private val _imagesFlow: MutableStateFlow<NetworkResult<ImagesResponse>> = MutableStateFlow<NetworkResult<ImagesResponse>>(
        NetworkResult.Loading())

    val imagesFlow: StateFlow<NetworkResult<ImagesResponse>>
        get() = _imagesFlow.asStateFlow()

    init {
        loadImages("fruits")
    }

    fun loadImages(word: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getImagesUseCase.invoke(word).collect {
                _imagesFlow.emit(it)
            }
        }
    }
}