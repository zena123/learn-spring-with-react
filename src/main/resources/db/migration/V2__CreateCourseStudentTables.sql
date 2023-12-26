create table if not exists course (
    course_id UUID not null primary key,
    name varchar(255) not null unique,
    description TEXT not null,
    department VARCHAR(200) not null,
    teacher_name VARCHAR(100) NOT NULL
);

create TABLE IF NOT exists student_course(
    student_id UUID  not null REFERENCES student(student_id),
    course_id UUID not null REFERENCES course(course_id),
    start_date date not null,
    end_date date not null,
    grade integer check (grade >=0 and grade <= 100 ),
    unique (student_id, course_id)
);

