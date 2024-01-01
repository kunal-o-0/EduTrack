import React, { useState } from "react";
import "./css/Main.css";
import TopBar from "./components/TopBar";
import SideMenu from "./components/SideMenu";

function MenuAppBar() {
  const [menuVisibility,setMenuVisibility]=useState(false);  
  console.log(menuVisibility);
  return ( <div className="parent">
      <TopBar menuVisibility={menuVisibility} setMenuVisibility={setMenuVisibility}/>
      <SideMenu/>
  </div> );
}

export default MenuAppBar;