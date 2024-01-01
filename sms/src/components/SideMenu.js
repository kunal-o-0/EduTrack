import React from "react";
import {Link,BrowserRouter} from "react-router-dom";
import ImgAnnLight from "../assets/Icons/announcement_light.png";
import ImgAttenLight from "../assets/Icons/attendance_light.png";
import ImgScheLight from "../assets/Icons/schedule_light.png";
import ImgGradLight from "../assets/Icons/grades_light.png";
import ImgFeesLight from "../assets/Icons/fees_light.png";
import "../css/SideMenu.css";

function SideMenu() {
    return ( <div className="side-menu collapsed" >
    <BrowserRouter>
        <Link to="/announcements">
            <div className="menu-option menu-option-item collapsed-img">
                <img src={ImgAnnLight} id="img-ann" alt="announcement logo"/>
            </div>
        </Link>
        <Link to="/attendance">
            <div className="menu-option menu-option-item collapsed-img"> 
                <img src={ImgAttenLight} id="img-att" alt="attendance logo"/>
            </div>
        </Link> 
        <Link to="/schedule">
            <div className="menu-option menu-option-item collapsed-img">
                <img src={ImgScheLight} id="img-sche" alt="schedule logo"/>
            </div>
        </Link>
        <Link to="/grades">
            <div className="menu-option menu-option-item collapsed-img">
                <img src={ImgGradLight} id="img-grad" alt="grades logo"/>
            </div>
        </Link>
        <Link to="/fees">
            <div className="menu-option menu-option-item collapsed-img">
                <img src={ImgFeesLight} id="img-fees" alt="fees logo"/>
            </div>
        </Link>
    </BrowserRouter>
  </div> );
}

export default SideMenu;