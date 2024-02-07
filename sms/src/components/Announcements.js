import React, { useState } from "react";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import {
  Button,
  List,
  ListItem,
  ListItemButton,
  ListItemIcon,
  ListItemText,
  Paper,
  Stack,
  Typography,
} from "@mui/material";
import Divider from "@mui/material/Divider";

function Announcements() {
  const [announ, setAnnoun] = useState("");

  const handleAnnounClick = (e) => {
    setAnnoun(`Hello ${e.target.value}`);
  };

  return (
    <Paper
      sx={{
        position: "absolute",
        marginTop: "150px",
        marginLeft: "200px",
        color: "#222831",
        width: "inherit",
      }}
      elevation={6}
    >
      <Stack direction="row">
        <Box
          sx={{
            width: "20vw",
            height: "700px",
            bgcolor: "#222831",
            color: "#EEEEEE",
            overflow: "auto",
          }}
        >
          <List>
            {[1, 2, 3, 4, 5].map((value) => {
              const labelValue = `Announcement ${value}`;

              return (
                <ListItem
                  disablePadding
                  key={value}
                  onClick={handleAnnounClick}
                >
                  <ListItemButton>
                    <ListItemText primary={labelValue} />
                  </ListItemButton>
                </ListItem>
              );
            })}
          </List>
        </Box>

        <Box sx={{ width: "60vw", bgcolor: "white" }}>
          <Typography variant="h5">{announ}</Typography>
        </Box>
      </Stack>
    </Paper>
  );
}

export default Announcements;
