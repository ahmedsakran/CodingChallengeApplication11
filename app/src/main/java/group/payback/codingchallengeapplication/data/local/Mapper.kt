package group.payback.codingchallengeapplication.data.local

import group.payback.codingchallengeapplication.data.local.entities.SearchWithHits
import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.domain.models.ImagesResponse


fun group.payback.codingchallengeapplication.data.local.entities.Hit.toHitDomain(): Hit {
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
fun SearchWithHits.ToImagesResponsedata(): ImagesResponse {
    return ImagesResponse(
        hits = hits.map { it.toHitDomain() }, total = 0, totalHits = 0
    )
}


