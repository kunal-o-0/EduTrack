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

function createCheck(amount, label, content) {
  return { amount, label, content };
}

function PayFees() {
  const data = [
    createCheck(6000, "Tuition", "Tuition fees paid"),
    createCheck(3000, "Tuition", "Tuition fees paid"),
    createCheck(500, "Exam", "Tuition fees paid"),
    createCheck(10, "Stationary", "Tuition fees paid"),
    createCheck(10000, "Course", "Tuition fees paid"),
    createCheck(200000, "Academics", "Tuition fees paid"),
    createCheck(53512, "Scholorship", "Tuition fees paid"),
  ];

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
      {data.map((check) => {
        return (
          <Card
            sx={{
              padding: "0",
              marginBottom: "1rem",
            }}
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
                    <br />₹ {check.amount}
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
                    {check.label}
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
