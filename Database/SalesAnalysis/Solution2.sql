-- 2 condition on 1 where clause for 1 field which 1 covers 2 => the 2 wont be considered 
-- error
Select buyer_id 
from Sales s join Product p
where s.product_id=p.product_id
and p.product_id in (Select product_id 
                     From Product 
                     where (product_name like 'S8') and (product_name not like 'iPhone'));
                     
-- error
Select buyer_id 
from Sales s join Product p
where s.product_id=p.product_id
and p.product_id in (Select product_id 
                     From Product 
                     where product_name like 'S8')  
and p.product_id not in (Select product_id 
                     From Product 
                     where product_name like 'iPhone');
                     
-- you'll need to pull everyone who bought an S8 then exclude everyone who bought an iPhone
 -- change the column for second condition
 select distinct buyer_id
from sales
where product_id=
(select product_id from product where product_name='S8')
and buyer_id not in
(select buyer_id from sales where product_id=(select product_id from product where product_name='iphone'))