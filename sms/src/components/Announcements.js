import React, { useEffect, useState } from "react";
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
import { useDispatch } from "react-redux";
import { changeTitle } from "../features/navBarSlice";
import axios from "axios";

function createAnnoun(
  announId,
  announType,
  announContent,
  announTimestamp,
  orgId
) {
  return { announId, announType, announContent, announTimestamp, orgId };
}

function Announcements() {
  const [announs, setAnnouns] = useState([
    createAnnoun("", "", "", "", "", ""),
  ]);
  const [activeAnnoun, setActiveAnnoun] = useState(
    createAnnoun("", "", "", "", "", "")
  );
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(changeTitle({ title: "Announcements" }));
    axios.get("http://localhost:8080/announcement").then((res) => {
      let dataList = res.data.payload;
      let list = [];
      dataList.map((item) => {
        list.push(
          createAnnoun(
            item.announId,
            item.announType,
            item.announContent,
            item.announTimestamp,
            item.orgId
          )
        );
      });
      setAnnouns(list);
    });
  }, []);

  const handleAnnounClick = (e, item) => {
    setActiveAnnoun(item);
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
            {announs.map((item) => {
              const labelValue = `${item.announType}`;

              return (
                <>
                  <ListItem
                    disablePadding
                    key={item.announId}
                    id={item.announId}
                    onClick={(event) => {
                      handleAnnounClick(event, item);
                    }}
                    sx={{
                      bgcolor: `${
                        activeAnnoun.announId !== item.announId ? "" : "#393E46"
                      }`,
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
            bgcolor: "whKite",
            overflow: "auto",
          }}
        >
          <Typography
            variant="h5"
            align="center"
            sx={{ fontSize: "1.8rem", fontWeight: "600" }}
            gutterBottom
          >
            {activeAnnoun.announType}
          </Typography>
          <Typography
            variant="div2"
            sx={{ textAlign: "right", marginRight: "1rem" }}
          >
            {activeAnnoun.announTimestamp}
          </Typography>
          <Typography variant="div2">{activeAnnoun.announContent}</Typography>
        </Stack>
      </Stack>
    </Paper>
  );
}

export default Announcements;
