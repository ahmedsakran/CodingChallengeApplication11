package group.payback.codingchallengeapplication.domain



fun group.payback.codingchallengeapplication.domain.models.Hit.toListHit(): group.payback.codingchallengeapplication.data.local.entities.Hit {
    return group.payback.codingchallengeapplication.data.local.entities.Hit(
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


