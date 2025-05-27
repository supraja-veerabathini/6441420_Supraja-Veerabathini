-- 8. Sessions per Upcoming Event
SELECT E.title, COUNT(S.session_id)
FROM Events E
JOIN Sessions S ON E.event_id = S.event_id
WHERE E.status = 'upcoming'
GROUP BY E.title;