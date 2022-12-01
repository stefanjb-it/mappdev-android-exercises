package at.fh.mappdev.loggingviewsandactivity

sealed class NetworkResult<T> {
    data class NetworkSuccess<T>(
        val value: T
    ) : NetworkResult<T>()

    data class NetworkError<T>(val errorMessage: String) : NetworkResult<T>()
    //class NetworkLoading<T> : NetworkResult<T>()
}