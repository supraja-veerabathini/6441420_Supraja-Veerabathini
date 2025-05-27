-- 10. Feedback Gap
SELECT E.title
FROM Events E
JOIN Registrations R ON E.event_id = R.event_id
LEFT JOIN Feedback F ON E.event_id = F.event_id
WHERE F.event_id IS NULL;