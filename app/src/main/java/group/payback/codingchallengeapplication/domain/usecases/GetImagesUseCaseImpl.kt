package group.payback.codingchallengeapplication.domain.usecases

import group.payback.codingchallengeapplication.data.repositories.ImagesRepository
import javax.inject.Inject

class GetImagesUseCaseImpl @Inject constructor(
    private val repository: ImagesRepository,
) : GetImagesUseCase {
    override operator fun invoke(word: String) = repository.getImages(word)
}