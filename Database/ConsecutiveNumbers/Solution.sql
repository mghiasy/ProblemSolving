-- Two Times SELF JOIN
Select distinct l1.Num as ConsecutiveNums
From Logs l1 , Logs l2 , Logs l3 
where l2.Id - l1.id =1 
and l3.Id - l2.id =1
and l1.Num= L2.Num
and L2.Num = l3.Num;
 
 
 -- multiple JOIN with multiple conditions
Select distinct l1.Num as ConsecutiveNums
From Logs l1 JOIN Logs l2 on l2.Id - l1.id =1 and l1.Num= L2.Num
JOIN  Logs l3 on l3.Id - l2.id =1 and L2.Num = l3.Num
