package group.payback.codingchallengeapplication.domain.usecases

import group.payback.codingchallengeapplication.data.repositories.ImageDetailsRepository
import javax.inject.Inject

class GetImageDetailsUseCaseImpl @Inject constructor(
    private val repository: ImageDetailsRepository,
) : GetImageDetailsUseCase {
    override operator fun invoke(imageID: Int) = repository.getImageDetails(imageID)
}