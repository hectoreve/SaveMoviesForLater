package com.example.savemoviesforlater.model

data class AppResult<out T>(val status: Status, val data: T?, val error: Error?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): AppResult<T> {
            return AppResult(Status.SUCCESS, data, null, null)
        }

        fun <T> error(message: String, error: Error?): AppResult<T> {
            return AppResult(Status.ERROR, null, error, message)
        }

        fun <T> loading(data: T? = null): AppResult<T> {
            return AppResult(Status.LOADING, data, null, null)
        }
    }

    override fun toString(): String {
        return "Result(status=$status, data=$data, error=$error, message=$message)"
    }
}