import React, {Component} from "react";
import {Formik} from 'formik';
import { Button, Input } from "antd";

const INPUT_BUTTOM_MARGIN = {marginBottom: '10px'};

class AddStudentForm extends Component {
    render() {
        return (
            <Formik
                initialValues={{ firstName: '', lastName: '' ,email: '', gender: '' }}
        
                validate={values => {
                const errors = {};
                if (!values.email) {     
                    errors.email = 'Required';
                } else if (
                    !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.email)
                ) {
        
                    errors.email = 'Invalid email address';
                }
                if(!values.firstName){
                    errors.firstName = 'Required';
                }
                if(!values.lastName){
                    errors.lastName = 'Required';
                }
                if(!values.gender){
                    errors.gender = 'Required';
                } else if (['MALE', 'FEMALE'].includes(values.gender)){
                    errors.gender = "gender must be MALE, FEMALE";
                }
        
                return errors;
        
                }}
        
                onSubmit={(values, { setSubmitting }) => {
        
                setTimeout(() => {
        
                    alert(JSON.stringify(values, null, 2));
        
                    setSubmitting(false);
        
                }, 400);
        
                }}>
        
                {({
        
                values,
        
                errors,
        
                touched,
        
                handleChange,
        
                handleBlur,
        
                handleSubmit,
        
                isSubmitting,
        
                /* and other goodies */
        
                }) => (
        
                <form onSubmit={handleSubmit}>
                    <Input
                    style={INPUT_BUTTOM_MARGIN}
                    name="firstName"       
                    onChange={handleChange}
                    onBlur={handleBlur}
                    value={values.firstName}
                    placeholder="first name"
                    />
                    {errors.firstName && touched.firstName && errors.firstName}
                    <Input
                    style={INPUT_BUTTOM_MARGIN}
                    name="lastName"       
                    onChange={handleChange}
                    onBlur={handleBlur}
                    value={values.lastName}
                    placeholder="last name"
                    />
                    {errors.lastName && touched.lastName && errors.lastName}

                    <Input
                    style={INPUT_BUTTOM_MARGIN}
                    name="email"       
                    onChange={handleChange}
                    onBlur={handleBlur}
                    value={values.email}
                    placeholder="Email"
                    />
                    {errors.email && touched.email && errors.email}
        
                    <Input   
                    style={INPUT_BUTTOM_MARGIN}    
                    name="gender"
                    onChange={handleChange}  
                    onBlur={handleBlur}   
                    value={values.gender}
                    placeholder="gender, MALE,FEMALE"
                    />
        
                    {errors.gender && touched.gender && errors.gender}
        
                    <Button type="submit" disabled={isSubmitting}>
        
                    Submit
        
                    </Button>
        
                </form>
        
                )}
        
            </Formik>
               )
    }
}

export default AddStudentForm;
