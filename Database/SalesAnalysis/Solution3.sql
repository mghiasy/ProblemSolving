-- with IN and NOT IN -- NOT BETWEEN
-- Runtime: 1244 ms, faster than 65.48%     
select product_id, product_name
from Product 
where product_id in (select product_id from Sales where sale_date between '2019-01-01' and '2019-03-31') 
and product_id not in (select product_id from Sales where sale_date not between '2019-01-01' and '2019-03-31') 