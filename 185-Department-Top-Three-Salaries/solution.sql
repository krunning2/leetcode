# Write your MySQL query statement below
select dept.Name as Department, emp.Name as Employee, Salary
from Employee as emp join Department as dept on dept.Id = emp.DepartmentId
where 3 > (select count(distinct(emp2.Salary)) from Employee as emp2 
            where emp2.DepartmentId = emp.DepartmentId and emp.Salary < emp2.Salary)