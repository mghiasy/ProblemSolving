-- Using more than 1 sub query in WITH

with subTotlaPrice as
(Select p.product_id, p.price * u.units as totalPrice
    From Prices p inner join UnitsSold u
    on p.product_id=u.product_id 
    where u.purchase_date between start_date and end_date),

subTotalSold as
(Select product_id, sum(u.units) as totalSold
    From UnitsSold u
    group by product_id)


Select s1.product_id,Round(Sum(totalPrice)/totalSold ,2) as average_price
From subTotlaPrice s1 inner join subTotalSold s2
on s1.product_id=s2.product_id
group by s1.product_id
