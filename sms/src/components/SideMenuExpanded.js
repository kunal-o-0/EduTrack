import React, { useState } from "react";
import {Link,BrowserRouter} from "react-router-dom";
import ImgAnnLight from "../assets/Icons/announcement_light.png";
import ImgAttenLight from "../assets/Icons/attendance_light.png";
import ImgScheLight from "../assets/Icons/schedule_light.png";
import ImgGradLight from "../assets/Icons/grades_light.png";
import ImgFeesLight from "../assets/Icons/fees_light.png";
import ImgInst from "../assets/Icons/institute.png";
import "../css/SideMenu.css";

function SideMenu() {
    return ( <div className="side-menu col-2" >
    <BrowserRouter>
        <div className="menu-option menu-option-title">
            <img src={ImgInst} placeholder="institute image" id="img-inst" alt="Menu Icon"/>
            <span id="txt-inst">Sunbeam Institue of Technology</span>     
        </div>
        <div className="menu-option menu-option-username">
            <span id="menu-username">Hello Kunal!</span>         
        </div>
        <Link to="/announcements">
            <div className="menu-option menu-option-item">
                <img src={ImgAnnLight} id="img-ann" alt="announcement logo"/>
                <span>Announcements</span>
            </div>
        </Link>
        <Link to="/attendance">
            <div className="menu-option menu-option-item"> 
                <img src={ImgAttenLight} id="img-att" alt="attendance logo"/>
                <span>Attendance</span>
            </div>
        </Link> 
        <Link to="/schedule">
            <div className="menu-option menu-option-item">
                <img src={ImgScheLight} id="img-sche" alt="schedule logo"/>
                <span>Schedule</span>
            </div>
        </Link>
        <Link to="/grades">
            <div className="menu-option menu-option-item">
                <img src={ImgGradLight} id="img-grad" alt="grades logo"/>
                <span>Grades</span>
            </div>
        </Link>
        <Link to="/fees">
            <div className="menu-option menu-option-item">
                <img src={ImgFeesLight} id="img-fees" alt="fees logo"/>
                <span>Fees</span>
            </div>
        </Link>
    </BrowserRouter>
  </div> );
}

export default SideMenu;