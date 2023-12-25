import fetch from 'unfetch'

export const getAllStudents = () => fetch('api/students');
// student is coming from the form
export const addNewStudent = student => fetch("api/students", {
    headers :{
        "Content-Type" : "application/json"
    },
    method: "POST",
    // send data as json to server
    body: JSON.stringify(student)
}) 