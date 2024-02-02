import React, { useState } from "react";
import {Link,BrowserRouter} from "react-router-dom";
import ImgAnnLight from "../assets/Icons/announcement_light.png";
import ImgAttenLight from "../assets/Icons/attendance_light.png";
import ImgScheLight from "../assets/Icons/schedule_light.png";
import ImgGradLight from "../assets/Icons/grades_light.png";
import ImgFeesLight from "../assets/Icons/fees_light.png";
import ImgInst from "../assets/Icons/institute.png";
import ImgCloseLight from "../assets/Icons/close_light.png";
import SideMenuRouter from "./SideMenuRouter";
import "../css/SideBar.css";

function SideMenu(props) {
    function toggleMenu(){
        props.setMenuVisibility(!props.menuVisibility);
      }

    return (<div>
    <div className="container-side-menu expanded" >
        <img src={ImgCloseLight} placeholder="image" id="img-close" alt="Menu Icon" onClick={toggleMenu}/>
        <div className="menu-option" id="container-inst-details">
            <img src={ImgInst} placeholder="institute image" id="img-inst" className="img-menu-expanded" alt="Menu Icon"/>
            <span id="institute">Sunbeam Institue of Technology</span>     
        </div>
        <div className="menu-option">
            <span id="username">Hello Kunal!</span>         
        </div>
        <Link to="/announcements">
            <div className="menu-option">
                <img src={ImgAnnLight} id="img-ann" className="img-menu-expanded" alt="announcement logo"/>
                <span>Announcements</span>
            </div>
        </Link>
        <Link to="/attendance">
            <div className="menu-option"> 
                <img src={ImgAttenLight} id="img-att" className="img-menu-expanded" alt="attendance logo"/>
                <span>Attendance</span>
            </div>
        </Link> 
        <Link to="/schedule">
            <div className="menu-option">
                <img src={ImgScheLight} id="img-sche" className="img-menu-expanded" alt="schedule logo"/>
                <span>Schedule</span>
            </div>
        </Link>
        <Link to="/grades">
            <div className="menu-option">
                <img src={ImgGradLight} id="img-grad" className="img-menu-expanded" alt="grades logo"/>
                <span>Grades</span>
            </div>
        </Link>
        <Link to="/fees">
            <div className="menu-option">
                <img src={ImgFeesLight} id="img-fees" className="img-menu-expanded" alt="fees logo"/>
                <span>Fees</span>
            </div>
        </Link>
    </div>
    <SideMenuRouter id="side-menu-output"/>
  </div>);
}

export default SideMenu;