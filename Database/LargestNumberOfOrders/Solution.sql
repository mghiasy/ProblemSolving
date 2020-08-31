-- left(order_date,7) = '2020-02'


-- using ALL + HAVING
-- Runtime: 547 ms, faster than 63.59% (Nested Query => Slower)
-- Memory Usage: 0B, less than 100.00% 
Select customer_number 
	From(Select customer_number ,Count(customer_number) as numOrders 
            from orders group by customer_number
			having numOrders >= ALL (Select Count(customer_number) as numOrders 
										From orders group by customer_number)) t;
                                        
-- using Max in HAVING
-- Runtime: 516 ms, faster than 80.60%
Select customer_number
	from orders group by customer_number
	having Count(customer_number) = (Select Max(nums) 
                                          from (Select Count(customer_number) as nums 
                                                    from orders group by customer_number) sub1 );


-- using ORDER BY and LIMIT
-- Runtime: 495 ms, faster than 92.22% of MySQL online submissions
-- Memory Usage: 0B, less than 100.00% 
Select customer_number 
	From(Select customer_number ,Count(customer_number) as numOrders 
            From orders group by customer_number
            Order by numOrders Desc limit 1) t;
            
-- better way :
-- Runtime: 472 ms, faster than 98.60% of MySQL online submissions 
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions
Select customer_number
		From orders group by customer_number
		Order by Count(customer_number) Desc limit 1 -- or Count(*)
         