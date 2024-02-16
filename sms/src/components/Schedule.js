import { useEffect, useState } from "react";
import Styles from "../../src/assets/Style.js";
import {
  Box,
  Card,
  CardContent,
  Divider,
  List,
  ListItem,
  ListItemButton,
  Paper,
  Stack,
  Typography,
} from "@mui/material";
import { changeTitle } from "../features/navBarSlice.js";
import { useDispatch } from "react-redux";

function Schedule() {
  const [activeSched, setActiveSched] = useState("");
  const handleActiveSched = (id) => {
    setActiveSched(id);
  };
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(changeTitle({ title: "Schedule" }));
  });

  return (
    <Paper
      sx={{
        position: "absolute",
        marginLeft: "9rem",
        marginTop: "8rem",
        width: "85%",
        maxHeight: "45rem",
      }}
      elevation={12}
    >
      <Stack direction="row" sx={{ maxHeight: "45rem", minWidth: "60rem" }}>
        <Box
          sx={{
            bgcolor: Styles.colors.primary,
            width: "20vw",
            bgcolor: `${Styles.colors.primary_dark}`,
            overflowY: "auto",
            minWidth: "20rem",
          }}
        >
          <List disablePadding>
            {[
              { date: "23", month: "Jan", title: "Schedule 1" },
              { date: "25", month: "Jan", title: "Schedule 2" },
              { date: "14", month: "Feb", title: "Schedule 3" },
              { date: "1", month: "Aug", title: "Schedule 4" },
              { date: "23", month: "Jan", title: "Schedule 1" },
              { date: "25", month: "Jan", title: "Schedule 2" },
              { date: "14", month: "Feb", title: "Schedule 3" },
              { date: "1", month: "Aug", title: "Schedule 4" },
              { date: "23", month: "Jan", title: "Schedule 1" },
              { date: "25", month: "Jan", title: "Schedule 2" },
              { date: "14", month: "Feb", title: "Schedule 3" },
              { date: "1", month: "Aug", title: "Schedule 4" },
            ].map((schedule) => {
              return (
                <>
                  <ListItem
                    sx={{
                      width: "100%",
                      bgcolor: `${
                        activeSched !== schedule.title
                          ? Styles.colors.primary_dark
                          : Styles.colors.secondary_dark
                      }`,
                    }}
                    disablePadding
                    onClick={(e) => {
                      handleActiveSched(schedule.title);
                    }}
                  >
                    <ListItemButton disableRipple>
                      <Stack direction="row" spacing={2}>
                        <Stack
                          direction="column"
                          alignItems="center"
                          spacing={1}
                          sx={{
                            bgcolor: `${
                              activeSched === schedule.title
                                ? Styles.colors.primary
                                : Styles.colors.secondary
                            }`,
                            width: "4rem",
                          }}
                        >
                          <Typography
                            variant="h4"
                            component="p"
                            sx={{
                              color: `${
                                activeSched === schedule.title
                                  ? Styles.colors.primary_dark
                                  : Styles.colors.primary
                              }`,
                            }}
                          >
                            {schedule.date}
                          </Typography>

                          <Typography
                            variant="h6"
                            component="p"
                            sx={{
                              color: `${
                                activeSched === schedule.title
                                  ? Styles.colors.primary_dark
                                  : Styles.colors.primary
                              }`,
                            }}
                          >
                            {schedule.month}
                          </Typography>
                        </Stack>
                        <Box display="flex" alignItems="center">
                          <Typography
                            variant="h6"
                            component="p"
                            sx={{
                              color: `${Styles.colors.primary}`,
                              alignItems: "center",
                            }}
                          >
                            {schedule.title}
                          </Typography>
                        </Box>
                      </Stack>
                    </ListItemButton>
                  </ListItem>
                  <Divider color={Styles.colors.secondary_dark} />
                </>
              );
            })}
          </List>
        </Box>
        <Box sx={{ width: "100%", maxHeight: "45rem", bgcolor: "white" }}>
          <Stack>
            <Typography
              variant="h5"
              sx={{
                bgcolor: `${Styles.colors.secondary}`,
                color: `${Styles.colors.primary}`,
                fontSize: "28px",
                fontWeight: "600",
                height: "40px",
              }}
              align="center"
              gutterBottom
            >
              Heading
            </Typography>
            <Typography
              variant="h5"
              component="p"
              sx={{ fontSize: "18px", fontWeight: "600" }}
              align="center"
            >
              1 Jan 2023, Monday
            </Typography>
            <Box sx={{ padding: "1rem", overflow: "auto", maxHeight: "40rem" }}>
              {[
                { time: "9:00am - 11:00pm", details: "Schedule details" },
                { time: "9:00am - 11:00pm", details: "Schedule details" },
                { time: "9:00am - 11:00pm", details: "Schedule details" },
                { time: "9:00am - 11:00pm", details: "Schedule details" },
                { time: "9:00am - 11:00pm", details: "Schedule details" },
                { time: "9:00am - 11:00pm", details: "Schedule details" },
                { time: "9:00am - 11:00pm", details: "Schedule details" },
                { time: "9:00am - 11:00pm", details: "Schedule details" },
                { time: "9:00am - 11:00pm", details: "Schedule details" },
                { time: "9:00am - 11:00pm", details: "Schedule details" },
              ].map((schedule) => {
                return (
                  <Card
                    sx={{
                      bgcolor: `${Styles.colors.primary_dark}`,
                      color: `${Styles.colors.primary}`,
                      borderRadius: "0.8rem",
                      marginBottom: "0.6rem",
                    }}
                  >
                    <CardContent>
                      <Stack direction="row" spacing={3}>
                        <Typography variant="h6">{schedule.time}</Typography>
                        <Typography variant="h6" component="p">
                          {schedule.details}
                        </Typography>
                      </Stack>
                    </CardContent>
                  </Card>
                );
              })}
            </Box>
          </Stack>
        </Box>
      </Stack>
    </Paper>
  );
}

export default Schedule;
