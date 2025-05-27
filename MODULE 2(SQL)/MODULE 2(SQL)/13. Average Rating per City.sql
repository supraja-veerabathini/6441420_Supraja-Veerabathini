-- 13. Average Rating per City
SELECT E.city, AVG(F.rating)
FROM Events E
JOIN Feedback F ON E.event_id = F.event_id
GROUP BY E.city;