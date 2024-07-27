select w1.id from Weather as w1 , Weather as w2
where datediff(w1.recordDate, w2.recordDate) = 1
and w1.temperature > w2.temperature;

-- select w1.id from Weather w1
-- join Weather w2
-- on w1.recordDate = DATE_ADD(w2.recordDate, interval 1 day)
-- where w1.temperature > w2.temperature