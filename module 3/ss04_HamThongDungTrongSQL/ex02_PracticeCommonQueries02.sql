USE QuanLySinhVien;

Select *
From subject as sub
where sub.Credit = (select max(Credit) from subject);


Select sub.SubId, sub.SubName, M.Mark
From mark as M
join Subject sub on M.SubId = sub.SubId
where M.Mark = (select max(Mark) from mark);

Select S.StudentId ,S.StudentName ,S.ClassId ,AVG(M.Mark)
From student as S
Join mark M on S.StudentId = M.StudentId
Join class Cls on S.ClassId = Cls.ClassID
GROUP BY S.StudentId, S.StudentName, S.ClassId
Order by AVG(M.Mark) Desc;