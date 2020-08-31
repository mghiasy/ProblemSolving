-- using ALL
-- Runtime: 1144 ms, faster than 89.78% 
With sub as (Select seller_id,Sum(price) as priceSum
        From Sales group by seller_id)

Select seller_id 
From sub
Where priceSum>= All(Select priceSum from sub );

-- using Max --> Faster than ALL
-- Runtime: 972 ms, faster than 100.00% 
With sub as (Select seller_id,Sum(price) as priceSum
        From Sales group by seller_id)

Select seller_id 
From sub
Where priceSum>= (Select Max(priceSum) from sub );

-- using Dense_rank --> with same value, Dense_Rank will be the same
-- Runtime: 1116 ms, faster than 94.48% 
Select seller_id 
From(Select seller_id, Sum(price) as priceSum, Dense_Rank() over(order by Sum(price) desc) as SaleRank
    From Sales group by seller_id) t
where SaleRank=1

