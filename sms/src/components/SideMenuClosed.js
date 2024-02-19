import React from "react";
import { Link, BrowserRouter, Outlet } from "react-router-dom";
import ImgAnnLight from "../assets/Icons/announcement_light.png";
import ImgAttenLight from "../assets/Icons/attendance_light.png";
import ImgScheLight from "../assets/Icons/schedule_light.png";
import ImgGradLight from "../assets/Icons/grades_light.png";
import ImgFeesLight from "../assets/Icons/fees_light.png";
import "../css/SideBar.css";

function SideMenu() {
  return (
    <div>
      <div className="container-side-menu collapsed">
        <Link to="announcements">
          <div className="menu-option" id="first">
            <img
              src={ImgAnnLight}
              id="img-ann"
              className="img-menu-collapsed"
              alt="announcement logo"
            />
          </div>
        </Link>
        <Link to="attendance">
          <div className="menu-option">
            <img
              src={ImgAttenLight}
              id="img-att"
              className="img-menu-collapsed"
              alt="attendance logo"
            />
          </div>
        </Link>
        <Link to="schedule">
          <div className="menu-option">
            <img
              src={ImgScheLight}
              id="img-sche"
              className="img-menu-collapsed"
              alt="schedule logo"
            />
          </div>
        </Link>
        <Link to="grades">
          <div className="menu-option">
            <img
              src={ImgGradLight}
              id="img-grad"
              className="img-menu-collapsed"
              alt="grades logo"
            />
          </div>
        </Link>
        <Link to="fees">
          <div className="menu-option">
            <img
              src={ImgFeesLight}
              id="img-fees"
              className="img-menu-collapsed"
              alt="fees logo"
            />
          </div>
        </Link>
      </div>
      <Outlet />
    </div>
  );
}

export default SideMenu;
