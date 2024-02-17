import {
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Typography,
} from "@mui/material";
import Styles from "../assets/Style";
import { useDispatch } from "react-redux";
import { useEffect, useState } from "react";
import { changeTitle } from "../features/navBarSlice";
import { getAttend, createAttendData } from "../services/student";
import { ATTEND_STATUS } from "../constants/student";

//  array of objects that contains column metadata
const columns = [
  {
    id: "date",
    label: "Date",
    align: "center",
    minWidth: "9rem",
  },
  {
    id: "day",
    label: "Day",
    align: "center",
    minWidth: "9rem",
  },
  {
    id: "status",
    label: "Status",
    align: "center",
    minWidth: "9rem",
  },
];

function Attendance() {
  //  state for storing fetched attendance data
  const [attends, setAttends] = useState([createAttendData()]);
  const dispatch = useDispatch();

  const loadAttendance = () => {
    //  call to service method for fetching attendance data
    getAttend(1).then((data) => {
      setAttends(data);
    });
  };

  useEffect(() => {
    dispatch(changeTitle({ title: "Attendance" }));
    loadAttendance();
  }, []);

  return (
    <Paper
      sx={{
        position: "absolute",
        width: "85%",
        left: "10rem",
        top: "9rem",
        overflowY: "auto",
      }}
      elevation={0}
    >
      <TableContainer sx={{ maxHeight: "45rem" }}>
        <Table stickyHeader>
          <TableHead>
            <TableRow>
              {columns.map((column) => {
                return (
                  <TableCell
                    align={column.align}
                    // key={column.id}
                    sx={{
                      bgcolor: `${Styles.colors.primary_dark}`,
                      color: `${Styles.colors.primary}`,
                      minWidth: column.minWidth,
                    }}
                  >
                    <Typography
                      variant="h5"
                      component="p"
                      sx={{ fontSize: "1.4rem", fontWeight: "900" }}
                    >
                      {column.label}
                    </Typography>
                  </TableCell>
                );
              })}
            </TableRow>
          </TableHead>
          <TableBody>
            {/* looping through fetched data and assigning with row */}
            {attends.map((row) => {
              return (
                <TableRow>
                  {/* iterating through local column array which contains columns metadata */}
                  {columns.map((column) => {
                    return (
                      <TableCell
                        align={column.align}
                        sx={{
                          bgcolor: `${
                            row.status === ATTEND_STATUS.PRESENT
                              ? Styles.colors.success
                              : Styles.colors.error
                          }`,
                          color: Styles.colors.primary,
                        }}
                      >
                        <Typography
                          variant="subtitle1"
                          component="p"
                          sx={{ fontSize: "1.1rem", fontWeight: "600" }}
                        >
                          {row[column.id]}
                        </Typography>
                      </TableCell>
                    );
                  })}
                </TableRow>
              );
            })}
          </TableBody>
        </Table>
      </TableContainer>
    </Paper>
  );
}

export default Attendance;

/* const data = [
  createData("24-05-2023", "Monday", "Present"),
  createData("27-12-2023", "Friday", "Present"),
  createData("15-08-2023", "Tuesday", "Absent"),
  createData("2-01-2023", "Wednesday", "Present"),
  createData("14-02-2023", "Tuesday", "Absent"),
  createData("04-05-2023", "Thursday", "Absent"),
  createData("24-05-2023", "Monday", "Present"),
  createData("27-12-2023", "Friday", "Present"),
  createData("15-08-2023", "Tuesday", "Absent"),
  createData("2-01-2023", "Wednesday", "Present"),
  createData("14-02-2023", "Tuesday", "Absent"),
  createData("04-05-2023", "Thursday", "Absent"),
  createData("24-05-2023", "Monday", "Present"),
  createData("27-12-2023", "Friday", "Present"),
  createData("15-08-2023", "Tuesday", "Absent"),
  createData("2-01-2023", "Wednesday", "Present"),
  createData("14-02-2023", "Tuesday", "Absent"),
  createData("04-05-2023", "Thursday", "Absent"),
]; */
