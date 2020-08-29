
-- Runtime: 804 ms, faster than 82.12% of Oracle online submissions for Customers Who Never Order.
-- Memory Usage: 0B, less than 100.00% of Oracle online submissions for Customers Who Never Order.

select name as Customers from Customers 
where id not in ( select CustomerId from Orders );

-- Not In with leftJoin
select name as Customers from Customers c left join Orders O
on c.id=o.CustomerId 
where o.id IS Null