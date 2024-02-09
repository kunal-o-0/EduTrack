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

const Columns = [
  { id: "subject", label: "Subject", minWidth: "20rem", align: "center" },
  {
    id: "obtained_marks",
    label: "Obtained Marks",
    minWidth: "15rem",
    align: "center",
  },
  {
    id: "total_marks",
    label: "Total Marks",
    minWidth: "15rem",
    align: "center",
  },
  { id: "grades", label: "Grades", minWidth: "5rem", align: "center" },
];

function createData(subject, obtained_marks, total_marks, grades) {
  return { subject, obtained_marks, total_marks, grades };
}

function Grades() {
  const data = [
    createData("Maths", 553, 600, "A+"),
    createData("Science", 553, 600, "A+"),
    createData("History", 553, 600, "A+"),
    createData("Geography", 553, 600, "A+"),
    createData("Engineering Mathematics", 553, 600, "A+"),
    createData("English", 553, 600, "A+"),
    createData("Maths", 553, 600, "A+"),
    createData("Maths", 553, 600, "A+"),
    createData("Java", 553, 600, "A+"),
    createData("Python", 553, 600, "A+"),
    createData("Maths", 553, 600, "A+"),
    createData("HTML", 553, 600, "A+"),
  ];

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
              {data.map((row) => {
                return (
                  <TableRow>
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
          sx={{ marginTop: "1.5rem", bgcolor: Styles.colors.secondary }}
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
