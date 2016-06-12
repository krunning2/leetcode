Define sell[ i ] as up to ith day what the max profit made for any sequence end with sell
Define buy[ i ] as up to ith day what the max profit made for any sequence end with buy.

So buy[ i ] may have two cases, buy on ith day, so the profit is sell[i - 2] + rest( 0 ) - price[i] (It has to sell -> rest -> buy ), or buy don't buy on ith day, so profit = buy[i - 1].

For sell[ i ], if sell on ith day, the profit is price[ i ] - buy[i - 1], or don't sell on ith day, then the profit is sell[i - 1];

initialize: 
buy[0] = -prices[0]; // day0 profit is negative,
buy[1] = Math.max(-prices[0], -prices[1]);
sell[1] = Math.max(0, prices[1] - prices[0]); day0 is 0


https://www.hrwhisper.me/leetcode-best-time-to-buy-and-sell-stock-with-cooldown/
http://www.cnblogs.com/grandyang/p/4997417.html