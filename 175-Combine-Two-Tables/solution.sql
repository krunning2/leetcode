# Write your MySQL query statement below
select FirstName, LastName, City, State
from Person as p left Join Address as a on p.PersonId = a.PersonId