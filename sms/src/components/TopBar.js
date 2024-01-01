import React, { useState } from "react";
import MenuImg from "../assets/Icons/menu_light.png";
import "../css/TopBar.css";

function TopBar(props){
  function expandMenu(){
    console.log(props.menuVisibility);
    props.setMenuVisibility(true);
    console.log("value=true set!")
    console.log(props.menuVisibility);
  }

    return (<div>
      <div className="menu-btn">
        <img src={MenuImg} placeholder="image" id="menu-img" alt="Menu Icon" onClick={expandMenu}/>
      </div>
      <div className="top-bar">
        <div className="top-bar-title">
          <h1 id="txt-title">Announcements</h1>
        </div>
      </div>
    </div> );
}

export default TopBar;