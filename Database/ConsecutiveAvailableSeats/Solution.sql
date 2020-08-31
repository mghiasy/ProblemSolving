
-- using ABS and SELF JOIN
Select distinct c1.seat_id
From cinema c1,cinema c2
where abs(c1.seat_id - c2.seat_id) =1 
and c1.free =1 and c2.free=1
order by c1.seat_id; -- = order by 1

-- join on seat_id+1 or seat_id-1
select distinct a.seat_id
from cinema a join cinema b 
-- *******
on a.seat_id = b.seat_id + 1 or a.seat_id = b.seat_id-1 -- JOJN Condition. --> better than where
where a.free = 1 and b.free = 1 -- = WHERE c1.free + c2.free = 2;
order by a.seat_id;

-- using IN for both seat_id+1,seat_id-1
select distinct seat_id
from cinema 
where free = 1
and (-- needs paranthesis
	seat_id -1 in (Select seat_id from cinema where free = 1)
	or seat_id +1 in (Select seat_id from cinema where free = 1)
	)
order by seat_id;

-- not a good condition -> wrong result
Select distinct c1.seat_id
From cinema c1,cinema c2
where c1.free =1 and c2.free=1
and (c2.seat_id = c1.seat_id + 1 
 or c1.seat_id = c2.seat_id - 1 )
order by c1.seat_id