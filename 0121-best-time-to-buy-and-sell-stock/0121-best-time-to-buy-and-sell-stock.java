class Solution {
    public int maxProfit(int[] prices) {
         if(prices==null && prices.length==0)
         {
            return 0;
         }
         int minprice=Integer.MAX_VALUE;
         int maxprofit=0;
         for(int price:prices)
         {
            if(price<minprice)
            {
                minprice=price;
            }
            if(price-minprice>maxprofit)
            {
                maxprofit=price-minprice;
            }
         }
         return maxprofit;
    }
}