import {Route,Switch} from "react-router-dom";
import Announcements from "./Announcements";
import Attendance from "./Attendance";
import Schedule from "./Schedule";
import Grades from "./Grades";
import Fees from "./Fees";

function SideMenuRouter() {
    return ( <Switch>
        <Route path="/announcements" component={Announcements} exact/>
        <Route path="/attendance" component={Attendance} exact/>
        <Route path="/schedule" component={Schedule} exact/>
        <Route path="/grades" component={Grades} exact/>
        <Route path="/fees" component={Fees} exact/>
</Switch> );
}

export default SideMenuRouter;