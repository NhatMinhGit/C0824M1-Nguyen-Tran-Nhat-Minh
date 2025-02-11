use QuanLySinhVien;
-- Join table query
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark, Sub.Credit,Cls.StartDate
FROM Student S 
join Mark M on S.StudentId = M.StudentId 
join Subject Sub on M.SubId = Sub.SubId
join Class Cls on Cls.ClassId = Cls.ClassId;
-- Find student have name start with h
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark, Sub.Credit,Cls.StartDate
FROM Student S 
join Mark M on S.StudentId = M.StudentId 
join Subject Sub on M.SubId = Sub.SubId
join Class Cls on Cls.ClassId = Cls.ClassId
Where lower(S.StudentName) like '%h';
-- Find subject have credits around 3 to 5
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark, Sub.Credit,Cls.StartDate
FROM Student S 
join Mark M on S.StudentId = M.StudentId 
join Subject Sub on M.SubId = Sub.SubId
join Class Cls on Cls.ClassId = Cls.ClassId
Where Sub.Credit between 3 and 5;
-- Find classes have start date in December
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark, Sub.Credit,Cls.StartDate
FROM Student S 
join Mark M on S.StudentId = M.StudentId 
join Subject Sub on M.SubId = Sub.SubId
join Class Cls on Cls.ClassId = Cls.ClassId
Where month(Cls.StartDate) = 12;
-- Show student with Descending mark and Ascending StudentName if marks are equal
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark, Sub.Credit,Cls.StartDate
FROM Student S 
join Mark M on S.StudentId = M.StudentId 
join Subject Sub on M.SubId = Sub.SubId
join Class Cls on Cls.ClassId = Cls.ClassId
ORDER BY M.Mark DESC, S.StudentName ASC;
-- Update Hung's studentId to 2
update student 
set StudentId = 2
where StudentName = 'Hung';

describe student;
