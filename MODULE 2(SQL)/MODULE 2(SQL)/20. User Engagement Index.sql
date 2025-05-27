-- 20. User Engagement Index
SELECT U.full_name, COUNT(DISTINCT R.event_id), COUNT(DISTINCT F.feedback_id)
FROM Users U
LEFT JOIN Registrations R ON U.user_id = R.user_id
LEFT JOIN Feedback F ON U.user_id = F.user_id
GROUP BY U.user_id;