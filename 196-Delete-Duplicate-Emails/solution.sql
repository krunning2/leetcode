# Write your MySQL query statement below
DELETE p1 FROM Person as p1, Person as p2
where p1.Email = p2.Email and p1.Id > p2.Id;