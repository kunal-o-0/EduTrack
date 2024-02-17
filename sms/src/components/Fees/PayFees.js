import {
  Box,
  Button,
  Card,
  CardContent,
  Divider,
  Paper,
  Stack,
  Typography,
} from "@mui/material";
import Styles from "../../assets/Style";
import { useEffect, useState } from "react";
import { createPendingFeeObj, getPendingFees } from "../../services/student";

function PayFees() {
  //  creating pending fees state for storing list of pending fees
  const [pendingFees, setPendingFees] = useState([createPendingFeeObj()]);

  const loadPendingFees = () => {
    //  calling this function for fetching pending fees with student id=1
    getPendingFees(1).then((result) => {
      setPendingFees(result);
    });
  };

  useEffect(() => {
    loadPendingFees();
  }, []);

  return (
    <Paper
      sx={{
        width: "60rem",
        height: "100%",
        bgcolor: Styles.colors.primary,
      }}
    >
      <Typography
        variant="h3"
        component="p"
        align="center"
        sx={{ position: "sticky", fontSize: "2.3rem", fontWeight: "500" }}
        gutterBottom
      >
        Pay Pending Fees
      </Typography>
      {/* creating cards of pending fees based on the data fetched from DB */}
      {pendingFees
        .filter((pending) => {
          //  this filter is created so that pending fees having amount=0 will be skipped
          return parseFloat(pending.amount) !== 0;
        })
        .map((pending) => {
          //  mapping of objects in pendingFees array
          return (
            <Card
              sx={{
                padding: "0",
                marginBottom: "1rem",
              }}
              key={parseInt(pending.id)}
            >
              <CardContent
                sx={{
                  color: Styles.colors.primary,
                  bgcolor: Styles.colors.secondary,
                  padding: "0",
                  ":last-child": { padding: "0" },
                }}
              >
                <Stack
                  direction="row"
                  spacing={1}
                  sx={{ bgcolor: Styles.secondary }}
                >
                  <Stack
                    direction="column"
                    sx={{
                      bgcolor: Styles.colors.primary_dark,
                      minWidth: "9rem",
                      padding: "0.5rem",
                    }}
                  >
                    <Typography
                      variant="h5"
                      component="p"
                      align="center"
                      gutterBottom
                      sx={{ fontWeight: "600", fontSize: "1.4rem" }}
                    >
                      Amount
                      <br />
                      <br />₹ {pending.amount}
                    </Typography>
                    <Divider
                      variant="fullWidth"
                      sx={{ bgcolor: Styles.colors.secondary }}
                    />
                    <Typography
                      variant="body1"
                      align="center"
                      sx={{ marginTop: "0.5rem", fontSize: "1.1rem" }}
                    >
                      {pending.feesType}
                    </Typography>
                  </Stack>
                  <Box
                    sx={{
                      display: "flex",
                      alignItems: "center",
                      justifyContent: "center",
                      padding: "0.5rem",
                      width: "100%",
                    }}
                  >
                    <Button
                      variant="contained"
                      sx={{
                        bgcolor: Styles.colors.primary,
                        color: Styles.colors.primary_dark,
                        ":hover": { color: Styles.colors.primary },
                        width: "15rem",
                        height: "3rem",
                        fontSize: "1rem",
                        fontWeight: "900",
                      }}
                      onClick={() => {
                        alert("Redirecting...");
                      }}
                    >
                      Pay Now
                    </Button>
                  </Box>
                </Stack>
              </CardContent>
            </Card>
          );
        })}
    </Paper>
  );
}

export default PayFees;
