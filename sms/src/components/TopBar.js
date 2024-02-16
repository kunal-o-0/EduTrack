import React, { useEffect, useState } from "react";
import MenuImgLight from "../assets/Icons/menu_light.png";
import ProfileImgLight from "../assets/Icons/profile_white.png";
import "../css/TopBar.css";
import { useSelector } from "react-redux";
import { changeTitle } from "../features/navBarSlice";

function TopBar(props) {
  const title = useSelector((state) => state.navBar.title);

  function toggleMenu() {
    props.setMenuVisibility(!props.menuVisibility);
  }

  return (
    <div>
      <div className="container-top-bar">
        <div className="container-btn-menu" onClick={toggleMenu}>
          <img
            src={MenuImgLight}
            placeholder="image"
            id="img-menu"
            alt="Menu Icon"
          />
        </div>
        <div className="container-title">
          <p id="txt-title">{title}</p>
        </div>
        <div className="container-btn-profile">
          <img
            src={ProfileImgLight}
            placeholder="image"
            id="img-profile"
            alt="Profile Icon"
          />
        </div>
      </div>
    </div>
  );
}

export default TopBar;
