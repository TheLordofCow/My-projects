SELECT student.first_name AS "student first name", student.last_name AS "student last name", 
instructor.first_name AS "advisor first name", instructor.last_name AS "advisor last name"
FROM student, instructor
WHERE advisor_id = instructor_id