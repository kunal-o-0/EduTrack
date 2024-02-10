import {
  Box,
  Card,
  CardContent,
  Divider,
  Paper,
  Stack,
  Typography,
} from "@mui/material";
import Styles from "../../assets/Style";

function createReceipt(amount, label, content) {
  return { amount, label, content };
}

function PaymentDetails() {
  const data = [
    createReceipt(6000, "Tuition", "Tuition fees paid"),
    createReceipt(3000, "Tuition", "Tuition fees paid"),
    createReceipt(500, "Exam", "Tuition fees paid"),
    createReceipt(10, "Stationary", "Tuition fees paid"),
    createReceipt(10000, "Course", "Tuition fees paid"),
    createReceipt(200000, "Academics", "Tuition fees paid"),
    createReceipt(53512, "Scholorship", "Tuition fees paid"),
  ];

  return (
    <Paper
      sx={{ width: "60rem", bgcolor: Styles.colors.primary, height: "100%" }}
      elevation={0}
    >
      <Typography
        variant="h3"
        component="p"
        align="center"
        sx={{ position: "sticky", fontSize: "2.3rem", fontWeight: "500" }}
        gutterBottom
      >
        Payment Receipts
      </Typography>
      {data.map((receipt) => {
        return (
          <Card
            sx={{
              marginTop: "1rem",
              borderRadius: "1rem",
              maxHeight: "10rem",
            }}
          >
            <CardContent sx={{ padding: "0", ":last-child": { padding: "0" } }}>
              <Stack
                direction="row"
                spacing={1}
                sx={{ bgcolor: Styles.colors.secondary }}
              >
                <Box
                  sx={{
                    padding: "0.5rem",
                    width: "20rem",
                    bgcolor: Styles.colors.primary_dark,
                    color: Styles.colors.primary,
                  }}
                >
                  <Stack direction="column">
                    <Typography
                      variant="h5"
                      component="p"
                      align="center"
                      sx={{ fontWeight: "600" }}
                      gutterBottom
                    >
                      Amount
                      <br />₹ {receipt.amount}
                    </Typography>
                    <Divider
                      variant="fullWidth"
                      sx={{ bgcolor: Styles.colors.secondary }}
                    />
                    <Typography
                      variant="subtitle1"
                      align="center"
                      sx={{ fontSize: "1.1rem", marginTop: "0.5rem" }}
                    >
                      {receipt.label}
                    </Typography>
                  </Stack>
                </Box>
                <Box
                  sx={{
                    padding: "0.5rem",
                    width: "100%",
                    maxHeight: "10rem",
                    overflowY: "scroll",
                  }}
                >
                  <Typography
                    variant="h6"
                    component="p"
                    sx={{ color: Styles.colors.primary, fontSize: "1rem" }}
                  >
                    Content
                    <br />
                    Content
                    <br />
                    Content
                    <br />
                    Content
                    <br />
                    Content
                    <br />
                    Content
                    <br />
                    Content
                    <br />
                    {receipt.content}
                    <br />
                  </Typography>
                </Box>
              </Stack>
            </CardContent>
          </Card>
        );
      })}
    </Paper>
  );
}

export default PaymentDetails;
