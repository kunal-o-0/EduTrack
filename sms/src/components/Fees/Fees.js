import FeesMain from "./FeesMain";
import { Button, ButtonGroup, Paper, Stack, Typography } from "@mui/material";
import Styles from "../../assets/Style";
import { Link, Outlet } from "react-router-dom";
import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { changeTitle } from "../../features/navBarSlice";

function Fees() {
  const [status, setStatus] = useState("");
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(changeTitle({ title: "Fees" }));
  });

  return (
    <Paper
      sx={{
        position: "absolute",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        left: "9rem",
        top: "8rem",
        width: "85%",
        height: "80%",
        bgcolor: Styles.colors.primary,
        overflowY: "auto",
      }}
      elevation={0}
    >
      {status === "" ? <FeesMain statusHandler={setStatus} /> : <Outlet />}
    </Paper>
  );
}

export default Fees;
