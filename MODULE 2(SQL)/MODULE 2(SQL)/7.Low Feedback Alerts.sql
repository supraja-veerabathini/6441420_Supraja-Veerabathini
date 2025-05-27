-- 7. Low Feedback Alerts
SELECT U.full_name, F.comments, E.title
FROM Users U
JOIN Feedback F ON U.user_id = F.user_id
JOIN Events E ON F.event_id = E.event_id
WHERE F.rating < 3;