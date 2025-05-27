-- 16. Unregistered Active Users
SELECT full_name
FROM Users
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)
AND user_id NOT IN (SELECT user_id FROM Registrations);