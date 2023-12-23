import Container from './Container.js';
import {getAllStudents} from './client.js'
import React, { Component } from 'react';
import { Table, Avatar, Spin } from 'antd';


// const getIcon = () => {
//   <Icon type="loading" style={{fontSize:24}}></Icon>
// }
class  App extends Component {
  state = {
    students: [],
    isFetching: false,
  }
  componentDidMount(){
    this.fetchstudents();
  }
  fetchstudents = () =>{
    this.setState({
      isFetching:true,
    });

    getAllStudents()
    .then(res =>res.json()
    .then(students =>{
      this.setState({
        students: students,
        isFetching:false,
      })
    }));
  
  }
  render(){
    const {students, isFetching} = this.state;
    if (isFetching){
      return (
        <Container> <Spin/></Container>
      )
    }
    if (students && students.length) {
      const columns = [
        {
          title: '',
          key: 'avatar',
          render: (text, student) =>(
            <Avatar size='large'>
              {`${student.firstName.charAt(0).toUpperCase()}${student.lastName.charAt(0).toUpperCase()}`}
            </Avatar>

          )
        },

        { title: 'Student Id',
        dataIndex: 'studentId',
        key:'studentId'
        },
        { title: 'First Name',
        dataIndex: 'firstName',
        key:'firstName'
        },
        { title: 'Last Name',
        dataIndex: 'lastName',
        key:'lastName'
        },
        { title: 'Email',
        dataIndex: 'email',
        key:'email'
        },
        { title: 'Gender',
        dataIndex: 'gender',
        key:'gender'
        }
      ];
      return (
      <Container>
        <Table dataSource={students}
          columns={columns}
          pagination={false}
          rowKey='studentId'/>
        </Container>);
        
      // callback
      // return students.map((student, index)=>{
      //   return (
      //     <div key={index}>
      //       <h2>{student.studentId}</h2>
      //       <p>{student.firstName}</p>
      //       <p>{student.lastName}</p>
      //       <p>{student.gender}</p>
      //     </div>
      //   )
      // })

    }
    return (
      <h1> no students found</h1>
  );
  }
}

export default App;
