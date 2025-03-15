package com.android.app.libx.data.api

import com.android.app.libx.data.models.login.LoginRequest
import com.android.app.libx.data.models.login.LoginResponse
import com.android.app.libx.data.models.register.RegisterRequest
import com.android.app.libx.data.models.register.RegisterResponse
import com.android.app.libx.data.models.register.VerifyOtp
import com.android.app.libx.data.models.user.User
import com.android.app.libx.data.models.user.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @GET("api/v1/auth/me")
    suspend fun getUser() : Response<UserResponse>


    // Auth routes

    @POST("api/v1/auth/login")
    suspend fun login(@Body request: LoginRequest) : Response<LoginResponse>

    @GET("api/v1/auth/logout")
    suspend fun logout() : Response<RegisterResponse> //logout response body is same as register response

    @POST("api/v1/auth/register")
    suspend fun register(@Body request: RegisterRequest) : Response<RegisterResponse>

    @POST("api/v1/auth/verify-otp")
    suspend fun verifyOtp(@Body request: VerifyOtp) : Response<LoginResponse> // verify otp response body is same as login response

//    @POST("api/v1/auth/password/forgot-password")
//    suspend fun forgotPassword(@Body request: ForgotPasswordRequest) : Response<ForgotPasswordResponse>
//
//    @PUT("api/v1/auth/password/reset-password/:token")
//    suspend fun resetPassword(@Path("token") token: String, @Body request: ResetPasswordRequest) : Response<ResetPasswordResponse>
//
//    @PUT("api/v1/auth/password/update")
//    suspend fun updatePassword(@Body request: UpdatePasswordRequest) : Response<UpdatePasswordResponse>

    // Admin routes

    @GET("all")
    suspend fun getAllUser() : Response<List<UserResponse>>

//    @POST("add/new-admin")
//    suspend fun registerNewAdmin(@Body request: RegisterRequest) : Response<RegisterResponse>

    // book borrow routes

//    @GET("api/v1/borrow/borrowed-books")
//    suspend fun borrowedBooks() : Response<List<BorrowedBook>>
//
//    @GET("api/v1/borrow/borrowed-books-by-users")
//    suspend fun getBorrowedBooksForAdmin() : Response<List<BorrowedBook>>
//
//    @PUT("api/v1/borrow/return-borrowed-book/{bookId}")
//    suspend fun returnBorrowBook(@Path("bookId") bookId: String) : Response<BorrowedBook>
//
//    @POST("api/v1/borrow/record-borrow-book/{id}")
//    suspend fun recordBorrowedBook(@Path("id") id: String) : Response<BorrowedBook>
//
//    // book routes
//
//    @POST("api/v1/book/add")
//    suspend fun addBook(@Body request: AddBookRequest) : Response<AddBookResponse>
//
//    @GET("api/v1/book/all")
//    suspend fun getAllBooks() : Response<List<Book>>
//
//    @DELETE("api/v1/book/delete/{id}")
//    suspend fun deleteBook(@Path("id") id: String) : Response<Book>


}