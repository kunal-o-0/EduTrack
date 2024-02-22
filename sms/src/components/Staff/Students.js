import {
  Box,
  Button,
  Menu,
  MenuItem,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Typography,
} from "@mui/material";
import styles from "../../assets/Style";
import { useState } from "react";
import { createStudObj, getStudents } from "../../services/student";
import { ArrowDropDown } from "@mui/icons-material";
import { Outlet, useNavigate } from "react-router-dom";

const studOptions = [
  { id: "edit", label: "Edit" },
  { id: "add_attend", label: "Add attendance" },
  { id: "add_grades", label: "Add grades" },
];

const tableColumns = [
  {
    id: "roll_no",
    label: "Roll no",
    align: "center",
  },
  {
    id: "name",
    label: "Name",
    align: "center",
  },
  {
    id: "mob_no",
    label: "Mobile no",
    align: "center",
  },
  {
    id: "email",
    label: "Email Id",
    align: "center",
  },
  {
    id: "options",
    label: "Options",
    align: "center",
  },
];

function Students() {
  const navigate = useNavigate();
  const [anchorEl, setAnchorEl] = useState(null);
  const [studentList, setStudentList] = useState([createStudObj()]);
  const [isStudOptionOpen, setIsStudOptionOpen] = useState(false);
  const [isUserNavigated, setIsUserNavigated] = useState(false);

  const handleOptionClose = (event, stud_id) => {
    console.log(event.target.id + " clicked");
    switch (event.target.id) {
      case "edit": {
        navigate("/staff-dashboard/students/edit-student", {
          state: { id: stud_id },
        });
        setIsUserNavigated(true);
        break;
      }
      case "add_attend": {
        navigate("/staff-dashboard/students/add-attendance");
        setIsUserNavigated(true);
        break;
      }
      case "add_grades": {
        navigate("/staff-dashboard/students/add-grade");
        setIsUserNavigated(true);
        break;
      }
      default: {
        setIsUserNavigated(false);
      }
    }
    setAnchorEl(null);
    setIsStudOptionOpen(false);
  };

  const handleOptionClick = (event) => {
    setIsStudOptionOpen(true);
    setAnchorEl(event.currentTarget);
  };

  const loadStudList = () => {
    getStudents().then((result) => {
      setStudentList(result);
    });
  };

  return (
    <Box sx={{ display: "flex", flexDirection: "column" }}>
      {isUserNavigated ? (
        <Outlet />
      ) : (
        <>
          <Box
            sx={{
              display: "flex",
              width: "100%",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            <Typography
              variant="h1"
              sx={{
                flexGrow: "1",
                textAlign: "center",
                fontSize: "2rem",
                fontWeight: "900",
                color: styles.colors.secondary_dark,
              }}
            >
              Students list
            </Typography>
            <Button
              variant="filled"
              sx={{
                flexGrow: "1",
                maxWidth: "15%",
                backgroundColor: styles.colors.secondary,
                color: styles.colors.primary,
                fontWeight: "900",
                height: "10%",
                borderRadius: "0",
                ":hover": { backgroundColor: styles.colors.primary_dark },
              }}
            >
              Add student
            </Button>
            <Button
              variant="outlined"
              sx={{
                flexGrow: "1",
                borderRadius: "0",
                maxWidth: "15%",
                height: "10%",
                color: styles.colors.secondary,
                fontWeight: "900",
                backgroundColor: styles.colors.primary,
                ":hover": {
                  backgroundColor: styles.colors.secondary_dark,
                },
              }}
              onClick={loadStudList}
            >
              Get Student List
            </Button>
          </Box>
          <Box sx={{ marginTop: "1rem" }}>
            <TableContainer
              component={Paper}
              sx={{ backgroundColor: styles.colors.primary_medium }}
            >
              <Table sx={{ width: "100%" }}>
                <TableHead>
                  <TableRow
                    sx={{
                      backgroundColor: styles.colors.secondary_dark,
                    }}
                  >
                    {tableColumns.map((column) => {
                      return (
                        <TableCell
                          align={column.align}
                          key={column.id}
                          sx={{
                            color: styles.colors.primary,
                            fontWeight: "600",
                            fontSize: "1.3rem",
                          }}
                        >
                          {column.label}
                        </TableCell>
                      );
                    })}
                  </TableRow>
                </TableHead>
                <TableBody>
                  {studentList.map((stud) => {
                    return (
                      <TableRow sx={{ backgroundColor: styles.colors.primary }}>
                        <TableCell align="center">{stud.roll_no}</TableCell>
                        <TableCell align="center">{`${
                          stud.first_name +
                          " " +
                          stud.middle_name +
                          " " +
                          stud.last_name
                        }`}</TableCell>
                        <TableCell align="center">{stud.mob_no}</TableCell>
                        <TableCell align="center">{stud.email}</TableCell>
                        <TableCell align="center">
                          <div>
                            <Button
                              endIcon={<ArrowDropDown />}
                              onClick={handleOptionClick}
                              sx={{ color: styles.colors.secondary }}
                            >
                              Options
                            </Button>
                            <Menu
                              anchorEl={anchorEl}
                              open={isStudOptionOpen}
                              onClose={() => {
                                setIsStudOptionOpen(false);
                              }}
                              MenuListProps={{
                                sx: {
                                  backgroundColor: styles.colors.primary,
                                  color: styles.colors.secondary_dark,
                                },
                              }}
                            >
                              {studOptions.map((option) => {
                                return (
                                  <MenuItem
                                    id={option.id}
                                    onClick={(event) => {
                                      handleOptionClose(event, stud.id);
                                    }}
                                  >
                                    {option.label}
                                  </MenuItem>
                                );
                              })}
                            </Menu>
                          </div>
                        </TableCell>
                      </TableRow>
                    );
                  })}
                </TableBody>
              </Table>
            </TableContainer>
          </Box>
        </>
      )}
    </Box>
  );
}

export default Students;
