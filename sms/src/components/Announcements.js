import React, { useState } from "react";
import Box from "@mui/material/Box";
import {
  List,
  ListItem,
  ListItemButton,
  ListItemText,
  Paper,
  Stack,
  Typography,
} from "@mui/material";
import Divider from "@mui/material/Divider";

function Announcements() {
  const [announ, setAnnoun] = useState("");
  const [activeAnnoun, setActiveAnnoun] = useState();

  const handleAnnounClick = (e, id) => {
    setAnnoun(`${e.target.textContent}`);
    setActiveAnnoun(id);
  };

  return (
    <Paper
      sx={{
        position: "absolute",
        marginTop: "8rem",
        marginLeft: "9rem",
        color: "#222831",
        width: "inherit",
      }}
      elevation={12}
    >
      <Stack direction="row" spacing={2}>
        <Box
          sx={{
            width: "20vw",
            height: "700px",
            bgcolor: "#222831",
            color: "#EEEEEE",
            overflow: "auto",
          }}
        >
          <List disablePadding>
            {[
              1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2,
              3, 4, 5,
            ].map((value) => {
              const labelValue = `Announcement ${value}`;

              return (
                <>
                  <ListItem
                    disablePadding
                    id={value}
                    onClick={(event) => {
                      handleAnnounClick(event, value);
                    }}
                    sx={{
                      bgcolor: `${activeAnnoun !== value ? "" : "#393E46"}`,
                    }}
                  >
                    <ListItemButton disableRipple>
                      <ListItemText
                        primary={labelValue}
                        primaryTypographyProps={{
                          fontSize: "1.3rem",
                          fontWeight: "600",
                        }}
                      />
                    </ListItemButton>
                  </ListItem>
                  <Divider color="#393E46" variant="middle" />
                </>
              );
            })}
          </List>
        </Box>

        <Stack
          sx={{
            width: "60vw",
            height: "700px",
            bgcolor: "white",
            overflow: "auto",
          }}
        >
          <Typography
            variant="h5"
            align="center"
            sx={{ fontSize: "1.8rem", fontWeight: "600" }}
            gutterBottom
          >
            {announ}
          </Typography>
          <Typography variant="div2">
            Here you will see content of announcement
          </Typography>
        </Stack>
      </Stack>
    </Paper>
  );
}

export default Announcements;
