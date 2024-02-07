import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter,Route,Routes } from 'react-router-dom';
import './index.css';


import MainLogin from './MainLogin';
import StaffLogin from './StaffLogin';
import Student from './StudentLogin';
import HeadLogin from './HeadLogin'
import Faculty from './FacultyLogin'
import StudentLogin from './StudentLogin';
import ResetPass from './ResetPass';
import ForgotPass from './ForgotPass';

import { Switch } from 'react-router-dom';
import { Router } from 'react-router-dom/cjs/react-router-dom';


export default function Launcher() {
  return (<div className='container'>
   <Router>
   <Switch>
   
        <Route path="/" exact component={<MainLogin />}>
          {/* <Route index element={<MainLogin />} /> */}
          <Route path="/Login" element={<HeadLogin />} />
          <Route path="/HeadLogin" element={<HeadLogin />} />
          <Route path="/StudentLogin" element={<StudentLogin />} />
          <Route path="/StaffLogin" element={<StaffLogin />} />
          <Route path="/FacultyLogin" element={<Faculty />} />
          {/* <Route path="contact" element={<Contact />} /> */}
          {/* <Route path="*" element={<NoPage />} /> */}
        </Route>
      
   </Switch>
   </Router>
   </div>
  );
}
