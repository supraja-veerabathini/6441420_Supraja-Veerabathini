-- 24. Average Session Duration per Event
SELECT E.title, AVG(TIMESTAMPDIFF(MINUTE, S.start_time, S.end_time)) AS average_duration
FROM Events E
JOIN Sessions S ON E.event_id = S.event_id
GROUP BY E.title;