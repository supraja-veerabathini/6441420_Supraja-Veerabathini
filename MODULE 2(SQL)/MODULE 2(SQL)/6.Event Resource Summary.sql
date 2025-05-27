-- 6. Event Resource Summary
SELECT E.title,
       SUM(CASE WHEN R.resource_type = 'pdf' THEN 1 ELSE 0 END) as pdf_count,
       SUM(CASE WHEN R.resource_type = 'image' THEN 1 ELSE 0 END) as image_count,
       SUM(CASE WHEN R.resource_type = 'link' THEN 1 ELSE 0 END) as link_count
FROM Events E
LEFT JOIN Resources R ON E.event_id = R.event_id
GROUP BY E.title;
