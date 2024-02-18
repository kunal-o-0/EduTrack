import React, { useState } from "react";
import "../css/Main.css";
import TopBar from "../components/TopBar";
import SideMenuClosed from "../components/SideMenuClosed";
import SideMenuExpanded from "../components/SideMenuExpanded";

function Dashboard() {
  const [menuVisibility, setMenuVisibility] = useState(true);

  return (
    <>
      {menuVisibility ? <></> : <div className="layer"></div>}
      <div>
        <TopBar
          menuVisibility={menuVisibility}
          setMenuVisibility={setMenuVisibility}
        />
      </div>
      <div>
        {menuVisibility ? (
          <SideMenuClosed />
        ) : (
          <SideMenuExpanded
            menuVisibility={menuVisibility}
            setMenuVisibility={setMenuVisibility}
          />
        )}
      </div>
    </>
  );
}

export default Dashboard;
