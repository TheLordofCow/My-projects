SELECT  instructor_id, instructor.first_name, instructor.last_name
FROM instructor, student
WHERE instructor_id NOT IN(SELECT advisor_id FROM instructor, student WHERE advisor_id = instructor_id)
GROUP BY instructor_id