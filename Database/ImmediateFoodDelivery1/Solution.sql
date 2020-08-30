-- should not use group by to get the total
Select Round((num/numTotal)* 100 ,2) as immediate_percentage
from ( -- immediate order count
    select Count(delivery_id) as num
    from Delivery
    where datediff(order_date,customer_pref_delivery_date)=0
) t , ( -- all order count
    select Count(delivery_id) as numTotal
    from Delivery
) t2;
 
 -- instead of Count(delivery_id) we can use Count(*)
 Select Round((num/numTotal)* 100 ,2) as immediate_percentage
from ( -- immediate order count
    select Count(*) as num
    from Delivery
    where datediff(order_date,customer_pref_delivery_date)=0
) t , ( -- all order count
    select Count(*) as numTotal
    from Delivery
) t2;

-- directly with out define variables
select Round (
    ((Select Count(delivery_id) from Delivery where datediff(order_date,customer_pref_delivery_date)=0)/
    (Select Count(delivery_id) from Delivery) ) * 100,2
)  as immediate_percentage;