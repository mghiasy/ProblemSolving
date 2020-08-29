
-- because left join allows one table is null and keep another table full
Select p.FirstName,p.LastName, a.City,a.State from LeetCode.Person p left join LeetCode.Address a
on a.personId = p.PersonId;

-- Equivalent to inner Join
Select p.FirstName,p.LastName, a.City,a.State from LeetCode.Person p,LeetCode.Address a
where a.personId = p.PersonId;

