package org.sopt.androidseminar1

data class ResponseSignUpData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data
) {
    data class Data(
        val id: Int,
        val email: String,
        val name: String,
        val password: String
    )
}
