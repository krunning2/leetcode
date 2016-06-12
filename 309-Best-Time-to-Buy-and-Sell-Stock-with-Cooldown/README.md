Define sell[ i ] as up to ith day what the max profit made for any sequence end with sell
Define buy[ i ] as up to ith day what the max profit made for any sequence end with buy.

So buy[ i ] may have two cases, buy on ith day, so the profit is sell[i - 2] + rest( 0 ) - price[i] (It has to sell -> rest -> buy ), or buy don't buy on ith day, so profit = buy[i - 1].

For sell[ i ], if sell on ith day, the profit is price[ i ] - buy[i - 1], or don't sell on ith day, then the profit is sell[i - 1];