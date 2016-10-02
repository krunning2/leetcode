# Write your MySQL query statement below

select employee.Name as Employee from Employee as employee left join Employee as manager on employee.ManagerId = manager.Id 
where employee.Salary > manager.Salary