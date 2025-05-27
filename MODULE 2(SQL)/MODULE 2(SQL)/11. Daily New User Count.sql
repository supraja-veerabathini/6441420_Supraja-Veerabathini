-- 11. Daily New User Count
SELECT registration_date, COUNT(*)
FROM Users
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)
GROUP BY registration_date;