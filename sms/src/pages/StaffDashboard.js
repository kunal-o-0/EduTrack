import {
  AppBar,
  Box,
  Button,
  Drawer,
  IconButton,
  List,
  ListItem,
  Toolbar,
  Tooltip,
  Typography,
} from "@mui/material";
import { Menu, Close, Logout } from "@mui/icons-material";
import Styles from "../assets/Style";
import { useState } from "react";
import Students from "../components/Staff/Students";
import Announcements from "../components/Staff/Announcements";
import Courses from "../components/Staff/Courses";
import { Outlet, useNavigate } from "react-router-dom";

const drawerList = [
  { id: "students", label: "Students" },
  { id: "courses", label: "Courses" },
  { id: "announcements", label: "Announcements" },
];

function StaffDashboard() {
  const navigate = useNavigate();
  const [open, setOpen] = useState(false);
  const [activeTab, setActiveTab] = useState("students");

  const handleClose = () => {
    setOpen(false);
  };

  const handleDrawerOpen = () => {
    setOpen(!open);
  };

  const handleDrawerItemClick = (event) => {
    switch (event.target.id) {
      case "students": {
        navigate("students");
        break;
      }
      case "courses": {
        navigate("courses");
        break;
      }
      case "announcements": {
        navigate("announcements");
        break;
      }
    }
    handleClose();
  };

  return (
    <Box
      sx={{
        width: "100%",
        backgroundColor: Styles.colors.primary,
        display: "flex",
      }}
    >
      <AppBar
        position="fixed"
        sx={{ backgroundColor: Styles.colors.secondary }}
      >
        <Toolbar sx={{ display: "flex", padding: { md: "0rem", lg: "0rem" } }}>
          <IconButton
            onClick={handleDrawerOpen}
            size="large"
            sx={{ padding: "0.5rem" }}
          >
            <Menu
              sx={{
                color: Styles.colors.primary,
                fontSize: "2.5rem",
              }}
            />
          </IconButton>
          <Typography variant="h3" sx={{ flexGrow: "1" }}>
            {activeTab}
          </Typography>
          <Tooltip title="Logut">
            <IconButton
              size="large"
              sx={{ position: "absolute", padding: "0.5rem", right: "0rem" }}
              onClick={() => {
                navigate("/login-register");
              }}
            >
              <Logout
                sx={{
                  color: Styles.colors.primary_dark,
                  fontSize: "2.5rem",
                  ":hover": { color: Styles.colors.error },
                }}
              />
            </IconButton>
          </Tooltip>
        </Toolbar>
      </AppBar>
      <Box sx={{ width: "100%", marginTop: "4.1rem", padding: "0.9rem" }}>
        <Outlet />
      </Box>
      <Drawer
        variant="temporary"
        open={open}
        PaperProps={{
          sx: { width: "30%", backgroundColor: Styles.colors.primary },
        }}
      >
        <IconButton
          onClick={handleClose}
          sx={{
            width: "5%",
            marginLeft: "93%",
            marginTop: "0.3rem",
            padding: "0px",
          }}
        >
          <Close />
        </IconButton>
        <List
          sx={{
            width: "100%",
            display: "flex",
            flexDirection: "column",
          }}
        >
          {drawerList.map((item) => {
            return (
              <Button
                key={item.id}
                id={item.id}
                sx={{
                  width: "100%",
                  color: Styles.colors.secondary_dark,
                  backgroundColor: Styles.colors.primary,
                  fontSize: "1.1rem",
                  textTransform: "none",
                }}
                onClick={handleDrawerItemClick}
              >
                {item.label}
              </Button>
            );
          })}
        </List>
        <Typography
          sx={{
            width: "100%",
            position: "absolute",
            bottom: "0.5rem",
            fontSize: "0.9rem",
            textAlign: "center",
          }}
        >
          Copyrights© SMS 2024. All rights reserved.
        </Typography>
      </Drawer>
    </Box>
  );
}

export default StaffDashboard;
