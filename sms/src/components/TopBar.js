import React, { useEffect, useState } from "react";
import MenuImgLight from "../assets/Icons/menu_light.png";
import ProfileImgLight from "../assets/Icons/profile_white.png";
import "../css/TopBar.css";
import { useSelector } from "react-redux";
import Styles from "../assets/Style";
import { useNavigate } from "react-router-dom";

function TopBar(props) {
  const [isProfileActive, setIsProfileActive] = useState(false);
  const title = useSelector((state) => state.navBar.title);
  const navigate = useNavigate();

  const handleProfileClick = () => {
    setIsProfileActive(!isProfileActive);
  };

  const handleLogout = () => {
    navigate("/login-register");
  };

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
        <div className="container-btn-profile" onClick={handleProfileClick}>
          <img
            src={ProfileImgLight}
            placeholder="image"
            id="img-profile"
            alt="Profile Icon"
          />
        </div>
      </div>
      <div
        style={{
          position: "absolute",
          top: "4rem",
          right: "0.3rem",
          color: "red",
        }}
      >
        <button
          id="logout"
          style={{
            display: `${isProfileActive ? "block" : "none"}`,
            width: "6rem",
            height: "2.5rem",
            padding: "0.5rem",
            fontSize: "1.2rem",
            color: `${Styles.colors.primary}`,
            fontWeight: "900",
            border: "none",
            cursor: "pointer",
            boxShadow: "-0.3rem 0.3rem 0.5rem grey",
          }}
          onClick={handleLogout}
        >
          Logout
        </button>
      </div>
    </div>
  );
}

export default TopBar;
