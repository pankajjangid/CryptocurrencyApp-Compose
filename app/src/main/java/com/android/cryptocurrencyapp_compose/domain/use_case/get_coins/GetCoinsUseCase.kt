package com.android.cryptocurrencyapp_compose.domain.use_case.get_coins

import com.android.cryptocurrencyapp_compose.common.Resource
import com.android.cryptocurrencyapp_compose.data.remote.dto.toCoin
import com.android.cryptocurrencyapp_compose.domain.model.Coin
import com.android.cryptocurrencyapp_compose.domain.model.CoinDetail
import com.android.cryptocurrencyapp_compose.domain.repository.CoinRepository
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {


    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {

        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach check your internet connection"))
        }
    }
}