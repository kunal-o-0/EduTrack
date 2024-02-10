import { BrowserRouter, Route, Routes } from "react-router-dom";
import Announcements from "./Announcements";
import Attendance from "./Attendance";
import Schedule from "./Schedule";
import Grades from "./Grades";
import Fees from "./Fees/Fees";
import PaymentDetails from "./Fees/PaymentDetails";
import PayFees from "./Fees/PayFees";

function SideMenuRouter() {
  return (
    <Routes>
      <Route path="/announcements" element={<Announcements />} exact />
      <Route path="/attendance" element={<Attendance />} exact />
      <Route path="/schedule" element={<Schedule />} exact />
      <Route path="/grades" element={<Grades />} exact />
      <Route path="/fees" element={<Fees />} exact>
        <Route path="show-receipts" element={<PaymentDetails />} exact />
        <Route path="pay-fees" element={<PayFees />} exact />
      </Route>
    </Routes>
  );
}

export default SideMenuRouter;
