-- by nested select(temporary table) and GROUP BY
Select Email from (
        Select Email as email, Count(Email) as num 
        from Person
        group by Email
) where emCount>1;

-- Using GROUP BY and HAVING
-- my mistake: Aggregate func cannot be in where can be in Having Clause
-- Select Email from Person where Count(Email) >0
Select Email from Person
group by Email
having (Count(Email)>1);

-- equal with this Count(1) =Count(Email) --> Point to the order
Select Email from Person
group by Email
having (Count(1)>1);

-- USE  SELF JOIN instead of EXIST / IN
-- my mistakes :
-- Select Email from Person where Exist(Select Email from Person)
-- Select Email from Person where Email in  (Select Email from Person	
-- need distinct because it will be counted 2 times
Select distinct P1.Email from Person p1, Person P2
where P1.email = p2.email
and P1.Id != P2. Id