SELECT instructor.first_name, instructor.last_name, sum(num_credits) Total_credits
FROM instructor, course
GROUP BY first_name