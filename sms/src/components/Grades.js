import {
  Box,
  Button,
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
import { createGrade, getGrades } from "../services/student";

//  array of objects that describes column metadata
const Columns = [
  { id: "subject", label: "Subject", minWidth: "20rem", align: "center" },
  {
    id: "obtainedMarks",
    label: "Obtained Marks",
    minWidth: "15rem",
    align: "center",
  },
  {
    id: "totalMarks",
    label: "Total Marks",
    minWidth: "15rem",
    align: "center",
  },
  { id: "grades", label: "Grades", minWidth: "5rem", align: "center" },
];

function Grades() {
  //  state created for storing grades
  const [grades, setGrades] = useState([createGrade()]);
  const dispatch = useDispatch();

  function fetchGrades() {
    //  calling function for fetching grades by passing student id=1
    getGrades(1).then((result) => {
      setGrades(result);
    });
  }

  useEffect(() => {
    dispatch(changeTitle({ title: "Grades" }));
    fetchGrades();
  }, []);

  return (
    <Box
      sx={{
        position: "absolute",
        left: "9rem",
        top: "5rem",
        width: "85%",
      }}
    >
      <Typography
        variant="h3"
        align="center"
        sx={{ fontSize: "2rem", fontWeight: "900" }}
        gutterBottom
      >
        Course Name
      </Typography>
      <Paper sx={{ width: "100%" }}>
        <TableContainer sx={{ overflowY: "auto", maxHeight: "45rem" }}>
          <Table stickyHeader>
            <TableHead>
              <TableRow>
                {Columns.map((column) => {
                  return (
                    <TableCell
                      align={column.align}
                      key={column.id}
                      sx={{
                        minWidth: column.minWidth,
                        bgcolor: Styles.colors.primary_dark,
                      }}
                    >
                      <Typography
                        variant="h5"
                        component="p"
                        sx={{
                          fontSize: "1.5rem",
                          fontWeight: "600",
                          color: Styles.colors.primary,
                        }}
                      >
                        {column.label}
                      </Typography>
                    </TableCell>
                  );
                })}
              </TableRow>
            </TableHead>
            <TableBody>
              {/* Creating row with the help of map method of array and inserting it into table */}
              {grades.map((row) => {
                return (
                  <TableRow key={row.id}>
                    {Columns.map((column) => {
                      return (
                        <TableCell
                          align={
                            column.id === "subject" ? "left" : column.align
                          }
                        >
                          <Typography
                            variant="subtitle1"
                            component="p"
                            sx={{ fontSize: "1.1rem", fontWeight: "300" }}
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
      <Box display="flex" justifyContent="center">
        <Button
          variant="contained"
          sx={{ marginTop: "1rem", bgcolor: Styles.colors.secondary }}
        >
          <Typography variant="h6" sx={{ fontSize: "1rem", fontWeight: "900" }}>
            Generate Report
          </Typography>
        </Button>
      </Box>
    </Box>
  );
}

export default Grades;
