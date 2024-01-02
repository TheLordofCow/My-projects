SELECT course_code, instructor.first_name AS "instructor first name", instructor.last_name AS "instructor last name", SUM(num_credits)
FROM course, student, instructor
WHERE student_id = 1 
AND course.instructor_id = instructor.instructor_id
