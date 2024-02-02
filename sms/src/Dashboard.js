import React, { useState } from "react";
import {BrowserRouter} from "react-router-dom";
import "./css/Main.css";
import TopBar from "./components/TopBar";
import SideMenuClosed from "./components/SideMenuClosed";
import SideMenuExpanded from "./components/SideMenuExpanded";

function Dashboard() {
  const [menuVisibility,setMenuVisibility]=useState(true); 
  
  return (<BrowserRouter>
  {menuVisibility?<></>:<div className="layer"></div>}
    <div>
        <TopBar menuVisibility={menuVisibility} setMenuVisibility={setMenuVisibility}/>
    </div> 
    <div>
        {menuVisibility? <SideMenuClosed/>:<SideMenuExpanded menuVisibility={menuVisibility} setMenuVisibility={setMenuVisibility}/>}
    </div>
  </BrowserRouter> );
}

export default Dashboard;