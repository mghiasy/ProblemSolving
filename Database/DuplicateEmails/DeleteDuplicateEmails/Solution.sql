-- using self-Join
delete p1 from Person P1 inner join Person P2
on p1.email=p2.email
and p1.id > p2.id;

-- other way
delete p1 from Person P1, Person P2
where p1.email=p2.email
and p1.id > p2.id;

-- In MySQL, you can't modify the same table which you use in the SELECT part.
-- wrong Answer
DELETE FROM Person
WHERE ID != (
SELECT MIN(id)
FROM Person
Group by Email);

-- to modify we should select the select statement
-- no need to having for every Email we are keeping the least Id
DELETE FROM Person
WHERE ID Not In (
Select * from (
SELECT MIN(id)
FROM Person
Group by Email) t) -- t because Every derived table must have its own alias