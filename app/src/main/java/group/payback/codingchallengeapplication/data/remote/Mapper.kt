package group.payback.codingchallengeapplication.data.remote

import group.payback.codingchallengeapplication.data.local.entities.SearchWithHits
import group.payback.codingchallengeapplication.data.remote.dto.HitDTO
import group.payback.codingchallengeapplication.data.remote.dto.ImagesResponseDTO
import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.domain.models.ImagesResponse
import group.payback.codingchallengeapplication.domain.models.SearchLog

fun HitDTO.toHit(): Hit {
    return Hit(
        id = id,
        collections = collections,
        comments = comments,
        downloads = downloads,
        imageHeight = imageHeight,
        imageSize = imageSize,
        imageWidth = imageWidth,
        largeImageURL = largeImageURL,
        likes = likes,
        pageURL = pageURL,
        previewHeight = previewHeight,
        previewURL = previewURL,
        previewWidth = previewWidth,
        tags = tags,
        type = type,
        user = user,
        userImageURL = userImageURL,
        user_id = user_id,
        views = views,
        webformatHeight = webformatHeight,
        webformatURL = webformatURL,
        webformatWidth = webformatWidth
    )
}

fun ImagesResponseDTO.toImagesResponse(): ImagesResponse {
    return ImagesResponse(
        hits = hits.map { it.toHit() }, total = total, totalHits = totalHits
    )
}





