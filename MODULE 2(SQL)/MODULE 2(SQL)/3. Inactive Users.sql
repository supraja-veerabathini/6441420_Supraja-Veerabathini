-- 3. Inactive Users
SELECT U.full_name
FROM Users U
LEFT JOIN Registrations R ON U.user_id = R.user_id
WHERE R.registration_date < DATE_SUB(CURDATE(), INTERVAL 90 DAY);