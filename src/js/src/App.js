
import {getAllStudents} from './client.js'
import React, { Component } from 'react';

class  App extends Component {
  state = {
    students: []
  }
  componentDidMount(){
    this.fetchstudents();
  }
  fetchstudents = () =>{
    getAllStudents()
    .then(res =>res.json()
    .then(students =>{
      this.setState({
        students: students
      })
    }));
  
  }
  render(){
    const {students} = this.state;
    if (students && students.length) {
      // callback
      return students.map((student, index)=>{
        return (
          <div key={index}>
            <h2>{student.studentId}</h2>
            <p>{student.firstName}</p>
            <p>{student.lastName}</p>
            <p>{student.gender}</p>
          </div>
        )
      })

    }
    return (
      <h1> no students found</h1>
  );
  }
}

export default App;
