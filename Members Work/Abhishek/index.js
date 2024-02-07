import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter,Route,Routes } from 'react-router-dom';
import './index.css';
import { Component } from 'react';

import MainLogin from './MainLogin';
import StaffLogin from './StaffLogin';
import Student from './StudentLogin';
import HeadLogin from './HeadLogin'
import Faculty from './FacultyLogin'
import StudentLogin from './StudentLogin';
import ResetPass from './ResetPass';
import ForgotPass from './ForgotPass';
import Launcher from './Launcher';





const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <>
    <MainLogin />
  </>
  // <>
  //   <MainLogin />
  // </>
//   <>
//   <StaffLogin />
// </>
// <>
 //   <StudentLogin />
  //</> 
//   <>
//   <HeadLogin />
// </>
// <>
//     <FacultyLogin />
//   </>
//   <>
//   <FacultyLogin />
// </>
//   <>
//   <ResetPass />
// </>
  // <>
  //  <ForgotPass />
  // </>
);



